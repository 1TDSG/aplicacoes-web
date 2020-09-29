package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import br.com.fiap.bean.Cliente;
import br.com.fiap.connection.ConnectionFactory;

public class ClienteDAO {
	
	private Connection con;
	
	public ClienteDAO() {
		//Instanciando a classe de conexão.
		try {
			con = new ConnectionFactory().DBConnectionManager();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<Cliente> select(){
		return null;
	}
	
	public Cliente select(int idCli){
		return null;
	}
	
	public int insert(Cliente cli){
		
		//Criando os objetos de conexão
		PreparedStatement ps = null;
		String sql = null;
		int status = 0;
		
		try {
			//CRIANDO A INSTRUÇÃO SQL
			sql = "INSERT INTO TBL_CLIENTE VALUES(SEQ_CLIENTE_A.NEXTVAL,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";
			
			//CRIANDO A CONEXÃO
			ps = con.prepareStatement(sql);
			
			//POPULAR O INSERT
			ps.setString(1, cli.getNome());
			ps.setString(2, cli.getSobrenome());
			ps.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(cli.getDtNasc()));
			ps.setString(4, String.valueOf(cli.getGenero()));
			ps.setString(5, cli.getTelefone());
			
			//EXECUTAR A INSTRUÇÃO E RECUPERAR O RESULTADO
			status = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return status;
		
	}

	public int update(Cliente cli, int idCli){
		return 0;
	}

	public int delete(int idCli){
		return 0;
	}

}
