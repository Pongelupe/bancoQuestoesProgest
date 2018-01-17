package br.com.progest.bancoQuestoes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.progest.bancoQuestoes.models.Materia;
import br.com.progest.bancoQuestoes.models.Questao;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Long> {

	@Transactional(readOnly = true)
	List<Questao> findByMateria(Materia materia);
}
