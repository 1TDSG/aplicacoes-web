package br.com.fiap.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.Cliente;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet(
		description = "Controladora de acesso e requisições.", 
		urlPatterns = { 
				"/clientes", 
				"/listar"
		})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<Cliente> lista = null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
    	
    	if(lista == null) {
    		lista = new ArrayList<Cliente>();
    		
    		Cliente cli = new Cliente();
    		cli.setNome("Alexandre");
    		cli.setSobrenome("Carlos");
    		//Criando a formatação da Data.
    		Calendar c = Calendar.getInstance();
    		SimpleDateFormat sf = new SimpleDateFormat("dd/mm/yyyy");
    		try {
				c.setTime(sf.parse("27/12/1975"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
    		cli.setDtNasc(c.getTime());
    		cli.setGenero('m');
    		cli.setTelefone(11976546745L);
    		//Adicionando um cliente na lista
    		lista.add(cli);
    		
    		cli = new Cliente();
    		cli.setNome("João");
    		cli.setSobrenome("Marcos");
    		//Criando a formatação da Data.
    		c = Calendar.getInstance();
    		sf = new SimpleDateFormat("dd/mm/yyyy");
    		try {
				c.setTime(sf.parse("21/04/1964"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
    		cli.setDtNasc(c.getTime());
    		cli.setGenero('m');
    		cli.setTelefone(11967893456L);
    		//Adicionando um cliente na lista
    		lista.add(cli);
    		
    	}
    		
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
