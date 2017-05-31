package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Modelo.Associado;
import Modelo.Emprestimo;
import Modelo.Emprestimo;

public class EmprestimoDAO {
	
	Connection conexao;
		
	public EmprestimoDAO(){
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public List<Emprestimo> getLista() throws SQLException{
		try{
			List<Emprestimo>emprestimos=new ArrayList<Emprestimo>();
			String sql ="select*from emprestimo";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();


			while(rs.next()){

				Emprestimo emprestimo = new Emprestimo();
				
				emprestimo.setId(rs.getInt("id_emprestimo"));
				
				//emprestimo.setAssociado(rs.getString("ra_associado"));
				
				//set Associado
				
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
