package com.wr.cadastro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunosController {
	
	AlunosService alunosService = new AlunosService();
	
	@GetMapping
	public List<Alunos> buscaAlunos(@RequestParam(required = false) String nome, Integer id, Integer idade) {
	
		if(nome != null) {
			return alunosService.findAllPorNome(nome);
		}
		if(id != null) {
			return alunosService.findById(id);
		}
		if(idade != null) {
			return alunosService.findAllPorIdade(idade);
		}
		return alunosService.Alunos(nome);
		
	}

	@GetMapping
	public List<Alunos> findAllPorIdade(@RequestParam(required = false) Integer idade) {
		
		if(idade != null) {
			return alunosList.stream()
					.filter(al -> al.getIdade().equals(idade))
					.collect(Collectors.toList());
		}
		return alunosList;
		
	}
	


	
	
	@GetMapping("/{id}")
	public Alunos findById(@PathVariable("id") Integer id) {
		return this.alunosList.stream()
				.filter(al -> al.getId().equals(id))
				.findFirst()
				.orElse(null);
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
