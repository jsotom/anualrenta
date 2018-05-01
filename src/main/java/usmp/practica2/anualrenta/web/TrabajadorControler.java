package usmp.practica2.anualrenta.web;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import usmp.practica2.anualrenta.model.Trabajador;
import usmp.practica2.anualrenta.repository.TrabajadorRepository;
@Controller
public class TrabajadorControler {
	@Autowired
	private TrabajadorRepository trabajadorRepository;

	private Trabajador calcular(Trabajador trabajador) {

		double escala1=trabajador.getImpUIT()*5;
		double escala2=trabajador.getImpUIT()*20;
		double escala3=trabajador.getImpUIT()*35;
		double escala4=trabajador.getImpUIT()*45;
	
		double indiceUIT;
		
		double escalafija;
		double escalavariable;
		
		if (trabajador.getModalidadTrabajo().equalsIgnoreCase("Dependiente")) { 
			trabajador.setImptotalbruto(trabajador.getSueldoMensual() * 14);
		}else {
			trabajador.setImptotalbruto(trabajador.getSueldoMensual() * 12);
		}
		
		trabajador.setImpUITdes(trabajador.getImpUIT() * 7);
		trabajador.setRentaneta(trabajador.getImptotalbruto() - trabajador.getImpUITdes());
		
		double rentaneta=trabajador.getRentaneta();
		indiceUIT=rentaneta/(trabajador.getImpUIT());
		
			
		if (indiceUIT>45) {
			
			escalafija=(escala4-escala3)*0.2+(escala3-escala2)*0.17+(escala2-escala1)*0.14+escala1*0.08;
			escalavariable=(rentaneta-escalafija)*0.3;
		}else if(indiceUIT>35){
			
			escalafija=(escala3-escala2)*0.17+(escala2-escala1)*0.14+escala1*0.08;
			escalavariable=(rentaneta-escalafija)*0.2;
		}else if(indiceUIT>20){
			
			escalafija=(escala2-escala1)*0.14+escala1*0.08;
			escalavariable=(rentaneta-escalafija)*0.17;
		}else if(indiceUIT>5){
			
			escalafija=escala1*0.08;
			escalavariable=(rentaneta-escalafija)*0.14;
		}else {
			
			escalafija=0;
			escalavariable=(rentaneta-escalafija)*0.08;
		}
		
		trabajador.setImpRentaPagar(escalafija+escalavariable);
		
		
	return trabajador;
	}
	
	@GetMapping("/trabajador/calcular")
	private String formulario(Model model) {

		model.addAttribute(new Trabajador());
		return "formulario";
	}
	
	@PostMapping("/trabajador/calcular")
	private String calculado(@Valid Trabajador trabajador, BindingResult bindingResult) {
		
		if (bindingResult.hasFieldErrors()) {
			return "formulario";
		}
		
		trabajador = calcular(trabajador);
		
		return "calculo";
	}
	
	@PostMapping("/trabajador/new")
	private String guardarTrabajador(@ModelAttribute Trabajador trabajador) {

		trabajadorRepository.save(trabajador);
		
		return "redirect:/trabajador/lista";
	}

	@GetMapping("/trabajador/lista")
	private String listado(Map<String, Object> model) {
		
		List<Trabajador> trabajadores = trabajadorRepository.findAll();
		model.put("trabajadores", trabajadores);
		return "listado";
	}
}
