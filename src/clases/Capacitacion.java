package clases;

import enumeraciones.Tema;
import excepciones.CreditosInsuficientesException;
import excepciones.TallerCompletoException;

public abstract class Capacitacion {

	protected String nombre;
	protected boolean prioritaria;
	protected Tema tema;
	
	
	public abstract Integer obtenerCreditos();
	
	public abstract Double obtenerCosto();
	
	public abstract Integer getCreditosRequeridos();

	public abstract boolean inscribir(Alumno alumno) throws CreditosInsuficientesException, TallerCompletoException;
	
	public abstract void aprobar(Alumno alumno);

}
