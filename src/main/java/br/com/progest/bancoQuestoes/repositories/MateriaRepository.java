package br.com.progest.bancoQuestoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.progest.bancoQuestoes.models.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

	@Transactional(readOnly = true)
	Materia findByNome(String nome);

}
