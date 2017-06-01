package UseCase;

import java.sql.SQLException;
import java.util.List;

import Conexao.AssociadoDAO;
import Conexao.MultaDAO;
import Modelo.Associado;
import Modelo.Multa;

public class GerarMulta {
	public static void novaMulta(String ra,double valor) throws SQLException{
		AssociadoDAO associadodao = new AssociadoDAO();
		List<Associado>associados = associadodao.getLista("ra",ra);
		Associado associado = new Associado();

		associado.setRa(associados.get(0).getRa());
		associado.setEmail(associados.get(0).getEmail());
		associado.setNome(associados.get(0).getNome());
		associado.setTelefone(associados.get(0).getTelefone());
		associado.setTipo(associados.get(0).getTipo());

		Multa multa = new Multa();

		multa.setAssociado(associado);
		multa.setValor(valor);

		MultaDAO multadao = new MultaDAO();

		multadao.adiciona(multa);
	}
}
