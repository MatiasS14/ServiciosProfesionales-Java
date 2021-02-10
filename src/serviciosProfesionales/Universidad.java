package serviciosProfesionales;

public class Universidad {
	private String provincia;
	private Integer honorariosRecomendados;
	private Integer donacionesRecibidas;
	
	public Universidad(String provincia, Integer honorarios) {
		this.provincia = provincia;
		this.honorariosRecomendados = honorarios;
		this.donacionesRecibidas = 0;
	}
	
	public String provincia() {
		return this.provincia;
	}

	public Integer honorariosRecomendados() {
		return this.honorariosRecomendados;
	}
	
	public void recibirDonacion(Integer dinero) {
		this.donacionesRecibidas += dinero;
	}
	
	public Integer donacionesRecibidas() {
		return this.donacionesRecibidas;
	}
	
	
}
