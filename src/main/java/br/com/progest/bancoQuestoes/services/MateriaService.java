package br.com.progest.bancoQuestoes.services;

import java.util.List;

import br.com.progest.bancoQuestoes.models.Materia;

public interface MateriaService {

	long persist(Materia materia);

	List<Materia> findAll();

}
