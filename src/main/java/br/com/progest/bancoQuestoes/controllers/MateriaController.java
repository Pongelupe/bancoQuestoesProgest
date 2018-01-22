package br.com.progest.bancoQuestoes.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.progest.bancoQuestoes.models.Materia;
import br.com.progest.bancoQuestoes.models.Response;
import br.com.progest.bancoQuestoes.repositories.MateriaRepository;
import br.com.progest.bancoQuestoes.validators.MateriaValidator;

@Controller
public class MateriaController {

	@Autowired
	private MateriaRepository service;

	private static final Logger log = LoggerFactory.getLogger(MateriaController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new MateriaValidator());
		binder.setAllowedFields("nome");
	}

	@PostMapping("/materia")
	public @ResponseBody ResponseEntity<Response<Long>> cadastraMateria(@RequestBody @Valid Materia materia,
			BindingResult result) {

		Response<Long> response = new Response<Long>();

		if (result.hasErrors()) {
			log.warn("Error validating new Materia");
			response.setData(-1L);
			result.getAllErrors().forEach(error -> response.addError(error.getDefaultMessage()));

			return ResponseEntity.badRequest().body(response);

		} else {
			long idMateria = service.save(materia).getId();
			response.setData(idMateria);
			return ResponseEntity.ok(response);
		}

	}

	@GetMapping("/materias")
	public @ResponseBody ResponseEntity<Response<List<Materia>>> getAll() {
		Response<List<Materia>> response = new Response<List<Materia>>();

		response.setData(service.findAll());

		return ResponseEntity.ok(response);
	}

}
