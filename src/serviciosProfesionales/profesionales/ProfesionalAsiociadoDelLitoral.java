package serviciosProfesionales.profesionales;
import java.util.Set;

import serviciosProfesionales.AsociacionProfesionalesDelLitoral;
import serviciosProfesionales.Universidad;
import serviciosProfesionales.borradores.BorradorProfesionalLitoral;
import serviciosProfesionales.errores.ErrorAsociacionDelLitoral;

import java.util.HashSet;

public class ProfesionalAsiociadoDelLitoral extends Profesional{
	private Set<String> provinciasParaTrabajar;
	private AsociacionProfesionalesDelLitoral asociacion;
	
	public ProfesionalAsiociadoDelLitoral(BorradorProfesionalLitoral prof) {
		super(prof.universidad);
		this.asociacion = prof.asociacion;
		
		this.provinciasParaTrabajar = new HashSet<String>();
		this.provinciasParaTrabajar.add("Entre Rios");
		this.provinciasParaTrabajar.add("Santa Fe");
		this.provinciasParaTrabajar.add("Corrientes");
	}
	@Override
	public Integer honorariosPorHora() {
		return 3000;
	}

	@Override
	public Set<String> provinciasParaTrabajar() {
		return this.provinciasParaTrabajar;
	}

	@Override
	public void cobrar(Integer dinero)throws ErrorAsociacionDelLitoral{
		this.asociacion.recibirDonacion(dinero);
	}

	@Override
	public Integer totalRecaudado() {
		return 0;
	}

}
