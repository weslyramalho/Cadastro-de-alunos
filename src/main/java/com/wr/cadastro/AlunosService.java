package com.wr.cadastro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class AlunosService {
	
	private List<Alunos> alunosList;
	
	public AlunosService() {
		this.alunosList= new ArrayList<>();

	}

	public List<Alunos> BuscarAlunos(String alunos) {
		
		if(alunos != null) {
			return alunosList.stream()
					.filter(al -> al.getNome().contains(alunos))
					.collect(Collectors.toList());
		}
		return alunosList;
	}
	
	public Alunos AlunosPorID(Integer id) {
		return this.alunosList.stream()
				.filter(al -> al.getId().equals(id))
				.findFirst()
				.orElse(null);
	}
}
