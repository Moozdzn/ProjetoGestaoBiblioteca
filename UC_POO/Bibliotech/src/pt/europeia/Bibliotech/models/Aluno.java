package pt.europeia.Bibliotech.models;

/**
 *Classe do objeto Aluno com o devido construtor,getters e setters
 */

public class Aluno {
	
	protected int idAluno;
	protected String nome;
	protected String dataNascimento;
	protected String curso;
	
	
	public Aluno(int idAluno, String nome, String dataNascimento, String curso) {
		super();
		this.idAluno = idAluno;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.curso = curso;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getIdAluno() {
		return idAluno;
	}

	
	
	
}
