package serviciosProfesionalesTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import serviciosProfesionales.*;
import org.junit.jupiter.api.BeforeEach;
import java.util.Set;
import java.util.HashSet;

class TestServiciosProfesionales {
	//Universidades
	Universidad universidadSanMartin;
	Universidad universidadRosario;
	Universidad universidadCorrientes;
	Universidad universidadHurlingam;
	
	//Asociacion del Litoral
	AsociacionProfesionalesDelLitoral asocLitoral;
	
	//Profesionales
	Profesional juana;
	Profesional melina;
	ProfesionalLibre rocio; //es necesario que sea ProfesionalLibre
							//para pasar dinero a otro profesional
	ProfesionalLibre luciana;
	
	//Provincias para profesionales libres
	Set<String> provinciasRocio;
	Set<String> provinciasLuciana;
	
	//Empresa
	Empresa empresa;
	
	@BeforeEach
	void setup() {
		
		//Creacion de universidades
//	de San Martín: está en la provincia de Buenos Aires, los honorarios recomendados son de 3500 pesos.
		universidadSanMartin = new Universidad("Buenos Aires",3500);
//	de Rosario: está en la provincia de Santa Fe, los honorarios recomendados son de 2800 pesos.
		universidadRosario = new Universidad("Santa Fe", 200);
//	de Corrientes: está en la provincia de Corrientes, los honorarios recomendados son de 4200 pesos.
		universidadCorrientes = new Universidad("Corrientes", 4200);
//	de Hurlingham: está en la provincia de Buenos Aires, los honorarios recomendados son de 8800 pesos.
		universidadHurlingam = new Universidad("Buenos Aires", 8800);
//////////////////////////////////////////////////////////////////////////////////////
		asocLitoral = new AsociacionProfesionalesDelLitoral();
//////////////////////////////////////////////////////////////////////////////////////
		//provincias
		provinciasRocio = new HashSet<String>();
		provinciasRocio.add("Santa Fe");
		provinciasRocio.add("Cordoba");
		provinciasRocio.add("Buenos Aires");
		
		provinciasLuciana = new HashSet<String>();
		provinciasLuciana.add("Santa Fe");
		provinciasLuciana.add("Entre Rios");
//////////////////////////////////////////////////////////////////////////////////////		
		//Creacion de profesionales
//	Juana, vinculada, estudió en la Univ. de Rosario.
		juana = new ProfesionalVinculadoUniversidad(universidadRosario);
//	Melina, asociada el Litoral, estudió en la Univ. de Corrientes.
		melina = new ProfesionalAsiociadoDelLitoral(universidadCorrientes, asocLitoral);
//	Rocío, libre, estudió en la Univ. de Hurlingham, honorarios 5000 pesos, puede trabajar en Santa Fe, Córdoba y Buenos Aires.
		rocio = new ProfesionalLibre(universidadHurlingam, provinciasRocio, 5000);
//	Luciana, libre, estudió en la Univ. de Rosario, honorarios 3200 pesos, puede trabajar en Santa Fe y Entre Ríos.
		luciana= new ProfesionalLibre(universidadRosario, provinciasLuciana, 3200);
//////////////////////////////////////////////////////////////////////////////////////
		//Empresa
		empresa = new Empresa(3500);
		//La empresa contrata profesionales
		empresa.contratarProfesional(juana);
		empresa.contratarProfesional(melina);
		empresa.contratarProfesional(rocio);
		empresa.contratarProfesional(luciana);
	}
	
	@Test
	void testProfesionalesCaros() {
		assertTrue(empresa.profesionalesCaros().contains(rocio));
		assertFalse(empresa.profesionalesCaros().contains(juana));
		assertFalse(empresa.profesionalesCaros().contains(melina));
		assertFalse(empresa.profesionalesCaros().contains(luciana));
	}
	
	@Test
	void testUniversidadesFormadoras() {
		assertTrue(empresa.universidadesFormadoras().contains(universidadRosario));
		assertTrue(empresa.universidadesFormadoras().contains(universidadCorrientes));
		assertTrue(empresa.universidadesFormadoras().contains(universidadHurlingam));
		assertFalse(empresa.universidadesFormadoras().contains(universidadSanMartin));
	}
	
	@Test
	void testProfesionalMasBarato() {
		assertEquals(empresa.profesionalMasBarato(), juana);
	}
	
	@Test
	void testProvinciasCubiertas() {
		assertTrue(empresa.estaCubierta("Santa Fe"));
		assertTrue(empresa.estaCubierta("Cordoba"));
		assertFalse(empresa.estaCubierta("Misiones"));
	}
	
	@Test
	void testProfesionalesDeUniversidad() {
		assertEquals(2, empresa.profesionalesDeUniversidad(universidadRosario));
		assertEquals(1, empresa.profesionalesDeUniversidad(universidadHurlingam));
		assertEquals(0, empresa.profesionalesDeUniversidad(universidadSanMartin));
	}
	
	@Test
	void testCobros() {
		
//		########### Profesional vinculado ###########
		//juana es profesional vinculada a universidad
		//de lo que cobra dona la mitad a la universidad
		//y el resto lo gasta
		juana.cobrar(5000);
		assertEquals(0, juana.totalRecaudado());
		assertEquals(2500, juana.universidad().donacionesRecibidas());
		
//		########### Profesional asociado ###########
		//melina es profesional asociada al litoral
		//de lo que cobra dona todo a la asociacion
		melina.cobrar(5000);
		assertEquals(0, melina.totalRecaudado());
		assertEquals(5000, asocLitoral.donacionesRecibidas());
		
//		########### Profesional libre ###########
		//rocio es profesional libre
		//se guarda el total de lo cobrado
		rocio.cobrar(5000);
		assertEquals(5000, rocio.totalRecaudado());
		
		//Rocio le pasa dinero a juana
		rocio.pasarDinero(2000, juana);
		//se resta el dinero dado de lo recaudado de rocio
		assertEquals(3000, rocio.totalRecaudado());
		//juana da la mitad a la universidad y el resto lo gasta
		assertEquals(0, juana.totalRecaudado());
		assertEquals(3500, juana.universidad().donacionesRecibidas());
		
		
	}

}
