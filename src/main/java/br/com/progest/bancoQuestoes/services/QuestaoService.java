package br.com.progest.bancoQuestoes.services;

import java.util.List;
import java.util.Optional;

import br.com.progest.bancoQuestoes.models.Materia;
import br.com.progest.bancoQuestoes.models.Questao;

public interface QuestaoService {

	Optional<List<Questao>> getQuestoesbyMateria(Materia materia);

	long persist(Questao questao);

}
