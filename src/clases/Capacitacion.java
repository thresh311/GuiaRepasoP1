package clases;

import enumeraciones.Tema;

public abstract class Capacitacion {

	protected String nombre;
	protected boolean prioritaria;
	protected Tema tema;
	
	
	public abstract Integer obtenerCreditos();
	
	public abstract Double obtenerCosto();
	
	public abstract Integer getCreditosRequeridos();
	
}
