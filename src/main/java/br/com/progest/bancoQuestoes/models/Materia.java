package br.com.progest.bancoQuestoes.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_questao")
	private List<Questao> questoes;

	public Materia(String nome, List<Questao> questoes) {
		this.nome = nome;
		this.questoes = questoes;
	}

	@Deprecated
	public Materia() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Materia [id=" + id + ", nome=" + nome + ", questoes=" + questoes + "]";
	}

}
