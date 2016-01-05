package genes;

import org.jgap.Configuration;
import org.jgap.InvalidConfigurationException;

import model.Ejercicio;
import model.TamanoGMuscular;

public class GenG extends BrofitGene {

	private static final long serialVersionUID = 1L;

	public GenG(Configuration a_config, int a_lowerBounds, int a_upperBounds) throws InvalidConfigurationException {
		super(a_config, a_lowerBounds, a_upperBounds);
	}

	@Override
	protected void poblarAlelos() {
		this.addAlleles(Ejercicio.findEjerciciosByTamano(TamanoGMuscular.GRANDE));
		// TODO: Determinar si los MUY GRANDES tambien deben incluirse
		// this.addAlleles(Ejercicio.findEjerciciosByTamano(TamanoGMuscular.MUY_GRANDE));
	}
	
}
