package cl.awakelab.amorescaninos.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.awakelab.amorescaninos.data.PerfilData;
import cl.awakelab.amorescaninos.entity.Caracteristica;
import cl.awakelab.amorescaninos.entity.Perfil;
import cl.awakelab.amorescaninos.entity.Raza;
import cl.awakelab.amorescaninos.service.CaracteristicaService;
import cl.awakelab.amorescaninos.service.PerfilService;
import cl.awakelab.amorescaninos.service.RazaService;

@Controller
public class PerfilController {
	@Autowired
	RazaService razaService;
	
	@Autowired
	CaracteristicaService caractService;
	
	@Autowired
	PerfilService perfilService;
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	
	@RequestMapping(value="/match", method = RequestMethod.GET)
	public ModelAndView match() {
		ModelAndView mav = new ModelAndView("match");
		List<Raza> razas = razaService.findAll();
		List<Caracteristica> caracteristicas = caractService.findAll();
		List<Integer> edades =  PerfilData.EDADES;
		List<String> generos = PerfilData.GENEROS;
		mav.addObject("razas", razas);
		mav.addObject("caracteristicas", caracteristicas);
		mav.addObject("edades", edades);
		mav.addObject("generos", generos);
		return mav;
	}
	
   	@RequestMapping(value="/match", method = RequestMethod.POST)               
	public ModelAndView matchResults(
	  @RequestParam(name = "caracteristica-id", required = false) long caracteristicaId,
	  @RequestParam(name = "raza-id", required = false) long razaId,
	  @RequestParam(name = "edad", required = false) int edad,
	  @RequestParam(name = "genero", required = false) String genero) {
		
		ModelAndView mav = new ModelAndView("matchresults");
		
		// Preparar lista de ids de caracteristicas
		List<Long> caractList = new ArrayList<>(Arrays.asList(caracteristicaId));

		
		// Preparar listas de raza y genero
		List<Raza> raza = new ArrayList<>();
		raza.add(razaService.findById(razaId));
		List<String> genList = new ArrayList<>();
		genList.add(genero);
		
		// Comprobar cada campo para ver si se debe filtrar
		raza = (razaId == 0) ? razaService.findAll() : raza;
		List<Caracteristica> caract = (caracteristicaId == 0) ? caractService.findAll() : caractService.findAllById(caractList);
		genList = genero.equals("Todos") ? PerfilData.GENEROS : genList;
		
		// Aplicar filtros correspondientes y enviar el resultado a la vista
		List<Perfil> perfiles = perfilService.findByMultipleFields(caract, raza, edad, genList);
		mav.addObject("perfiles", perfiles);
		return mav;
		
	}
	
	@RequestMapping(value="/viewall", method = RequestMethod.GET)
	public ModelAndView viewAll() {
		ModelAndView mav = new ModelAndView("matchresults");
		List<Perfil> perfiles = perfilService.findAll();
		mav.addObject("perfiles", perfiles);
		return mav;
	}
}
