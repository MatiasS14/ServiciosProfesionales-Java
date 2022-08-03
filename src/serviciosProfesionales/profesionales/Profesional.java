package serviciosProfesionales.profesionales;
import java.util.Set;

import serviciosProfesionales.Universidad;

public abstract class Profesional {
	protected Universidad  universidad;
		
	public Profesional(Universidad universidad) {
		this.universidad = universidad;
	}
	
	public Universidad universidad() {
		return this.universidad;
	}

	public abstract Integer honorariosPorHora() ;
	public abstract Set<String> provinciasParaTrabajar() ;
	public abstract void cobrar(Integer dinero) ;
	public abstract Integer totalRecaudado () ;
	
	
	
}
