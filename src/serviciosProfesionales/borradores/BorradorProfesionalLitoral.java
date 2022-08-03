package serviciosProfesionales.borradores;

import serviciosProfesionales.AsociacionProfesionalesDelLitoral;
import serviciosProfesionales.Universidad;

public class BorradorProfesionalLitoral {
	public Universidad universidad;
	public AsociacionProfesionalesDelLitoral asociacion;
	
	public BorradorProfesionalLitoral(Universidad universidad, AsociacionProfesionalesDelLitoral asociacion) {
		this.universidad = universidad;
		this.asociacion = asociacion;
	}
}
