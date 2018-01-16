package br.com.progest.bancoQuestoes.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Questao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_questao")
	private Materia materia;

	private String titulo;
	private String corpo;
	private String urlQuestao;

	public Questao(Materia materia, String titulo, String corpo, String urlQuestao) {
		this.materia = materia;
		this.titulo = titulo;
		this.corpo = corpo;
		this.urlQuestao = urlQuestao;
	}

	@Deprecated
	public Questao() {
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public String getUrlQuestao() {
		return urlQuestao;
	}

	public void setUrlQuestao(String urlQuestao) {
		this.urlQuestao = urlQuestao;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Questao [id=" + id + ", materia=" + materia + ", titulo=" + titulo + ", corpo=" + corpo
				+ ", urlQuestao=" + urlQuestao + "]";
	}

}
