package genes;

import org.jgap.Configuration;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.IntegerGene;

import model.Objetivo;

public class DuracionGene extends IntegerGene implements IBrofitGene {

	protected static final long serialVersionUID = 1L;

	public DuracionGene(Configuration a_config, int a_lowerBounds, int a_upperBounds)
			throws InvalidConfigurationException {
		super(a_config, a_lowerBounds, a_upperBounds);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getEstresAsociado(Objetivo objetivo) {
		return 0.0f;
	}

}
