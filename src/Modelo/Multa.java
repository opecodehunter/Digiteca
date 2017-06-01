package Modelo;

public class Multa {
	private int id_multa;
	private Associado associado;
	private double valor;
	
	public Multa(){}
	
	public int getId_multa() {
		return id_multa;
	}
	public void setId_multa(int id_multa) {
		this.id_multa = id_multa;
	}
	public Associado getAssociado() {
		return associado;
	}
	public void setAssociado(Associado ra_associado) {
		this.associado = ra_associado;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}


}
