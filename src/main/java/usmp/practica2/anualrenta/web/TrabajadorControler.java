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

		double sueldoanual = 0;
		
		if (trabajador.getModalidadTrabajo().equalsIgnoreCase("Dependiente")) { 
			trabajador.setImptotalbruto(trabajador.getSueldoMensual() * 14);
		}else {
			trabajador.setImptotalbruto(trabajador.getSueldoMensual() * 12);
		}
		
		trabajador.setImpUITdes(trabajador.getImpUIT() * 7);
		trabajador.setRentaneta(trabajador.getImptotalbruto() - trabajador.getImpUITdes());
		
		
	return trabajador;
	}
}
