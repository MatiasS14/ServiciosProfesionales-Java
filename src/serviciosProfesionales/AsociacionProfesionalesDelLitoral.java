package serviciosProfesionales;

import serviciosProfesionales.errores.ErrorAsociacionDelLitoral;

public class AsociacionProfesionalesDelLitoral {
	private Integer donacionesRecibidas;
	
	public AsociacionProfesionalesDelLitoral() {
		this.donacionesRecibidas = 0;
	}
	
	public void recibirDonacion(Integer dinero)throws ErrorAsociacionDelLitoral {
		if(dinero > 0 && dinero != null) {
		 this.donacionesRecibidas += dinero;
		}else {
			throw new ErrorAsociacionDelLitoral("La donacion debe ser mayo a 0");
		}
	}

	public Integer donacionesRecibidas() {
		return this.donacionesRecibidas;
	}
}
