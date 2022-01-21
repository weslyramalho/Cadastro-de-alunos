package com.wr.cadastro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunosController {
	
	private List<Alunos> alunosList;
	
	public AlunosController() {
	this.alunosList= new ArrayList<>();
	

	}
	
	@GetMapping
	public List<Alunos> alunos() {
		return alunosList;
	}
	
	@PostMapping
	public void addNovoAluno(@RequestBody Alunos alunos) {
		int id = alunosList.size() + 1;
		alunos.setId(id);
		alunosList.add(alunos);
		
	}
	@PutMapping
	public void update(@RequestBody Alunos alunos) {
		alunosList.stream()
		.filter(al -> al.getId().equals(alunos.getId()))
		.forEach(al-> al.setNome(alunos.getNome()));
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		alunosList.removeIf(al-> al.getId().equals(id));
	}
	
}
