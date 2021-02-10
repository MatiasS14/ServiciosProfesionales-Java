package serviciosProfesionales;
import java.util.Set;
import java.util.HashSet;

public class ProfesionalVinculadoUniversidad extends Profesional{
	
	public ProfesionalVinculadoUniversidad(Universidad universidad) {
		super(universidad);
	}

	@Override
	public Integer honorariosPorHora() {
		return this.universidad.honorariosRecomendados();
	}

	@Override
	public Set<String> provinciasParaTrabajar() {
		HashSet<String> ret = new HashSet<String>();
		ret.add(this.universidad.provincia());
		return ret;
	}

	@Override
	public void cobrar(Integer dinero) {
		this.universidad.recibirDonacion(dinero/2);		
	}

	@Override
	public Integer totalRecaudado() {
		return 0;
	}

}
