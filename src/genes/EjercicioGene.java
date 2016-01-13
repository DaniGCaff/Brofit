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

public abstract class EjercicioGene extends SetGene implements IBrofitGene {

	protected static final long serialVersionUID = 1L;

	protected EntityManager em;
	protected DuracionGene DuracionGene;
	protected Rutina rutina;
	protected int minRepeticiones;
	protected int maxRepeticiones;
	
	public DuracionGene getDuracionGene() {
		return DuracionGene;
	}

	public void setDuracionGene(DuracionGene duracionGene) {
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

	public EjercicioGene(Rutina rutina, Configuration a_config, int minRepeticiones, int maxRepeticiones, EntityManager em)
			throws InvalidConfigurationException {
		super(a_config);
		this.rutina = rutina;
		this.minRepeticiones = minRepeticiones;
		this.maxRepeticiones = maxRepeticiones;
		this.DuracionGene = new DuracionGene(a_config, minRepeticiones, maxRepeticiones);
		this.em = em;
		poblarAlelos();
	}

	protected abstract void poblarAlelos();
	
	public float getEstresAsociado(Objetivo objetivo) {
		int idEjercicio = (int) this.getAllele();
		int tamanoMuscular = em.find(Ejercicio.class, idEjercicio).getGmuscular().getTamano();
		int tipoEjercicio = em.find(Ejercicio.class, idEjercicio).getTipoEjercicio();
		int idObjetivo = objetivo.getIdObjetivos();
		int repeticiones = (int) this.getDuracionGene().getAllele();
		int series = em.find(DatosObjetivo.class, new DatosObjetivoPK(idObjetivo, tamanoMuscular, tipoEjercicio)).getNumeroSeries();
		EstresEjercicioPK pk = new EstresEjercicioPK(idEjercicio, idObjetivo, repeticiones, series);
		EstresEjercicio estres = em.find(EstresEjercicio.class, pk);
		return estres.getSeries();
	}
}
