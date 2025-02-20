package com.bd.medico2025.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.medico2025.modelo.TblMedico;
import com.bd.medico2025.servicio.IMedicoServicio;

@Controller
@RequestMapping("/Vistas")
public class MedicoController {
	
	@Autowired
	private IMedicoServicio imedicoservicio;

	@GetMapping("ListadoMedicos")
	public String listarMedicos(Model modelo) {
		
		// Recuperar lista
		List<TblMedico> listado = imedicoservicio.ListadoMedicos();
		// Enviar a vista
		modelo.addAttribute("listado", listado);
		return "/Vistas/ListadoMedicos";

	}
	
	@GetMapping("/RegistrarMedico")
	public String RegistrarMedico(Model modelo) {
		
		//Instanciar clase medico
		TblMedico tblmed = new TblMedico();
		modelo.addAttribute("regmedico", tblmed);
		return "/Vistas/FrmRegMedico";
		
	}
	
	@PostMapping("/GuardarMedico")
	public String GuardarMedico(@ModelAttribute TblMedico tblmed, Model modelo) {
		
		imedicoservicio.RegistrarMedico(tblmed);
		System.out.println("Registrado en BD");
		return "redirect:/Vistas/ListadoMedicos";
		
	}
	
	@GetMapping("/Editarmedico/{id}")
	public String Editar(@PathVariable("id") Integer idmedicot3, Model modelo) {
		
		TblMedico clmedico = imedicoservicio.buscarporId(idmedicot3);
		modelo.addAttribute("regmedico", clmedico);
		return "/Vistas/FrmRegMedico";
		
	}
	
	@GetMapping("/Eliminarmedico/{id}")
	public String eliminar(@PathVariable("id") Integer idmedicot3, Model modelo) {
		
		//Instanciar clase producto
		TblMedico tblmed = new TblMedico();
		tblmed.setIdmedicot3(idmedicot3);
		imedicoservicio.EliminarMedico(tblmed);
		//Actualizar listado
		List<TblMedico> listado = imedicoservicio.ListadoMedicos();
		//Enviar a vista
		modelo.addAttribute("listado", listado);
		return "redirect:/Vistas/ListadoMedicos";
		
	}

}
