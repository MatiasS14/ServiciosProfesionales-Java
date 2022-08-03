package serviciosProfesionales;

import org.junit.platform.commons.util.StringUtils;

import serviciosProfesionales.borradores.BorradorUniversidad;
import serviciosProfesionales.errores.ErrorUniversidad;

public class Universidad {
	private String provincia;
	private Integer honorariosRecomendados;
	private Integer donacionesRecibidas;
	
	public Universidad(BorradorUniversidad universidad)throws ErrorUniversidad {
		if(verificarUniversidad(universidad)) {
		 this.provincia = universidad.provincia;
		 this.honorariosRecomendados = universidad.honorarios;
		 this.donacionesRecibidas = 0;
		}
	}
	
	private Boolean verificarUniversidad(BorradorUniversidad universidad) throws ErrorUniversidad{
		Boolean ret = false;
		if(StringUtils.isBlank(universidad.provincia)) {
			throw new ErrorUniversidad("El nombre de provincia esta vacio");
		}else {ret=true;}
		if(universidad.honorarios < 1 || universidad.honorarios == null) {
			throw new ErrorUniversidad("Los honorarios deben ser mayor a 1");
		}else {ret=true;}
		
	  return ret;
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
