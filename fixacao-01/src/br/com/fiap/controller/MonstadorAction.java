package br.com.fiap.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MonstadorAction
 */
@WebServlet(urlPatterns = {"/montador","/construtor","/index.php","/html","/imagens"})
public class MonstadorAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonstadorAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recuperando os valores do Request
		String nomeImg = request.getParameter("img-uri");
		String pathImg = request.getParameter("img-url");
		String captImg = request.getParameter("img-capt");
		
		//Verificando o PATH da img
		System.out.println("PATH : " + pathImg+nomeImg);
		
		//Encaminhar um atributo com o Path montado
		// para o index.JSP
		
		//Primeira coisa é criar um atributo no request.
		request.setAttribute("attrImg", pathImg+nomeImg);
		request.setAttribute("attrCaptFig", captImg);
		
		//Segunda coisa é criar o dispatcher para o index.jsp
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		
		//É obrigatório nos casos que tenha o dispatcher, encaminhar o
		// request e o response.
		rd.forward(request, response);
		
	}

}











