package serviciosProfesionales.profesionales;

import java.util.Set;

import serviciosProfesionales.Universidad;
import serviciosProfesionales.borradores.BorradorProfesionalLibre;
import serviciosProfesionales.errores.ErrorAsociacionDelLitoral;
import serviciosProfesionales.errores.ErrorProfesional;

public class ProfesionalLibre extends Profesional{
	private Set<String> provincias;
	private Integer honorarios;
	private Integer totalRecaudado = 0;
	
	public ProfesionalLibre(BorradorProfesionalLibre prof) throws ErrorProfesional{
		super(prof.universidad);
		verificarProf(prof);
		this.provincias = prof.provincias;
		this.honorarios = prof.honorarios;
	}
	
	private void verificarProf(BorradorProfesionalLibre prof)throws ErrorProfesional {
		if(prof.provincias.size() < 1) {
		  throw new ErrorProfesional("El profesional debe poder trabajar en al menos una provincia");
		}
		if(prof.honorarios < 1 || prof.honorarios == null) {
			throw new ErrorProfesional("Los honorarios deben ser mayor a 0");
		}
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
	
	public void pasarDinero(Integer dinero, Profesional prof) throws ErrorAsociacionDelLitoral{
		this.totalRecaudado -= dinero;
		prof.cobrar(dinero);
	}
	
	
}
