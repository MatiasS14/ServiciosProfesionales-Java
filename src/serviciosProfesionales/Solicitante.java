package serviciosProfesionales;

public abstract class Solicitante {
	public Solicitante() {}
	
	public abstract Boolean puedeSerAtendidoPor(Profesional prof);
}
