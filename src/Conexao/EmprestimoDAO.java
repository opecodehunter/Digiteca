package Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Modelo.Associado;
import Modelo.Emprestimo;
import Modelo.Livro;

public class EmprestimoDAO {
	
	Connection conexao;
		
	public EmprestimoDAO(){
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Emprestimo emprestimo) throws SQLException{
		try{
			String sql = "insert into emprestimo(DATAPREVISTA,DATASAIDA,RA_ASSOCIADO,ID_LIVRO) VALUES(?,?,?,?)";
			PreparedStatement stmt = conexao.prepareStatement(sql);

			Date dataPrevistaAdd = new Date(emprestimo.getDataPrevista().getTimeInMillis());
			Date dataSaidaAdd = new Date(emprestimo.getDataSaida().getTimeInMillis());
			stmt.setDate(1,dataPrevistaAdd);
			stmt.setDate(2,dataSaidaAdd);
			stmt.setString(3,emprestimo.getAssociado().getRa());
			stmt.setInt(4,emprestimo.getLivro().getTombo());


			stmt.execute();
			stmt.close();
			System.out.println("Dados inseridos com sucesso!!!");
		}catch(SQLException sqle){
			System.out.println("Não foi possivel inserir os dados!!!");
		}finally{
			conexao.close();
		}
	}
	
	
	public List<Emprestimo> getLista(String dado) throws SQLException{
		try{
			List<Emprestimo>emprestimos=new ArrayList<Emprestimo>();
			String sql ="select*from emprestimo where ra_associado like '"+dado+"'";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();


			while(rs.next()){

				Emprestimo emprestimo = new Emprestimo();
				
				emprestimo.setId(rs.getInt("id_emprestimo"));
				
				String Ra = rs.getString(("ra_associado"));
				AssociadoDAO dao = new AssociadoDAO();
				List<Associado> associados = dao.getLista("ra",Ra);
				emprestimo.setAssociado(associados.get(0));
					
				
				//setDataSaida
				Calendar dataSaida = Calendar.getInstance();
				dataSaida.setTime(rs.getDate("dataSaida"));
				emprestimo.setDataSaida(dataSaida);
				
				//setDataPrevista
				Calendar dataPrevista = Calendar.getInstance();
				dataSaida.setTime(rs.getDate("dataSaida"));
				emprestimo.setDataPrevista(dataPrevista);
		
				emprestimos.add(emprestimo);
			}
			rs.close();
			stmt.close();
			return emprestimos;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			conexao.close();
		}
	}
}
