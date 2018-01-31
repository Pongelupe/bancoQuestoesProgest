package br.com.progest.bancoQuestoes.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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

		final String descricao = questao.getDescricao();
		final String corpo = questao.getCorpo();

		if (descricao == null || descricao.isEmpty())
			errors.rejectValue("descricao", "Descrição inválida");

		if (corpo == null || corpo.isEmpty())
			errors.rejectValue("corpo", "Corpo inválido");

	}

}
