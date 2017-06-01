package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Associado;
import Modelo.Reserva;
import Modelo.Livro;

public class ReservaDAO {
	Connection conexao;

	public ReservaDAO(){
		this.conexao = new ConnectionFactory().getConnection();
	}

	public void adiciona(Reserva reserva) throws SQLException {
		try{
			String sql = "insert into reserva(RA_ASSOCIADO,ID_LIVRO)VALUES(?,?)";
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1,reserva.getAssociado().getRa());
			stmt.setInt(2,reserva.getLivro().getTombo());

			stmt.execute();
			stmt.close();
			
			System.out.println("Dados inseridos com sucesso!!!");	
		}catch(SQLException sqle){
			System.out.println("Não foi possivel inserir dados!!!");
		}finally{
			conexao.close();
		}
	}

	public List<Reserva> getLista(String dado) throws SQLException{
		try{
			List<Reserva>reservas=new ArrayList<Reserva>();
			String sql ="select*from reserva where ra_associado like '"+dado+"'";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();


			while(rs.next()){

				Reserva reserva = new Reserva();

				String Ra = rs.getString("ra_associado");
				AssociadoDAO dao = new AssociadoDAO();
				List<Associado> associados = dao.getLista("ra",Ra);
				reserva.setAssociado(associados.get(0));

				String id_livro = ""+rs.getInt("id_livro");
				LivroDAO livrodao = new LivroDAO();
				List<Livro> livros = livrodao.getLista("id_livro",id_livro);
				reserva.setLivro(livros.get(0));

				reservas.add(reserva);
			}
			rs.close();
			stmt.close();
			return reservas;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			conexao.close();
		}
	}
}
