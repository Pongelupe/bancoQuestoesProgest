package br.com.progest.bancoQuestoes.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.progest.bancoQuestoes.models.Materia;
import br.com.progest.bancoQuestoes.models.Questao;
import br.com.progest.bancoQuestoes.repositories.MateriaRepository;
import br.com.progest.bancoQuestoes.repositories.QuestaoRepository;
import br.com.progest.bancoQuestoes.utils.FileResolver;
import br.com.progest.bancoQuestoes.validators.QuestaoValidator;

@Controller
public class CadastroQuestaoController {

	@Autowired
	private QuestaoRepository questaoRepository;

	@Autowired
	private MateriaRepository materiaRepository;

	@Autowired
	private FileResolver fileResolver;


	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new QuestaoValidator());
	}

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView index = new ModelAndView("questoesForm");
		index.addObject("materias", materiaRepository.findAll());
		return index;
	}

	@PostMapping("/questao")
	public ModelAndView adicionarQuestao(String nomeMateria, boolean utilizada, String dificuldade, MultipartFile foto,
			@Valid Questao questao, BindingResult result) {

		if (result.hasErrors()) {
			questao = null;
		} else {
			Materia materia = materiaRepository.findByNome(nomeMateria);
			questao.setMateria(materia);
			questao.setAdicionadaEm(new Date());
			questao.setUsadaEm(utilizada ? new Date() : null);
			questao.setUrlQuestao(
					foto == null || foto.getOriginalFilename().isEmpty() ? null : fileResolver.write("questoes", foto));
			questao.setDificuldade(dificuldade);

			questaoRepository.save(questao);

		}
		return new ModelAndView("redirect:/");
	}

}
