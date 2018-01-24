package br.com.progest.bancoQuestoes.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.progest.bancoQuestoes.models.Questao;
import br.com.progest.bancoQuestoes.repositories.MateriaRepository;
import br.com.progest.bancoQuestoes.repositories.QuestaoRepository;

@Controller
public class ListaQuestoesController {

	@Autowired
	private QuestaoRepository questaoRepository;

	@Autowired
	private MateriaRepository materiaRepository;

	@GetMapping(value = "/list", params = { "hasFilter" })
	public ModelAndView list(ArrayList<Questao> questoes, @RequestParam boolean hasFilter) {
		ModelAndView list = new ModelAndView("questoesList");
		list.addObject("questoes", hasFilter ? questoes : questaoRepository.findAll());
		list.addObject("materias", materiaRepository.findAll());
		return list;
	}

	@GetMapping("/filter")
	public ModelAndView filter(String materia, String dificuldade, boolean isProcessoSeletivo) {
		return list(null, false);
	}

}
