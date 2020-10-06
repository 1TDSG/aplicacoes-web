package br.com.fiap.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String sobrenome;
	private Date dtNasc;
	private char genero;
	private String telefone;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(int id, String nome, String sobrenome, Date dtNasc, char genero, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dtNasc = dtNasc;
		this.genero = genero;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}
	
	public void setDtNasc(String dtNasc) throws ParseException {
		this.dtNasc = new SimpleDateFormat("yyyy-MM-dd").parse(dtNasc);
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
