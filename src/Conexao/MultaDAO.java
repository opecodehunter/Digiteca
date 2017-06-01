package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelo.Associado;
import Modelo.Multa;


public class MultaDAO {

	Connection conexao;

	public MultaDAO(){
		this.conexao = new ConnectionFactory().getConnection();
	}

	public void adiciona(Multa multa) throws SQLException {
		try{
			String sql = "insert into multa(RA_ASSOCIADO,VALOR)VALUES(?,?)";
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1,multa.getAssociado().getRa());
			stmt.setDouble(2,multa.getValor());

			stmt.execute();
			stmt.close();

			System.out.println("Dados inseridos com sucesso!!!");	
		}catch(SQLException sqle){
			System.out.println("Não foi possivel inserir dados!!!");
		}finally{
			conexao.close();
		}
	}

	public List<Multa> getLista(String dado) throws SQLException{
		try{
			List<Multa>multas=new ArrayList<Multa>();
			String sql ="select*from multa where ra_associado like '"+dado+"'";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();


			while(rs.next()){

				Multa multa = new Multa();

				String Ra = rs.getString("ra_associado");
				AssociadoDAO dao = new AssociadoDAO();
				List<Associado> associados = dao.getLista("ra",Ra);
				multa.setAssociado(associados.get(0));

				multa.setId_multa(rs.getInt("id_multa"));

				multa.setValor(rs.getDouble("valor"));

				multas.add(multa);
			}
			rs.close();
			stmt.close();
			return multas;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			conexao.close();
		}
	}
}
