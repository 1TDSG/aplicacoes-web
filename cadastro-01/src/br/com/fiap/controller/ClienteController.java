package br.com.fiap.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.Cliente;
import br.com.fiap.bo.ClienteBO;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet("/cliente")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		switch (request.getRequestURI()) {
		
		case "/cadastro-01/cliente":
			inserirCliente(request, response);
			break;
		default:
			break;
		}
	
	}
	
	
	public void inserirCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//RECUPERANDO OS DADOS VINDO NO REQUEST DA INDEX JSP
		
		//Instanciar a classe Cliente.
		Cliente cli = new Cliente();
		//Popular a classe cliente com os dados do request.
		cli.setNome(request.getParameter("txtNm"));
		cli.setSobrenome(request.getParameter("txtSnm"));
		try {
			cli.setDtNasc( new SimpleDateFormat("yyyy-MM-ddd").parse(request.getParameter("txtDtNasc")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cli.setGenero(request.getParameter("txtGen").charAt(0));
		cli.setTelefone(request.getParameter("txtTel"));
		
		//Instanciando a classe BO
		ClienteBO cb = new ClienteBO();
		String status = cb.cadastroCliente(cli);
		
		//Realizando uma validação para retornar ao usuário uma mensagem de status.
		if(status.equals("SUCESSO")) {
			//CRIANDO UM ATRIBUTO NO REQUEST COM A MSG DE SUCESSO.
			request.setAttribute("msgStatus", "Os dados foram gravados com SUCESSO!");
		}else if(status.equals("NOME DUPLICADO")) {
			//CRIANDO UM ATRIBUTO NO REQUEST COM A MSG DE NOME DUPLICADO.
			request.setAttribute("msgStatus", "Este nome já existe em nossa base de dados.");
		}else {
			//CRIANDO UM ATRIBUTO NO REQUEST COM A MSG DE ERRO/INSUCESSO.
			request.setAttribute("msgStatus", "Ocorreu um ERRO na gravação dos dados.");
		}
		
		//REALIZANDO O ECAMINHAMENTO.
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}
	

}
