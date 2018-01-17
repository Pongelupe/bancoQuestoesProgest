package br.com.progest.bancoQuestoes.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.progest.bancoQuestoes.models.Materia;

public class MateriaValidator implements Validator {

	private Materia materia;

	@Override
	public boolean supports(Class<?> clazz) {
		return Materia.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		materia = (Materia) target;

		final String nome = materia.getNome();

		if (nome == null || nome.isEmpty())
			errors.rejectValue("nome", "nome inválido");
	}

}
