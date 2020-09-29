package br.com.fiap.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.Cliente;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet(description = "Controladora de acesso e requisições.", urlPatterns = { "/exemploControle" })
public class ExemploController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<Cliente> lista = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExemploController() {

		if (lista == null) {
			lista = new ArrayList<Cliente>();

			Cliente cli = new Cliente();
			cli.setNome("Alexandre");
			cli.setSobrenome("Carlos");
			// Criando a formatação da Data.
			Calendar c = Calendar.getInstance();
			SimpleDateFormat sf = new SimpleDateFormat("dd/mm/yyyy");
			try {
				c.setTime(sf.parse("27/12/1975"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			cli.setDtNasc(c.getTime());
			cli.setGenero('m');
			cli.setTelefone("(11) 97654-6745");
			// Adicionando um cliente na lista
			lista.add(cli);

			cli = new Cliente();
			cli.setNome("João");
			cli.setSobrenome("Marcos");
			// Criando a formatação da Data.
			c = Calendar.getInstance();
			sf = new SimpleDateFormat("dd/mm/yyyy");
			try {
				c.setTime(sf.parse("21/04/1964"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			cli.setDtNasc(c.getTime());
			cli.setGenero('m');
			cli.setTelefone("(11) 96789-3456");
			// Adicionando um cliente na lista
			lista.add(cli);

		}

	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("origem do request: " + request.getRequestURI());

		// Request realizado para a inserção dos dados na lista.
		if (request.getRequestURI().equals("/cadastro-01/clientes")) {
			// Realizando a recepção do dados do FORMULÁRIO! ==INICIO
			// Passo - 1 = Criar a instância da classe Cliente
			Cliente cli = null;

			// Criando o objeto e inserindo os dados do request no objeto Cliente.
			cli = new Cliente();
			cli.setNome(request.getParameter("txtNm"));
			cli.setSobrenome(request.getParameter("txtSnm"));

			// ****** Criando a formatação para a data. ***********
			Calendar c = Calendar.getInstance();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				c.setTime(sf.parse(request.getParameter("txtDtNasc")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			cli.setDtNasc(c.getTime());
			// ****** Criando a formatação para a data. ***********

			cli.setGenero(request.getParameter("txtGen").charAt(0));
			cli.setTelefone(request.getParameter("txtTel"));
			// Realizando a recepção do dados do FORMULÁRIO! ==FIM

			// Passo - 2 = Adicionar os dados ao banco de dados virtual, na lista.
			// Adiciona o objeto na lista
			lista.add(cli);

			// Passo - 3 = Realizar o encaminhamento do request/response contendo a lista
			// para a página de listagem.

			// a - Criando os atributos no request.
			request.setAttribute("listaCli", lista);
			// Criando um atributo de controle
			request.setAttribute("action", "clientes");

			// b - Criando o Dispatcher
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/lista.jsp");

			// c - Realizando o encaominhamento de fato, passando o request e response.
			rd.forward(request, response);

			// Request realizado para a atualização dos dados na lista.
		} else if (request.getRequestURI().equals("/cadastro-01/listar")) {

			// Recuperar um cliente da lista através de um ID que vem no parâmetro do
			// request.

			// Recuperando o parâmetro do request e realizando um parse.
			int id = Integer.parseInt(request.getParameter("idCli"));

			// Estrutura para percorrer a lista indice por indice.
			for (int x = 0; x < lista.size(); x++) {

				// Devemos criar uma estrutura de decisão, para verificar os indices se batem
				// com o ID do parâmetro.
				if (x == (id - 1)) {

					// Realizar o processo de encaminhamento do objeto

					// Adicionar o objeto recuperado em um atributo do request.
					request.setAttribute("objCli", lista.get(x));

					// Criando um atributo de controle
					request.setAttribute("action", "update");
					
					// Criando um atributo para modificar o title de index.jsp
					request.setAttribute("title", "ATUALIZAR");
					
					// Criando um atributo para modificar a legenda do FORM da index.jsp
					request.setAttribute("legenda", "Atualização de Dados");
					
					
					// Realiza o encaminhamento
					request.getRequestDispatcher("index.jsp").forward(request, response);
					
					
					
				}

			}

		}

	}

}
