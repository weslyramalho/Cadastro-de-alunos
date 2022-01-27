package com.wr.cadastro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;




public class AlunosService {
	
	private List<Alunos> alunosList;
	
	public AlunosService() {
		this.alunosList= new ArrayList<>();

	}
	 public List<Alunos> Alunos (String alunos){
	        return alunosList;
	   }

	public void addNovoAluno(Alunos alunos) {
		
		int id = alunosList.size() + 1;
		alunos.setId(id);
		alunosList.add(alunos);
		
		new ResponseEntity<>("Cadastrado com sucesso!", HttpStatus.CREATED);
	}
	
	public List<Alunos> findAllPorNome(String nome) {
		
		if(nome != null) {
			return alunosList.stream()
					.filter(al -> al.getNome().contains(nome))
					.collect(Collectors.toList());
		}
		throw new RecursoInexistenteException();
	}
	
	public List<Alunos> findAllPorIdade(Integer idade) {
		
		if(idade != null) {
			return alunosList.stream()
					.filter(al -> al.getIdade().equals(idade))
					.collect(Collectors.toList());
		}
		throw new RecursoInexistenteException();
		
	}
	
	public List<Alunos> findById(Integer id) {
		if(id != null) {
		return  alunosList.stream()
				.filter(al -> al.getId().equals(id)).collect(Collectors.toList());
	}
		throw new RecursoInexistenteException();

	}
	public void update(Alunos alunos) {
		alunosList.stream()
		.filter(al -> al.getId().equals(alunos.getId()))
		.forEach(al-> al.setNome(alunos.getNome()));
	}
	
	public ResponseEntity<String> delete(Integer id) {
		alunosList.removeIf(al-> al.getId().equals(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}
}
