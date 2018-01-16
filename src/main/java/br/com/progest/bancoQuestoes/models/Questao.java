package br.com.progest.bancoQuestoes.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@Temporal(TemporalType.DATE)
	private Date usadaEm;

	@Temporal(TemporalType.DATE)
	private Date adicionadaEm;

	public Questao(Materia materia, String titulo, String corpo, String urlQuestao) {
		this.materia = materia;
		this.titulo = titulo;
		this.corpo = corpo;
		this.urlQuestao = urlQuestao;
		this.usadaEm = null;
		this.adicionadaEm = new Date();
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

	public Date getUsadaEm() {
		return usadaEm;
	}

	public void setUsadaEm(Date usadaEm) {
		this.usadaEm = usadaEm;
	}

	public Date getAdicionadaEm() {
		return adicionadaEm;
	}

	public void setAdicionadaEm(Date adicionadaEm) {
		this.adicionadaEm = adicionadaEm;
	}

	@Override
	public String toString() {
		return "Questao [id=" + id + ", materia=" + materia + ", titulo=" + titulo + ", corpo=" + corpo
				+ ", urlQuestao=" + urlQuestao + ", usadaEm=" + usadaEm + ", adicionadaEm=" + adicionadaEm + "]";
	}

}
