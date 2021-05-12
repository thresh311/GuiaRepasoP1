package clases;

import excepciones.TallerCompletoException;

public class Taller extends Capacitacion {

	public int duracion;
	public double costoPorHora;
	public int  cupoMaximo;
	public int cantInscriptos;
	
	

	public Integer obtenerCreditos() {
		if(duracion/6 > 12) {
			return 12;
		}
		
		if(prioritaria) return duracion/6 + 1;
		
		return duracion/6;
	}


	@Override
	public Double obtenerCosto() {
		// TODO Auto-generated method stub
		if(prioritaria) return costoPorHora * duracion * 1.2;
		
		return costoPorHora * duracion;
	}


	@Override
	public Integer getCreditosRequeridos() {
		return -1;
	}


	@Override
	public boolean inscribir(Alumno alumno) throws TallerCompletoException {
		if(cantInscriptos == cupoMaximo) throw new TallerCompletoException();
		cantInscriptos++;
		return true;
	}


	@Override
	public void aprobar(Alumno alumno) {
		cantInscriptos--;
	}
	
	
	
}
