package com.bd.medico2025.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.medico2025.modelo.TblMedico;
import com.bd.medico2025.repositorio.IMedicoRepositorio;

@Service
public class MedicoServicioImp implements IMedicoServicio {

	//	se aplica la inyeccion de dependencia
	@Autowired	//	esta anotacion habilita la inyeccion de dependencia
	private IMedicoRepositorio imedicorepositorio;
	
	@Override
	public void RegistrarMedico(TblMedico tblmedico) {
		
		//	invocamos el metodo registrar
		imedicorepositorio.save(tblmedico);
		
	}	//	fin del metodo registrar

	@Override
	public void EliminarMedico(TblMedico tblmedico) {
		
		//	invocamos el metodo elminiar
		imedicorepositorio.deleteById(tblmedico.getIdmedicot3());
		
	}	//	fin del metodo eliminar

	@Override
	public List<TblMedico> ListadoMedicos() {
		
		//	invocamos el metodo listado
		return (List<TblMedico>) imedicorepositorio.findAll();
		
	}	//	fin del metodo listar

	@Override
	public TblMedico buscarporId(Integer id) {
		
		// invoco el metodo buscar
		return imedicorepositorio.findById(id).orElse(null);
		
	}	// 	fin del metodo buscar

}	//	fin del metodo principal
