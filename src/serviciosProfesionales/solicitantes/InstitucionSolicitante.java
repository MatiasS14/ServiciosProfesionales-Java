package serviciosProfesionales.solicitantes;
import java.util.Set;

import serviciosProfesionales.Universidad;
import serviciosProfesionales.borradores.BorradorInstitucionSolicitante;
import serviciosProfesionales.errores.ErrorInstitucionSolicitante;
import serviciosProfesionales.profesionales.Profesional;

public class InstitucionSolicitante extends Solicitante{
	private Set<Universidad> universidades;
	
	public InstitucionSolicitante(BorradorInstitucionSolicitante institucion) throws ErrorInstitucionSolicitante {
		verificarInstitucion(institucion);
		this.universidades = institucion.universidades;
	}

	private void verificarInstitucion(BorradorInstitucionSolicitante institucion)throws ErrorInstitucionSolicitante {
		if(institucion.universidades.size() == 0) {
			throw new ErrorInstitucionSolicitante("La institucion debe poseer al menos una universidad");
			}
	}
	@Override
	public Boolean puedeSerAtendidoPor(Profesional prof) {
		return this.universidades.contains(prof.universidad());
	}
}
