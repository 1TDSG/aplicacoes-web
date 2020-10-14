package br.com.fiap.exemplo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Manipulador {

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./properties/dados.properties");
		
		props.load(file);
		return props;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		String host = null;
		String password = null;
		String login = null;
		
		Properties prop = getProp();
		host = prop.getProperty("prop.server.host");
		password = prop.getProperty("prop.server.password");
		login = prop.getProperty("prop.server.login"); 
		
		System.out.println("************************Teste de leitura do arquivo de Propriedades**********");
		System.out.println("HOST     : " +host);
		System.out.println("PASSWORD : " +password);
		System.out.println("LOGIN    : " +login);
		
		
	}

}
