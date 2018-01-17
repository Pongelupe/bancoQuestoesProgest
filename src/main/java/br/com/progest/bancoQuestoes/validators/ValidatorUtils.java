package br.com.progest.bancoQuestoes.validators;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidatorUtils {

	public static List<String> validateStrings(Object obj) {
		ArrayList<String> wrongOnes = new ArrayList<String>();

		if (obj != null) {
			ArrayList<Field> fields = getFields(obj.getClass());

			fields.stream().filter(f -> f.getClass().isAssignableFrom(String.class)).forEach(attr -> {

				try {
					attr.setAccessible(true);
					String target = (String) attr.get(obj);
					if (!isEmptyOrNull(target))
						wrongOnes.add(attr.getName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}

		return wrongOnes;
	}

	private static ArrayList<Field> getFields(Class<?> clazz) {
		return new ArrayList<Field>(Arrays.asList(clazz.getDeclaredFields()));
	}

	private static boolean isEmptyOrNull(String str) {
		return (str == null) || str.isEmpty();
	}

	public static List<String> formatErrorsMessages(List<String> errors) {
		errors.forEach(str -> str.concat(" inválido"));
		return errors;
	}

}
