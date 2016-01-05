package genes;

import javax.persistence.EntityManager;

import org.jgap.Configuration;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.IntegerGene;
import org.jgap.impl.SetGene;

public abstract class BrofitGene extends SetGene  {

	private static final long serialVersionUID = 1L;

	private int minEjercicios, maxEjercicios;
	
	public BrofitGene(Configuration a_config, int minEjercicios, int maxEjercicios)
			throws InvalidConfigurationException {
		super(a_config);
		this.minEjercicios = minEjercicios;
		this.maxEjercicios = maxEjercicios;
		poblarAlelos();
		// TODO Auto-generated constructor stub
	}

	protected abstract void poblarAlelos();
}
