package br.com.progest.bancoQuestoes.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	private String descricao;
	private String corpo;
	private String urlQuestao;
	private boolean isProcessoSeletivo;

	@Enumerated(EnumType.STRING)
	private Dificuldade dificuldade;

	@Temporal(TemporalType.DATE)
	private Date usadaEm;

	@Temporal(TemporalType.DATE)
	private Date adicionadaEm;

	public Questao(Materia materia, String descricao, String corpo, String urlQuestao, Dificuldade dificuldade,
			boolean isProcessoSeletivo) {
		this.materia = materia;
		this.descricao = descricao;
		this.corpo = corpo;
		this.urlQuestao = urlQuestao;
		this.dificuldade = dificuldade;
		this.isProcessoSeletivo = isProcessoSeletivo;
		this.usadaEm = null;
		this.adicionadaEm = new Date();
	}

	@Deprecated
	public Questao() {
	}

	public Questao(long id) {
		this.id = id;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public boolean isProcessoSeletivo() {
		return isProcessoSeletivo;
	}

	public void setProcessoSeletivo(boolean isProcessoSeletivo) {
		this.isProcessoSeletivo = isProcessoSeletivo;
	}

	public void setDificuldade(String dificuldade) {
		dificuldade = dificuldade.toUpperCase();
		if (dificuldade.startsWith("F"))
			this.dificuldade = Dificuldade.FACIL;

		else if (dificuldade.startsWith("M"))
			this.dificuldade = Dificuldade.MEDIO;

		else
			this.dificuldade = Dificuldade.DIFICIL;
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
		return "Questao [id=" + id + ", materia=" + materia + ", descricao=" + descricao + ", corpo=" + corpo
				+ ", urlQuestao=" + urlQuestao + ", usadaEm=" + usadaEm + ", adicionadaEm=" + adicionadaEm + "]";
	}

}
