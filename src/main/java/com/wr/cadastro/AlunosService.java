package com.wr.cadastro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AlunosService {
	public List<String> findAllAlunosService() throws IOException{
		String caminho = AlunosService.class.getClassLoader()
				.getResource("alunos.txt")
				.getPath();
		
		List<String> alunos = Files.readAllLines(Path.of(caminho));
	}
}
