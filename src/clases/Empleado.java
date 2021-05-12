package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import enumeraciones.Tema;

public class Empleado {

	protected String nombre;
	protected ArrayList<Capacitacion> capacitaciones;
	
	public int creditosObtenidos () {
		
		return capacitaciones.stream().map((e) -> e.obtenerCreditos()).reduce(0, (acum, e) -> acum+e);
	}
	
	public double calcularCostos() {
		return capacitaciones.stream().map(e -> e.obtenerCosto()).reduce(0.0, (acum,e) -> acum+e);
	}
	
	public double calcularPromedioCapacitaciones() {
		return this.calcularCostos()/capacitaciones.size();
	}
	
	public List<Capacitacion> filtrarCapacitaciones(Predicate<Capacitacion> filtro) {
		return capacitaciones.stream().filter(filtro).collect(Collectors.toList());
	}
	
	public List<Capacitacion> capacitacionesPorTema(Tema tema) {
		return filtrarCapacitaciones(e -> e.tema.equals(tema)).stream().sorted((e1, e2) -> e1.obtenerCosto().compareTo(e2.obtenerCosto())*-1).collect(Collectors.toList());
	}
	
	public Optional<Docente> obtenerProfesorMayorCreditos() {
		
		Optional<Capacitacion> maximo = capacitaciones.stream().filter(e -> e.getCreditosRequeridos() >= 0)
		.max((e1,e2) -> e1.getCreditosRequeridos().compareTo(e2.getCreditosRequeridos()));
		
		if(maximo.isPresent()) return Optional.ofNullable(((Curso) maximo.get()).docente);
		
		return Optional.empty();
	}
	
	public List<Capacitacion> obtenerCapacitacionesPrioritarias() {
		return filtrarCapacitaciones(e -> e.prioritaria);
	}
	
	public List<Capacitacion> obtenerCapacitacionesPorCreditosDecreciente() {
		return capacitaciones.stream().sorted((e1,e2) -> e1.obtenerCreditos().compareTo(e2.obtenerCreditos())*-1).collect(Collectors.toList());
	}
	
	
}
