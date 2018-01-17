package br.com.progest.bancoQuestoes.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.progest.bancoQuestoes.models.Materia;
import br.com.progest.bancoQuestoes.models.Questao;

public class QuestaoValidator implements Validator {

	private Questao questao;

	@Override
	public boolean supports(Class<?> clazz) {
		return Questao.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		questao = (Questao) target;

		final String titulo = questao.getTitulo();
		final String corpo = questao.getCorpo();
		final Materia materia = questao.getMateria();

		if (titulo == null || titulo.isEmpty())
			errors.rejectValue("titulo", "titulo inválido");

		if (corpo == null || corpo.isEmpty())
			errors.rejectValue("corpo", "corpo inválido");

		if (materia == null)
			errors.rejectValue("materia", "materia inválido");

	}

}
