package com.wr.cadastro;

public class AlunoNãoEncontradoException extends Exception{

	public AlunoNãoEncontradoException(final String nome) {
		super("Aluno(a); " + nome + "não encontrado(a).");
	}

}
