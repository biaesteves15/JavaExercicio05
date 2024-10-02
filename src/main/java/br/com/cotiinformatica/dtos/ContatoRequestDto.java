package br.com.cotiinformatica.dtos;

import lombok.Data;

@Data
public class ContatoRequestDto {
	
	private Integer idContato;
	private String nome;
	private String email;
	private String telefone;

}
