package com.wr.cadastro;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping
	public ResponseEntity<Integer> post(@RequestBody Alunos alunos) {
		alunosService.addNovoAluno(alunos);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping
	public ResponseEntity<Object> update(@RequestBody Alunos alunos) {
		alunosService.update(alunos);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> delete(@PathVariable("id") Integer id) {
		alunosService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
}
