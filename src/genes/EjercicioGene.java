package genes;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.SetGene;

import model.DatosObjetivo;
import model.DatosObjetivoPK;
import model.Ejercicio;
import model.EstresEjercicio;
import model.EstresEjercicioPK;
import model.Objetivo;
import model.Rutina;
import model.TamanoGMuscular;

public abstract class EjercicioGene extends SetGene implements IBrofitGene {

	protected static final long serialVersionUID = 1L;

	protected EntityManager em;
	protected RepeticionesGene DuracionGene;
	protected Rutina rutina;
	protected int minRepeticiones;
	protected int maxRepeticiones;
	protected int diaRutina;
	
	public RepeticionesGene getDuracionGene() {
		return DuracionGene;
	}

	public void setDuracionGene(RepeticionesGene duracionGene) {
		DuracionGene = duracionGene;
	}
	
	@Override
	public void addAlleles(@SuppressWarnings("rawtypes") Collection alleles) {
		super.addAlleles(alleles);
	}
	
	public void addAllele(Object allele) {
		Ejercicio ejercicio = em.find(Ejercicio.class,(Integer)allele);
		if(rutina.isEjercicioFiltrado(ejercicio))
			super.addAllele(allele);
	}
	
	public EjercicioGene(Rutina rutina, Configuration a_config, int minRepeticiones, int maxRepeticiones, EntityManager em, int diaRutina)
			throws InvalidConfigurationException {
		super(a_config);
		this.rutina = rutina;
		this.minRepeticiones = minRepeticiones;
		this.maxRepeticiones = maxRepeticiones;
		this.DuracionGene = new RepeticionesGene(a_config, minRepeticiones, maxRepeticiones);
		this.em = em;
		this.diaRutina = diaRutina;
		poblarAlelos();
	}

	protected abstract void poblarAlelos();
	
	public float getEstresAsociado(Objetivo objetivo, RepeticionesGene duracion) {
		int idEjercicio = (int) this.getAllele();
		int tamanoMuscular = em.find(Ejercicio.class, idEjercicio).getGmuscular().getTamano();
		int tipoEjercicio = em.find(Ejercicio.class, idEjercicio).getTipoEjercicio();
		int idObjetivo = objetivo.getIdObjetivos();
		int repeticiones = (int) duracion.getAllele();
		int series = em.find(DatosObjetivo.class, new DatosObjetivoPK(idObjetivo, tamanoMuscular, tipoEjercicio)).getNumeroSeries();
		EstresEjercicioPK pk = new EstresEjercicioPK(idEjercicio, repeticiones, series);
		EstresEjercicio estres = em.find(EstresEjercicio.class, pk);
		return estres.getEstresEjercicio();
	}

	public int getDiaRutina() {
		return diaRutina;
	}

	public void setDiaRutina(int diaRutina) {
		this.diaRutina = diaRutina;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Rutina getRutina() {
		return rutina;
	}

	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}

	public int getMinRepeticiones() {
		return minRepeticiones;
	}

	public void setMinRepeticiones(int minRepeticiones) {
		this.minRepeticiones = minRepeticiones;
	}

	public int getMaxRepeticiones() {
		return maxRepeticiones;
	}

	public void setMaxRepeticiones(int maxRepeticiones) {
		this.maxRepeticiones = maxRepeticiones;
	}
	
}
