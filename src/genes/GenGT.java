package genes;

import org.jgap.Configuration;
import org.jgap.InvalidConfigurationException;

import model.Ejercicio;
import model.TamanoGMuscular;

public class GenGT extends BrofitGene {

	public GenGT(Configuration a_config, int a_lowerBounds, int a_upperBounds) throws InvalidConfigurationException {
		super(a_config, a_lowerBounds, a_upperBounds);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void poblarAlelos() {
		this.addAlleles(Ejercicio.findEjerciciosByGMuscular("Triceps"));
		this.addAlleles(Ejercicio.findEjerciciosByTamano(TamanoGMuscular.GRANDE));
	}
}
