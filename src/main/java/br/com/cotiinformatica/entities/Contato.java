package br.com.cotiinformatica.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contato {
	
	private Integer idContato;
	private String nome;
	private String email;
	private String telefone;

}
