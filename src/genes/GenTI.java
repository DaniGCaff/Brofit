package genes;

import org.jgap.Configuration;
import org.jgap.InvalidConfigurationException;

import model.Ejercicio;
import model.TamanoGMuscular;
import model.TrenCorporal;

public class GenTI extends BrofitGene {

	public GenTI(Configuration a_config, int a_lowerBounds, int a_upperBounds) throws InvalidConfigurationException {
		super(a_config, a_lowerBounds, a_upperBounds);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void poblarAlelos() {
		this.addAlleles(Ejercicio.findEjerciciosByTren(TrenCorporal.SUPERIOR));
	}

}
