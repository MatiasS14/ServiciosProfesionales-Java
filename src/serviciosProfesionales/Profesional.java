package serviciosProfesionales;
import java.util.Set;

public abstract class Profesional {
	private Universidad  universidad;
		
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
