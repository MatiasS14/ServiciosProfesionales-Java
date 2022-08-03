package serviciosProfesionalesTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import serviciosProfesionales.*;
import serviciosProfesionales.borradores.BorradorEmpresa;
import serviciosProfesionales.borradores.BorradorInstitucionSolicitante;
import serviciosProfesionales.borradores.BorradorPersonaSolicitante;
import serviciosProfesionales.borradores.BorradorProfesionalLibre;
import serviciosProfesionales.borradores.BorradorProfesionalLitoral;
import serviciosProfesionales.borradores.BorradorProfesionalUniversidad;
import serviciosProfesionales.borradores.BorradorUniversidad;
import serviciosProfesionales.errores.ErrorAsociacionDelLitoral;
import serviciosProfesionales.errores.ErrorEmpresa;
import serviciosProfesionales.errores.ErrorInstitucionSolicitante;
import serviciosProfesionales.errores.ErrorPersonaSolicitante;
import serviciosProfesionales.errores.ErrorProfesional;
import serviciosProfesionales.errores.ErrorUniversidad;
import serviciosProfesionales.profesionales.Profesional;
import serviciosProfesionales.profesionales.ProfesionalAsiociadoDelLitoral;
import serviciosProfesionales.profesionales.ProfesionalLibre;
import serviciosProfesionales.profesionales.ProfesionalVinculadoUniversidad;
import serviciosProfesionales.solicitantes.InstitucionSolicitante;
import serviciosProfesionales.solicitantes.PersonaSolicitante;

import org.junit.jupiter.api.BeforeEach;
import java.util.Set;
import java.util.HashSet;

class TestServiciosProfesionales {
	
	//Borradores universidades
	BorradorUniversidad borradorUniversidadSanMartin;
	BorradorUniversidad borradorUniversidadRosario;
	BorradorUniversidad borradorUniversidadCorrientes;
	BorradorUniversidad borradorUniversidadHurlingam;
	//Universidades
	Universidad universidadSanMartin;
	Universidad universidadRosario;
	Universidad universidadCorrientes;
	Universidad universidadHurlingam;
	
	//Asociacion del Litoral
	AsociacionProfesionalesDelLitoral asocLitoral;
	
	//Borradores profesionales
	BorradorProfesionalUniversidad borradorJuana;
	BorradorProfesionalLitoral borradorMelina;
	BorradorProfesionalLibre borradorRocio; 
	BorradorProfesionalLibre borradorLuciana;
	
	
	//Profesionales
	Profesional juana;
	Profesional melina;
	ProfesionalLibre rocio; //es necesario que sea ProfesionalLibre
							//para pasar dinero a otro profesional
	ProfesionalLibre luciana;
	
	//Provincias para profesionales libres
	Set<String> provinciasRocio;
	Set<String> provinciasLuciana;
	
	//Borrador empresa
	BorradorEmpresa borradorEmpresaFalla; 
	BorradorEmpresa borradorEmpresa; 
	
	//Empresa
	Empresa empresaFalla;
	Empresa empresa;
	
	//Universidades para instituciones
	Set<Universidad> universidadesInst1;
	Set<Universidad> universidadesInst2;
	
	//Borradores solicitantes
	BorradorInstitucionSolicitante borradorInstitucion1;//puede ser atendida
	BorradorInstitucionSolicitante borradorInstitucion2;//no puede ser atendida
	
	BorradorPersonaSolicitante borradorPersonaSolicitante1;//puede ser atendida
	BorradorPersonaSolicitante borradorPersonaSolicitante2;//no puede ser atendida
	
	//Solicitantes
	InstitucionSolicitante institucion1;//puede ser atendida
	InstitucionSolicitante institucion2;//no puede ser atendida
	
	PersonaSolicitante personaSolicitante1;//puede ser atendida
	PersonaSolicitante personaSolicitante2;//no puede ser atendida
	
	
	@BeforeEach
	void setup() throws ErrorEmpresa,ErrorUniversidad, ErrorProfesional, ErrorPersonaSolicitante, ErrorInstitucionSolicitante{
		
		//Borradores universidades
		borradorUniversidadSanMartin = new BorradorUniversidad("Buenos Aires", 3500);
		borradorUniversidadRosario= new BorradorUniversidad("Santa Fe", 2800);
		borradorUniversidadCorrientes= new BorradorUniversidad("Corrientes", 4200);		
		borradorUniversidadHurlingam = new BorradorUniversidad("Buenos Aires", 8800);
		
		//Creacion de universidades
//	de San Martín: está en la provincia de Buenos Aires, los honorarios recomendados son de 3500 pesos.
		universidadSanMartin = new Universidad(borradorUniversidadSanMartin);
//	de Rosario: está en la provincia de Santa Fe, los honorarios recomendados son de 2800 pesos.
		universidadRosario = new Universidad(borradorUniversidadRosario);
//	de Corrientes: está en la provincia de Corrientes, los honorarios recomendados son de 4200 pesos.
		universidadCorrientes = new Universidad(borradorUniversidadCorrientes);
//	de Hurlingham: está en la provincia de Buenos Aires, los honorarios recomendados son de 8800 pesos.
		universidadHurlingam = new Universidad(borradorUniversidadHurlingam);
//////////////////////////////////////////////////////////////////////////////////////
		asocLitoral = new AsociacionProfesionalesDelLitoral();
//////////////////////////////////////////////////////////////////////////////////////
		//provincias
		provinciasRocio = new HashSet<String>();
		provinciasRocio.add("Santa Fe");
		provinciasRocio.add("Cordoba");
		provinciasRocio.add("Buenos Aires");
		provinciasRocio.add("Entre Rios");
		
		provinciasLuciana = new HashSet<String>();
		provinciasLuciana.add("Santa Fe");
		provinciasLuciana.add("Entre Rios");
//////////////////////////////////////////////////////////////////////////////////////
		//Borradores profesionales
		borradorJuana = new BorradorProfesionalUniversidad(universidadRosario);
		borradorMelina = new BorradorProfesionalLitoral(universidadCorrientes, asocLitoral);
		borradorRocio = new BorradorProfesionalLibre(universidadHurlingam, provinciasRocio, 5000);
		borradorLuciana= new BorradorProfesionalLibre(universidadRosario, provinciasLuciana, 3200);
		//Creacion de profesionales
//	Juana, vinculada, estudió en la Univ. de Rosario.
		juana = new ProfesionalVinculadoUniversidad(borradorJuana);
//	Melina, asociada el Litoral, estudió en la Univ. de Corrientes.
		melina = new ProfesionalAsiociadoDelLitoral(borradorMelina);
//	Rocío, libre, estudió en la Univ. de Hurlingham, honorarios 5000 pesos, puede trabajar en Santa Fe, Córdoba y Buenos Aires.
		rocio = new ProfesionalLibre(borradorRocio); 
//	Luciana, libre, estudió en la Univ. de Rosario, honorarios 3200 pesos, puede trabajar en Santa Fe y Entre Ríos.
		luciana= new ProfesionalLibre(borradorLuciana);
//
//////////////////////////////////////////////////////////////////////////////////////
		//Borrador empresa
		borradorEmpresa = new BorradorEmpresa(3500);
		//Empresa
		
		empresa = new Empresa(borradorEmpresa);
		//La empresa contrata profesionales
		empresa.contratarProfesional(juana);
		empresa.contratarProfesional(melina);
		empresa.contratarProfesional(rocio);
		empresa.contratarProfesional(luciana);
//////////////////////////////////////////////////////////////////////////////////////
		//Universidades para Instituciones
		universidadesInst1 = new HashSet<Universidad>();
		universidadesInst1.add(universidadRosario);
		universidadesInst1.add(universidadHurlingam);
		universidadesInst1.add(universidadSanMartin);

		universidadesInst2 = new HashSet<Universidad>();
		universidadesInst2.add(universidadSanMartin);
//////////////////////////////////////////////////////////////////////////////////////
		//Borradores instituciones
		borradorInstitucion1 = new BorradorInstitucionSolicitante(universidadesInst1);
		borradorInstitucion2 = new BorradorInstitucionSolicitante(universidadesInst2);
		//Instituciones 
		institucion1 = new InstitucionSolicitante(borradorInstitucion1);
		institucion2 = new InstitucionSolicitante(borradorInstitucion2);
//////////////////////////////////////////////////////////////////////////////////////
		//Borrador persona solicitante
		borradorPersonaSolicitante1 = new BorradorPersonaSolicitante("Buenos Aires");
		borradorPersonaSolicitante2 = new BorradorPersonaSolicitante("La Rioja");
		//Personas solicitantes
		personaSolicitante1 = new PersonaSolicitante(borradorPersonaSolicitante1);
		personaSolicitante2 = new PersonaSolicitante(borradorPersonaSolicitante2);
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
	void testCobros() throws ErrorAsociacionDelLitoral{
		
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
	@Test
	void testSolicitantes() {
		//institucion1 puede ser atendida por la empresa
		assertTrue(empresa.satisfaceA(institucion1));
		//institucion2 no puede ser atendida por la empresa
		assertFalse(empresa.satisfaceA(institucion2));
		
		//personaSolicitante1 puede ser atendida por la empresa
		assertTrue(empresa.satisfaceA(personaSolicitante1));
		//personaSolicitante2 no puede ser atendida por la empresa
		assertFalse(empresa.satisfaceA(personaSolicitante2));
	}
	
	@Test
	void testRegistroDeTrabajosRealizados() throws ErrorEmpresa,ErrorAsociacionDelLitoral{
		//empresa da servicio a institucion1
		assertFalse(empresa.esCliente(institucion1));
		empresa.darServicio(institucion1);
		assertTrue(empresa.esCliente(institucion1));
		//ahora empresa trata de dar servicio a institucion 2
		//pero no puede
		try{
			empresa.darServicio(institucion2);
		}catch(ErrorEmpresa e) {
			System.out.println(e);			
		}
		
		//empresa da servicio a personaSolicitante1
		assertFalse(empresa.esCliente(personaSolicitante1));
		empresa.darServicio(personaSolicitante1);
		assertTrue(empresa.esCliente(personaSolicitante1));
		//ahora empresa trata de dar servicio a personaSolicitante2
		//pero no puede
		try{
			empresa.darServicio(personaSolicitante2);
		}catch(ErrorEmpresa e) {
			System.out.println(e);			
		}
		//si le preguntamos a la empresa la cantidad 
		//de clientes, debe dar 2, siendo que solo
		//pudo atender a insitucion1 y personaSolicitante1
		assertEquals(2, empresa.cantidadDeClientes());
		
		//determina si institucion1 es cliente de empresa
		assertTrue(empresa.esCliente(institucion1));
		//determina si institucion2 es cliente de empresa
		assertFalse(empresa.esCliente(institucion2));
		//determina si personaSolicitante1 es cliente de empresa
		assertTrue(empresa.esCliente(personaSolicitante1));
		//determina si personaSolicitante2 es cliente de empresa
		assertFalse(empresa.esCliente(personaSolicitante2));
	}
	
	@Test
	void testEmpresa(){
		//test de metodos que quedaron sin testear
		//Juana no es poco atractiva
		assertFalse(empresa.esPocoAtractivo(juana));		
		//Luciana es poco atractiva
		assertTrue(empresa.esPocoAtractivo(luciana));
		
	}
	
	@Test
	void testErrorCrearEmpresa() {
		//Lanza error al tratar crear empresa con honorarios no validos
		borradorEmpresaFalla = new BorradorEmpresa(0);
		try {
		empresaFalla = new Empresa(borradorEmpresaFalla);
		}catch(ErrorEmpresa e) {System.out.println(e);}
	}

}
