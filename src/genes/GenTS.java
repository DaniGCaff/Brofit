package genes;

import org.jgap.Configuration;
import org.jgap.InvalidConfigurationException;

import model.Ejercicio;
import model.TrenCorporal;

public class GenTS extends BrofitGene {

	public GenTS(Configuration a_config, int a_lowerBounds, int a_upperBounds) throws InvalidConfigurationException {
		super(a_config, a_lowerBounds, a_upperBounds);
	}

	@Override
	protected void poblarAlelos() {
		this.addAlleles(Ejercicio.findEjerciciosByTren(TrenCorporal.INFERIOR));
	}
	
}
