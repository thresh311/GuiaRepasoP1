package clases;

import java.util.*;
import java.util.stream.Collectors;

import excepciones.CreditosInsuficientesException;
import excepciones.TallerCompletoException;

public class Alumno {

	protected String matricula;
	protected String nombre;
	protected ArrayList<Capacitacion> aprobadas;
	protected ArrayList<Capacitacion> enCurso;
	
	public int creditosObtenidos () {
		
		return aprobadas.stream().map((e) -> e.obtenerCreditos()).reduce(0, (acum, e) -> acum+e);
	}
	
	public void inscribir(Capacitacion c) {
		try {
			c.inscribir(this);
			enCurso.add(c);
			
		} catch (CreditosInsuficientesException | TallerCompletoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public void aprobar(Capacitacion c) {
		enCurso = (ArrayList<Capacitacion>) enCurso.stream().filter(e -> !e.equals(c)).collect(Collectors.toList());
		aprobadas.add(c);
		c.aprobar(this);
		

	}
}
