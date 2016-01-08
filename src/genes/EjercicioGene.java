package genes;

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

public abstract class EjercicioGene extends SetGene implements IBrofitGene {

	protected static final long serialVersionUID = 1L;

	protected EntityManager em;
	private DuracionGene DuracionGene;
	
	public DuracionGene getDuracionGene() {
		return DuracionGene;
	}

	public void setDuracionGene(DuracionGene duracionGene) {
		DuracionGene = duracionGene;
	}

	public EjercicioGene(Configuration a_config, int minRepeticiones, int maxRepeticiones, EntityManager em)
			throws InvalidConfigurationException {
		super(a_config);
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
