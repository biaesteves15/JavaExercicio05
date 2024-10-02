package br.com.cotiinformatica.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class ContatoRepository {
	
	public void create(Contato contato) throws Exception{
		
		var connection = ConnectionFactory.getConnection();
		var statement = connection.prepareStatement("INSERT INTO contato(id, nome, email, telefone) VALUES(?,?,?,?)");
		
		statement.setInt(1, contato.getIdContato());
		statement.setString(2, contato.getNome());
		statement.setString(3, contato.getEmail());
		statement.setString(4, contato.getTelefone());
		
		statement.execute();
		connection.close();
	}
	public void update(Contato contato) throws Exception{
		
		var connection = ConnectionFactory.getConnection();
		var statement = connection.prepareStatement("UPDATE contato SET nome=?, email=?, telefone=? WHERE id=?");
		
		statement.setString(1, contato.getNome());
		statement.setString(2, contato.getEmail());
		statement.setString(3, contato.getTelefone());
		statement.setInt(4, contato.getIdContato());
		
		statement.execute();
		connection.close();
		
	}
	public void delete(Integer id) throws Exception{
		
		var connection = ConnectionFactory.getConnection();
		var statement = connection.prepareStatement("DELETE FROM contato WHERE id=?");
		
		statement.setInt(1, id);
		
		statement.execute();
		connection.close();
		
	}
	public List<Contato> getAll() throws Exception{
		
		var connection = ConnectionFactory.getConnection();
		var statement = connection.prepareStatement("SELECT id, nome, email, telefone FROM contato ORDER BY nome");
		var resultSet = statement.executeQuery();
		var lista = new ArrayList<Contato>();
		
		while(resultSet.next()) {
			var contato = new Contato();
			contato.setIdContato(Integer.parseInt(resultSet.getString("id")));
			contato.setNome(resultSet.getString("nome"));
			contato.setEmail(resultSet.getString("email"));
			contato.setTelefone(resultSet.getString("telefone"));
			
			lista.add(contato);
		}
		connection.close();
		return lista;
	}
	public Contato getById(Integer id) throws Exception{
		
		var connection = ConnectionFactory.getConnection();
		
		var statement = connection.prepareStatement("SELECT id, nome, email, telefone FROM contato WHERE id=?");
		statement.setInt(1, id);
		
		var resultSet = statement.executeQuery();
		
		Contato contato = null;
		
		if(resultSet.next()) {
			contato = new Contato();
			contato.setIdContato(Integer.parseInt(resultSet.getString("id")));
			contato.setNome(resultSet.getString("nome"));
			contato.setEmail(resultSet.getString("email"));
			contato.setTelefone(resultSet.getString("telefone"));
		}
		connection.close();
		
		return contato;
	}

}
