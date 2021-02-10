package serviciosProfesionales;

public class AsociacionProfesionalesDelLitoral {
	private Integer donacionesRecibidas;
	
	public AsociacionProfesionalesDelLitoral() {
		this.donacionesRecibidas = 0;
	}
	
	public void recibirDonacion(Integer dinero) {
		this.donacionesRecibidas += dinero;
	}

	public Integer donacionesRecibidas() {
		return this.donacionesRecibidas;
	}
}
