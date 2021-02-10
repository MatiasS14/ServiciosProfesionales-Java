package serviciosProfesionales;
import java.util.Set;
import java.util.HashSet;

public class ProfesionalAsiociadoDelLitoral extends Profesional{
	private Set<String> provinciasParaTrabajar;
	private AsociacionProfesionalesDelLitoral asociacion;
	
	public public ProfesionalAsiociadoDelLitoral(Universidad universidad,
												AsociacionProfesionalesDelLitoral asociacion) {
		super(universidad);
		this.asociacion = asociacion;
		
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
	public void cobrar(Integer dinero) {
		this.asociacion.recibirDonacion(dinero);
	}

	@Override
	public Integer totalRecaudado() {
		return 0;
	}
	
}
