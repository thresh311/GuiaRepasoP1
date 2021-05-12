package clases;

import java.util.ArrayList;

import excepciones.CreditosInsuficientesException;

public class Curso extends Capacitacion {

	protected Docente docente;
	protected int cantClases;
	protected int duracionClases;
	protected Integer creditosReq;

	public Integer obtenerCreditos() {
		int total = 0;
		
		if(cantClases * 2 > 10) {
			total += 10;
		} else {
			total += cantClases*2;
		}
		
		if(docente.antiguedad < 6) {
			total += 1;
		} else if (docente.antiguedad < 16) {
			total += 3;
		} else {
			total += 5;
		} 
		
		if(prioritaria) total += 2;
		
		return total;
		
	}

	@Override
	public Double obtenerCosto() {
		
		if(prioritaria) return docente.costoXHora * cantClases * duracionClases * 1.1 * cantClases * duracionClases;
		
		return docente.costoXHora * cantClases * duracionClases;
	}

	@Override
	public Integer getCreditosRequeridos() {
		return this.creditosReq;
	}

	@Override
	public void inscribir(Alumno alumno) throws CreditosInsuficientesException {
		if(alumno.creditosObtenidos() < creditosReq) throw new CreditosInsuficientesException();
		
	}

	@Override
	public void aprobar(Alumno alumno) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
