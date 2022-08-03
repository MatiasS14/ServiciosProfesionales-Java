package serviciosProfesionales.solicitantes;

import serviciosProfesionales.profesionales.Profesional;

public abstract class Solicitante {
	public Solicitante() {}
	
	public abstract Boolean puedeSerAtendidoPor(Profesional prof);
}
