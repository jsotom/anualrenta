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

}
