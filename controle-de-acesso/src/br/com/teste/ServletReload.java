package br.com.teste;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletReload
 */
@WebServlet("/validacao")
public class ServletReload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletReload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		/**
		 * Inicio do bloco de Processamento
		 */
		String nomeUser  = "";
		String senhaUser = "";
		nomeUser  = request.getParameter("nmEmail");
		senhaUser = request.getParameter("nmSenha");
		System.out.println("Nome  do Usuário : " + nomeUser);
		System.out.println("Senha do Usuário : " + senhaUser);
		/**
		 * Fim do bloco de Processamento
		 */
		
		/**
		 * Inicio do bloco de Redirecionamento
		 * 
		 */
			
			if(nomeUser.equals("juquinha@bala.com.br") && senhaUser.equals("12345")) {
				//response.sendRedirect("sucesso.html");
				//Realizando um dispatching
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				
				//Adicionando o login e a senha no request e vou enviar para a página index.jsp
				
				//Para enviar qualquer informação no request aqui na Servlet, precisamos adicionar
				// os dados como atributo do request.
				request.setAttribute("attrUser", nomeUser);
				request.setAttribute("attrPass", senhaUser);
				
				//Neste Forward é enviado qualquer informação que for adicionada
				//no request em seus atributos.
				rd.forward(request, response);
				
			}else {
				response.sendRedirect("erro.html");
			}
		
		/**
		 * Fim do bloco de Processamento
		 */
		
	}


}
