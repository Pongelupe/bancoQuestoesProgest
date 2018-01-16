package br.com.progest.bancoQuestoes.servicesImplementation;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.progest.bancoQuestoes.models.Materia;
import br.com.progest.bancoQuestoes.models.Questao;
import br.com.progest.bancoQuestoes.repositories.QuestaoRepository;
import br.com.progest.bancoQuestoes.services.QuestaoService;

public class QuestaoServiceImpl implements QuestaoService {

	private static final Logger log = LoggerFactory.getLogger(QuestaoServiceImpl.class);

	@Autowired
	private QuestaoRepository repository;

	@Override
	public Optional<List<Questao>> getQuestoesbyMateria(Materia materia) {
		log.info("Getting questoes: " + materia);
		return Optional.of(repository.findByMateria(materia));
	}

	@Override
	public long persist(Questao questao) {
		log.info("Persisting " + questao);
		return repository.save(questao).getId();
	}

}
