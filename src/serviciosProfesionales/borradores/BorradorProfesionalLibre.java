package serviciosProfesionales.borradores;

import java.util.Set;

import serviciosProfesionales.Universidad;

public class BorradorProfesionalLibre {
	public Universidad universidad;
	public Set<String> provincias;
	public Integer honorarios;
	
	public BorradorProfesionalLibre(Universidad universidad, Set<String> provincias, Integer honorarios) {
		this.universidad = universidad;
		this.provincias  = provincias ;
		this.honorarios  = honorarios ;
	}

}
