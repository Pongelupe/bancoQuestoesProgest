package br.com.progest.bancoQuestoes.servicesImplementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.progest.bancoQuestoes.models.Materia;
import br.com.progest.bancoQuestoes.repositories.MateriaRepository;
import br.com.progest.bancoQuestoes.services.MateriaService;

@Service
public class MateriaServiceImpl implements MateriaService {

	private static final Logger log = LoggerFactory.getLogger(MateriaServiceImpl.class);

	@Autowired
	private MateriaRepository repository;

	@Override
	public long persist(Materia materia) {
		log.info("Persisting materia: " + materia);
		return repository.save(materia).getId();
	}

}
