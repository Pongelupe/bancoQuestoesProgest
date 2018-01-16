package br.com.progest.bancoQuestoes.models;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {

	private T data;
	private List<String> errors;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<String> getErrors() {
		errors = (errors != null) ? errors : new ArrayList<>();
		return errors;
	}

	public void addError(String error) {
		getErrors().add(error);
	}

}
