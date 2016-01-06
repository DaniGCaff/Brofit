package genes;

import org.jgap.Gene;

import model.Objetivo;

public interface IBrofitGene extends Gene {
	public float getEstresAsociado(Objetivo objetivo);
}
