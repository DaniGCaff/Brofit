package genes;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.jgap.Configuration;
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
	private DuracionGene DuracionGene;
	private Rutina rutina;
	
	public DuracionGene getDuracionGene() {
		return DuracionGene;
	}

	public void setDuracionGene(DuracionGene duracionGene) {
		DuracionGene = duracionGene;
	}
	
	@Override
	public void addAlleles(@SuppressWarnings("rawtypes") Collection alleles) {
		super.addAlleles(alleles);
		// TODO solo debe admitir lo que estan dentro de la tabla de filtrados.
	}

	public EjercicioGene(Rutina rutina, Configuration a_config, int minRepeticiones, int maxRepeticiones, EntityManager em)
			throws InvalidConfigurationException {
		super(a_config);
		this.rutina = rutina;
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
