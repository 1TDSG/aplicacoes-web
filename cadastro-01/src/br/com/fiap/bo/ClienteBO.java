package br.com.fiap.bo;

import br.com.fiap.bean.Cliente;
import br.com.fiap.dao.ClienteDAO;

public class ClienteBO {

	// Criando um atributo do tipo DAO
	private ClienteDAO cd = null;

	public String cadastroCliente(Cliente cli) {

		cd = new ClienteDAO();
		if (cd.insert(cli) >= 1) {
			return "SUCESSO";
		} else {
			return "FRACASSO";
		}

//		if(!verificaNomeDuplicado(cli.getNome())) {
//			System.out.println("ACESSOU");
//			if(cd.insert(cli) >= 1 ) {
//				return "SUCESSO";
//			}else {
//				return "FRACASSO";
//			}
//		}else {
//			return "ERRO:NOME DUPLICADO";
//		}
//		
	}

	public boolean verificaNomeDuplicado(String nome) {

		if (nome.equals("Alexandre")) {
			// String sql = "SELECT NOME_CLIENTE FROM TBL_CLIENTE WHERE NOME_CLI = ?";
			return false;
		} else {
			return true;
		}
	}

}
