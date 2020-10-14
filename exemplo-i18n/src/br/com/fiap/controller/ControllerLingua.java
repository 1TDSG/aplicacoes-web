package br.com.fiap.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

/**
 * Servlet implementation class ControllerLingua
 */
@WebServlet("/change")
public class ControllerLingua extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLingua() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Variável que vai receber o parâmetro do Locale
		String language = req.getParameter("lingua");
		
		//Objeto que armazena o Locale escolhido pelo usuário
		//Ex de locale: pt-br, en, en-US, de, ep, fr, etc;
		Locale locale = new Locale(language);
		
		//O CONFIG faz inicialmente a alteração do LOCALE do Sistema
		Config.set(req.getSession(), Config.FMT_LOCALE, locale);
		//Agora faz a alteração do locale do browser do usuário.
		Config.set(req.getSession(), Config.FMT_FALLBACK_LOCALE, locale);
		
		//Realziando o redirecionamento do usuário para a página que chamou.
		resp.sendRedirect("index.jsp?lingua="+locale);
	}

}
