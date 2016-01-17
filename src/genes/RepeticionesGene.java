package genes;

import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.IntegerGene;

import model.Objetivo;

public class RepeticionesGene extends IntegerGene implements IBrofitGene {

	protected static final long serialVersionUID = 1L;

	public RepeticionesGene(Configuration a_config, int a_lowerBounds, int a_upperBounds)
			throws InvalidConfigurationException {
		super(a_config, a_lowerBounds, a_upperBounds);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getEstresAsociado(Objetivo objetivo, RepeticionesGene duracion) {
		return 0.0f;
	}
	
	protected Gene newGeneInternal() {
		try {
			RepeticionesGene result = new RepeticionesGene(getConfiguration(), getLowerBounds(),getUpperBounds());
			return result;
		}
		catch (InvalidConfigurationException iex) {
			throw new IllegalStateException(iex.getMessage());
		}
	}
	
	public Boolean equals(RepeticionesGene other) {
		return super.equals((IntegerGene) other);
	}
	
	public int compareTo(RepeticionesGene other) {
		return super.compareTo((IntegerGene) other);
	}

}
