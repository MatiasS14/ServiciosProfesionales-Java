package serviciosProfesionales.profesionales;

import java.util.Set;

import serviciosProfesionales.Universidad;

public class ProfesionalLibre extends Profesional{
	private Set<String> provincias;
	private Integer honorarios;
	private Integer totalRecaudado = 0;
	
	public ProfesionalLibre(Universidad universidad, Set<String> provincias, Integer honorarios) {
		super(universidad);
		this.provincias = provincias;
		this.honorarios = honorarios;
	}

	@Override
	public Integer honorariosPorHora() {
		return this.honorarios;
	}

	@Override
	public Set<String> provinciasParaTrabajar() {
		return this.provincias;
	}

	@Override
	public void cobrar(Integer dinero) {
		this.totalRecaudado+= dinero;
	}

	@Override
	public Integer totalRecaudado() {
		return this.totalRecaudado;
	}
	
	public void pasarDinero(Integer dinero, Profesional prof) {
		this.totalRecaudado -= dinero;
		prof.cobrar(dinero);
	}
	
	
}
