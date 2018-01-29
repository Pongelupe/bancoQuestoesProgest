package br.com.progest.bancoQuestoes.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView list = new ModelAndView("questoesList");
		list.addObject("questoes", questaoRepository.findAll());
		list.addObject("materias", materiaRepository.findAll());
		return list;
	}

	@GetMapping("/questao/{idQuestao}")
	public @ResponseBody Questao getQuestaoById(@PathVariable Long idQuestao) {
		Questao questao = questaoRepository.findOne(idQuestao);
		return questao;
	}

	@PostMapping("/utilizarQuestao")
	public @ResponseBody Long questao(@RequestBody Long idQuestao) {
		Questao questao = questaoRepository.findOne(idQuestao);
		questao.setUsadaEm(new Date());
		questaoRepository.save(questao);
		return questao.getId();
	}

}
