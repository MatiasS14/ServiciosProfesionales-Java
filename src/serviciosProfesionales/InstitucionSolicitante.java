package serviciosProfesionales;
import java.util.Set;

public class InstitucionSolicitante extends Solicitante{
	private Set<Universidad> universidades;
	
	public InstitucionSolicitante(Set<Universidad> universidades) {
		this.universidades = universidades;
	}

	@Override
	public Boolean puedeSerAtendidoPor(Profesional prof) {
		return this.universidades.contains(prof.universidad());
	}
}
