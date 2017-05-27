package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Associado;
import Modelo.Livro;

public class LivroDAO {
	Connection conexao;

	public LivroDAO(){
		this.conexao = new ConnectionFactory().getConnection();
	}

	public void adiciona(Livro livro) throws SQLException{
		try{
			String sql = "insert into livro(titulo,autor,isbn,editora,tombo)values(?????)";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,livro.getTitulo());
			stmt.setString(2,livro.getAutor());
			stmt.setString(3,livro.getISBN());
			stmt.setString(4,livro.getEditora());
			stmt.setString(5,livro.getTombo());

			stmt.execute();
			stmt.close();
			System.out.println("Dados inseridos com sucesso!!!");
		}catch(SQLException e){
			System.out.println("Não foi possivel inserir dados");
		}finally{
			conexao.close();
		}
	}

	public List<Livro> getLista() throws SQLException{
		try{
			List<Livro>livros=new ArrayList<Livro>();
			String sql ="select*from livro";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();


			while(rs.next()){

				Livro livro = new Livro();
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setISBN(rs.getString("isbn"));
				livro.setEditora(rs.getString("editora"));
				livro.setTombo(rs.getString("tombo"));

				livros.add(livro);
			}
			rs.close();
			stmt.close();
			return livros;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			conexao.close();
		}
	}

	public void altera(Livro livro) throws SQLException{
		String sql = "update livro set ra=?, email=?, nome=?, telefone=?, tipo=?";
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getISBN());
			stmt.setString(4, livro.getEditora());
			stmt.setString(5, livro.getTombo());

			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			conexao.close();
		}
	}

	public void remove(Associado associado) throws SQLException{
		try{
			PreparedStatement stmt = conexao.prepareStatement("delete from contatos where RA=?");
			stmt.setString(1,associado.getRa());
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			conexao.close();
		}

	}
}
