package br.com.fiap.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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
@WebServlet( urlPatterns = { "/cliente", "/list-cli", "/listar", "/update", "/excluir"})
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

		case "/cadastro-01/list-cli":
			listarCliente(request, response);
			break;
			
		case "/cadastro-01/listar":
			listarCliente(request, response, Integer.parseInt(request.getParameter("idCli")));
			break;

		case "/cadastro-01/update":
			try {
				atualizarCliente(request, response);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case "/cadastro-01/excluir":
			apagarCliente(request, response, Integer.parseInt(request.getParameter("idCli")));
			break;
			
		default:
			response.sendRedirect("index.jsp?msgStaus=PASSOU DIRETO");
			break;
		}
	
	}
	
	
	//EXCLUINDO CLIENTE
	public void apagarCliente(HttpServletRequest request, HttpServletResponse response, int idCli) throws IOException {
		
		//Instanciar a classe BO
		ClienteBO cb = new ClienteBO();
		
		//Recebendo o status da opera�ao.
		int status = cb.excluirCliente(idCli);
		
		//Verificando o status
		if(status > 0) {
			//Criar uma mensagem em um par�metro e enviar por redirecionamento atrav�s do
			//Redirect| Obs: Este par�metro deve ser recebido no JSP com o contexto do PARAM.
			// Ex: param.nomeDoParametro.
			response.sendRedirect("index.jsp?msgStatus=Dados excluidos com SUCESSO!");
		}else {
			response.sendRedirect("index.jsp?msgStatus=Ocorreu um erro ao tentar EXCLUIR os dados!");
		}
	}

	//ATUALIZA CLIENTE
	public void atualizarCliente(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
		
		//Receber os dados da atualiza��o do cliente vindos da p�gina atualiza.jsp
		
		//Instanciando a classe Cliente
		Cliente cli = new Cliente();
		//Populando o objeto com os dados que est�o no request.
		cli.setId(Integer.parseInt(request.getParameter("txtIdCli")));
		cli.setNome(request.getParameter("txtNm"));
		cli.setSobrenome(request.getParameter("txtSnm"));
		cli.setDtNasc(request.getParameter("txtDtNasc"));
		cli.setGenero(request.getParameter("txtGen").charAt(0));
		cli.setTelefone(request.getParameter("txtTel"));
		
		//Instanciando a classe BO
		ClienteBO cb = new ClienteBO();
		
		//Criando a vari�vel de status da atualiza��o
		int status = cb.atualizacaoCliente(cli, cli.getId());
		
		if(status > 0) {
			//Criar uma mensagem em um par�metro e enviar por redirecionamento atrav�s do
			//Redirect| Obs: Este par�metro deve ser recebido no JSP com o contexto do PARAM.
			// Ex: param.nomeDoParametro.
			response.sendRedirect("index.jsp?msgStatus=Os dados foram ATUALIZADOS com SUCESSO!");
		}else {
			response.sendRedirect("index.jsp?msgStatus=Ocorreu um erro ao tentar atualizar os dados!");
		}
	}

	//LISTAR  O CLIENTE
	public void listarCliente(HttpServletRequest request, HttpServletResponse response, int idCli) throws ServletException, IOException {
		//Instaciando a classe BO
		ClienteBO cb = new ClienteBO();
		
		//Criando o Cliente para receber os dados do m�todo listagem by ID
		Cliente cli = cb.listagemCliente(idCli);
		
		//Verifica��o na lista.
		if(cli != null) {
			//Adicionando o cliente em um atributo do request para que ele seja enviada para a p�gina atualiza.jsp
			request.setAttribute("objCli", cli);
			
			//Realizando o encaminhamento de fato.
			request.getRequestDispatcher("/WEB-INF/atualiza.jsp").forward(request, response);
		}else {
			//Criando a mensagem de erro no par�metro em caso da lista estar nula.
			response.sendRedirect("index.jsp?msgStatus=Ocorreu um erro ao tentar atualizar os dados!");
		}

	}

	//LISTAR TODOS OS CLIENTES
	public void listarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Instaciando a classe BO
		ClienteBO cb = new ClienteBO();
		
		//Criando a lista para receber os dados do m�todo listagem
		List<Cliente> lista = cb.listagemCliente();
		
		//Verifica��o na lista.
		if(lista != null) {
			//Adicionando a lista em um atributo do request para que ela seja enviada para a p�gina lista.jsp
			request.setAttribute("listaCli", lista);
			
			//Realizando o encaminhamento de fato.
			request.getRequestDispatcher("/WEB-INF/lista.jsp").forward(request, response);
		}else {
			//Criando a mensagem de erro no par�metro em caso da lista estar nula.
			response.sendRedirect("index.jsp?msgStatus=Ocorreu um erro ao listar os dados!");
		}
		
	}

	//INSERIR CLIENTE
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
		
		//Realizando uma valida��o para retornar ao usu�rio uma mensagem de status.
		if(status.equals("SUCESSO")) {
			//CRIANDO UM ATRIBUTO NO REQUEST COM A MSG DE SUCESSO.
			//request.setAttribute("msgStatus", "Os dados foram gravados com SUCESSO!");
			
			//Criar uma mensagem em um par�metro e enviar por redirecionamento atrav�s do
			//Redirect| Obs: Este par�metro deve ser recebido no JSP com o contexto do PARAM.
			// Ex: param.nomeDoParametro.
			response.sendRedirect("index.jsp?msgStatus=Os dados foram gravados com SUCESSO!");
		}else if(status.equals("NOME DUPLICADO")) {
			//CRIANDO UM ATRIBUTO NO REQUEST COM A MSG DE NOME DUPLICADO.
			//request.setAttribute("msgStatus", "Este nome j� existe em nossa base de dados.");
			
			//CRIANDO UM PAR�METRO COM A MSG DE NOME DUPLICADO.
			response.sendRedirect("index.jsp?msgStatus=Este nome j� existe em nossa base de dados.");
		}else {
			//CRIANDO UM ATRIBUTO NO REQUEST COM A MSG DE ERRO/INSUCESSO.
			//request.setAttribute("msgStatus", "Ocorreu um ERRO na grava��o dos dados.");
			
			//CRIANDO UM PAR�METRO COM A MSG DE ERRO/INSUCESSO.
			response.sendRedirect("index.jsp?msgStatus=Ocorreu um ERRO na grava��o dos dados.");
		}
		
		//REALIZANDO O ECAMINHAMENTO.
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	

}







