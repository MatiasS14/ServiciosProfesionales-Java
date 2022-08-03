package serviciosProfesionales;
import java.util.Set;

import serviciosProfesionales.profesionales.Profesional;
import serviciosProfesionales.solicitantes.Solicitante;

import java.util.HashSet;

public class Empresa {
	private Set<Profesional> profesionales;
	private Set<Solicitante> clientes;
	private Integer honorarioRecomendado;
	
	public Empresa(Integer honorarioRecomendado) {
		this.profesionales = new HashSet<Profesional>();
		this.clientes= new HashSet<Solicitante>();
		this.honorarioRecomendado = honorarioRecomendado;
	}
	
	public void contratarProfesional(Profesional prof) {
		this.profesionales.add(prof);
	}
	
	public Set<Profesional> profesionalesCaros(){
		Set<Profesional> ret = new HashSet<Profesional>();
		for(Profesional prof : this.profesionales) {
			if(prof.honorariosPorHora() > this.honorarioRecomendado) {
				ret.add(prof);
			}
		}
	 return ret;
	}
	
	public Set<Universidad> universidadesFormadoras(){
		Set<Universidad> ret = new HashSet<Universidad>();
		for(Profesional prof : this.profesionales) {
			ret.add(prof.universidad());
		}
	  return ret;
	}
	
	public Profesional profesionalMasBarato() {
		Profesional ret= null;
		for (Profesional prof : this.profesionales) {
			if(ret == null) {
				ret = prof;
			}
			if(prof.honorariosPorHora() < ret.honorariosPorHora()) {
				ret = prof;
			}
		}
		return ret;
	}
	
	public Boolean estaCubierta(String provincia) {
		Boolean ret = false;
		for(Profesional prof : this.profesionales) {
			ret = ret || puedeTrabajarEn(prof, provincia);
		}
	 return ret;
	}
	
	private Boolean puedeTrabajarEn(Profesional prof, String provincia) {
		return prof.provinciasParaTrabajar().contains(provincia);
	}
	
	public Integer profesionalesDeUniversidad(Universidad universidad) {
		Integer ret = 0;
		for(Profesional prof : this.profesionales) {
			if(prof.universidad() == universidad) {
				ret++;
			}
		}
		return ret;
	}
	
	public Boolean esPocoAtractivo(Profesional prof) {
		Boolean ret = true;
		for(String provincia : prof.provinciasParaTrabajar()) {
			ret = ret && (this.alguienMasCubre(prof, provincia) && alguienCobraMenos(provincia, prof));
		}
		
		return ret;
	}
	
//	//proposito: determina si alguien mas cubre la provincia
	private Boolean alguienMasCubre(Profesional prof, String provincia) {
		Boolean ret = false;
		for(Profesional profesional : this.profesionales) {
			ret = ret || this.puedeTrabajarEn(profesional, provincia) && prof != profesional; 
		}
	 return ret;
	}
	
	//proposito : determina si hay alguien que trabaje en cierta provincia
	//            que cobre menos que prof
	private Boolean alguienCobraMenos(String provincia, Profesional prof) {
		Boolean ret = false;
		for(Profesional profesional : this.profesionalesProvincia(provincia)) {
			ret = ret || profesional.honorariosPorHora() < prof.honorariosPorHora();
		}
	 return ret;	
	}
	//proposito : retorna una lista de los profesionales 
	//			  que trbaja en cierta provincia
	private Set<Profesional> profesionalesProvincia(String provincia){
		Set<Profesional> ret = new HashSet<Profesional>();
		for(Profesional prof : this.profesionales) {
			if(prof.provinciasParaTrabajar().contains(provincia)) {
				ret.add(prof);
			}
		}
	 return ret;
	}
	
	public Boolean satisfaceA(Solicitante solicitante) {
		Boolean ret = false;
		for(Profesional prof : this.profesionales) {
			ret = ret || solicitante.puedeSerAtendidoPor(prof);
		}
		
		return ret;
	}
	
	public void darServicio(Solicitante solicitante) {
		if(this.satisfaceA(solicitante)) {
			Profesional prof = profesionalQueAtiendeA(solicitante);
			prof.cobrar(prof.honorariosPorHora());
			this.clientes.add(solicitante);			
		}else {
			throw new RuntimeException("El solicitante no puede ser atendido");
		}
	}
	
	private Profesional profesionalQueAtiendeA(Solicitante solicitante) {
		Profesional ret = null;
		for(Profesional prof : this.profesionales) {
			if(ret == null) {
				if(solicitante.puedeSerAtendidoPor(prof)) {
					ret = prof;
				}
			}
		}
	 return ret;
	}
	
	public Integer cantidadDeClientes(){
		return this.clientes.size();
	}
	
	public Boolean esCliente(Solicitante solicitante) {
		return this.clientes.contains(solicitante);
	}
}
