package Modelo;

import java.util.Calendar;

public class Emprestimo {
	int id;
	Calendar dataSaida;
	Calendar dataPrevista;
	Associado associado;

	
	public Emprestimo(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Calendar getDataPrevista() {
		return dataPrevista;
	}

	public void setDataPrevista(Calendar dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}


	
	
}
