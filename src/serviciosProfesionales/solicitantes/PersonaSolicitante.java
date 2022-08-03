package serviciosProfesionales.solicitantes;

import org.junit.platform.commons.util.StringUtils;

import serviciosProfesionales.borradores.BorradorPersonaSolicitante;
import serviciosProfesionales.errores.ErrorPersonaSolicitante;
import serviciosProfesionales.profesionales.Profesional;

public class PersonaSolicitante extends Solicitante{
	private String provincia;
	
	public PersonaSolicitante(BorradorPersonaSolicitante solicitante)throws ErrorPersonaSolicitante {
		verificarSolicitante(solicitante);
		this.provincia = solicitante.provincia;
	}
	
	private void verificarSolicitante(BorradorPersonaSolicitante solicitante)throws ErrorPersonaSolicitante {
		if(StringUtils.isBlank(solicitante.provincia)) {throw new ErrorPersonaSolicitante("La provincia del solicitante no debe estar vacia");}
	}

	@Override
	public Boolean puedeSerAtendidoPor(Profesional prof) {
		return prof.provinciasParaTrabajar().contains(this.provincia);
	}

}
