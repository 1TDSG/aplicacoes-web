package br.com.fiap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class ExemploServlet
 */
@WebServlet("/exemplo")
public class ExemploServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExemploServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		
//		request.setAttribute("nmUser", "aljesus");
//		RequestDispatcher rd = request.getRequestDispatcher("principal.jsp");
//		rd.forward(request, response);
//		
//		request.getRequestDispatcher("principal.jsp").forward(request, response);
		
		//Escopo de Sessão
		HttpSession sessao = request.getSession();
		
		
		//Setando a inatividade da Sessão.
		//sessao.setMaxInactiveInterval(60);
		
		
		//Criando atributos na sessão
		sessao.setAttribute("idSession", sessao.getId());
		sessao.setAttribute("usuario", "alejesu");
		
		
		//Recuperando o atributo da sessão
		//Quando recuperamos atributos é necessário realizar um CAST
		// Pois os atributos sofrem uma alteração no envio do seu tipo original para Object.
		// Ex: String nomeUsuario = (String)request.getAttibute("usuario")
		String atributoSessao = (String)sessao.getAttribute("idSession");
				
		System.out.println("ID da Sessão : " + atributoSessao);		
		
		if(request.getParameter("logout").equals("1")) {
			sessao.invalidate();
		}
		
		//Criando redirect para um JSP e passando um parâmetro.
		response.sendRedirect("principal.jsp?nome=Alexandre");
		//response.sendRedirect("http://www2.fiap.com.br");
		
	}

}
