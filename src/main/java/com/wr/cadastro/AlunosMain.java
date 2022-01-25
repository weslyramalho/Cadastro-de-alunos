package com.wr.cadastro;

import java.io.IOException;

public class AlunosMain {

	public static void main(String[] args) throws IOException{
		
		AlunosService alunosService = new AlunosService();
		alunosService.findAll().stream().forEach(System.out::println());;
		

	}

}
