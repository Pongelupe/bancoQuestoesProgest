package br.com.progest.bancoQuestoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.progest.bancoQuestoes.repositories.MateriaRepository;
import br.com.progest.bancoQuestoes.repositories.QuestaoRepository;

@Controller
public class ListaQuestoesController {

	@Autowired
	private QuestaoRepository questaoRepository;

	@Autowired
	private MateriaRepository materiaRepository;

	@GetMapping(value = "/list")
	public ModelAndView list() {
		ModelAndView list = new ModelAndView("questoesList");
		list.addObject("questoes", questaoRepository.findAll());
		list.addObject("materias", materiaRepository.findAll());
		return list;
	}

}
