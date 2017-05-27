package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Livro {
	private String titulo;
	private String Autor;
	private String ISBN;
	private String Editora;
	private String tombo;
	
	List<Livro> exemplares = new ArrayList<>();
	
	public Livro(){}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getEditora() {
		return Editora;
	}

	public void setEditora(String editora) {
		Editora = editora;
	}

	public String getTombo() {
		return tombo;
	}

	public void setTombo(String tombo) {
		this.tombo = tombo;
	}
	
	
}
