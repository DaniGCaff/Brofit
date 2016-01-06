package controller;

import javax.persistence.EntityManager;

public class Controller {
	protected EntityManager em;
	
	public Controller(EntityManager em) {
		this.em = em;
	}
	
}
