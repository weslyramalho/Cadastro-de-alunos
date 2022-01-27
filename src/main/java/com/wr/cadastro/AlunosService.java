package com.wr.cadastro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



public class AlunosService {
	
	private List<Alunos> alunosList;
	
	public AlunosService() {
		this.alunosList= new ArrayList<>();

	}

	public void addNovoAluno(@RequestBody Alunos alunos) {
		
		int id = alunosList.size() + 1;
		alunos.setId(id);
		alunosList.add(alunos);
		
		new ResponseEntity<>("Cadastrado com sucesso!", HttpStatus.CREATED);
	}
	public List<Alunos> findAllPorNome(@RequestParam(required = false) String alunos) {
		
		if(alunos != null) {
			return alunosList.stream()
					.filter(al -> al.getNome().contains(alunos))
					.collect(Collectors.toList());
		}
		throw new NomeNaoEncontradoExeception();
	}
}
