package Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Associado;

public class AssociadoDAO {
	Connection conexao;

	public AssociadoDAO(){
		this.conexao = new ConnectionFactory().getConnection();
	}

	public void adiciona(Associado associado) throws SQLException{
		try{
			String sql = "insert into associado(RA,EMAIL,NOME,TELEFONE,TIPO) VALUES(?,?,?,?,?)";
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1,associado.getRa());
			stmt.setString(2,associado.getEmail());
			stmt.setString(3,associado.getNome());
			stmt.setString(4,associado.getTelefone());
			stmt.setString(5,associado.getTipo());

			stmt.execute();
			stmt.close();
			System.out.println("Dados inseridos com sucesso!!!");
		}catch(SQLException sqle){
			System.out.println("Não foi possivel inserir os dados!!!");
		}finally{
			conexao.close();
		}
	}

	public List<Associado> getLista(){
		try{
			List<Associado>associados=new ArrayList<Associado>();
			String sql ="select*from associado";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();


			while(rs.next()){

				Associado associado = new Associado();
				associado.setRa(rs.getString("ra"));
				associado.setEmail(rs.getString("email"));
				associado.setNome(rs.getString("nome"));
				associado.setTelefone(rs.getString("telefone"));
				associado.setTipo(rs.getString("tipo"));

				associados.add(associado);
			}
			rs.close();
			stmt.close();
			return associados;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Associado> getLista(String filtro,String dado) throws SQLException{
		try{
			List<Associado>associados=new ArrayList<Associado>();
			String sql ="select*from associado where "+filtro+" like '"+dado+"' ";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();


			while(rs.next()){

				Associado associado = new Associado();
				associado.setRa(rs.getString("ra"));
				associado.setEmail(rs.getString("email"));
				associado.setNome(rs.getString("nome"));
				associado.setTelefone(rs.getString("telefone"));
				associado.setTipo(rs.getString("tipo"));

				associados.add(associado);
			}
			rs.close();
			stmt.close();
			return associados;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			conexao.close();
		}
	}

/*	public void altera(Associado associado){
		String sql = "update associado set ra=?, email=?, nome=?, telefone=?, tipo=?";
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, associado.getRa());
			stmt.setString(2, associado.getEmail());
			stmt.setString(3, associado.getNome());
			stmt.setString(4, associado.getTelefone());
			stmt.setString(5, associado.getTipo());

			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}*/

 public void remove(Associado associado){
		try{
			PreparedStatement stmt = conexao.prepareStatement("delete from contatos where RA=?");
			stmt.setString(1,associado.getRa());
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}

	}

}