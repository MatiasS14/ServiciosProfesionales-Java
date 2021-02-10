package serviciosProfesionales;

public class PersonaSolicitante extends Solicitante{
	private String provincia;
	
	public PersonaSolicitante(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public Boolean puedeSerAtendidoPor(Profesional prof) {
		return prof.provinciasParaTrabajar().contains(this.provincia);
	}

}
