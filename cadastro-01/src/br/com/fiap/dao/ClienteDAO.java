package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		
		String sql = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Cliente> lista = null;
		Cliente cli = null;
		
		try {
			
			//CRIANDO A INSTRUÇÃO SQL = SELECT ALL
			sql = "SELECT * FROM TBL_CLIENTE ORDER BY ID_CLI";
			
			//Criando a conexão.
			ps = con.prepareStatement(sql);
			
			//Criando o ResultSet que armazena o resultado da consulta.
			rs = ps.executeQuery();

			//Construindo a lista
			lista = new ArrayList<Cliente>();
			
			//Criando uma estrutura para percorrer o ResultSet e armazenar seu resultado em uma lista
			while (rs.next()) {
				//A cada nova iteração do while será criado um novo objeto Cliente
				cli = new Cliente();
				//Populando o objeto.
				cli.setId(Integer.parseInt(rs.getNString("id_cli")));
				cli.setNome(rs.getNString("nome_cli"));
				cli.setSobrenome(rs.getNString("sobrenome_cli"));
				cli.setDtNasc(new SimpleDateFormat("YYYY-MM-DD").parse(rs.getNString("data_nasc_cli")));
				cli.setGenero(rs.getNString("genero_cli").charAt(0));
				cli.setTelefone(rs.getNString("tel_cli"));
				//Adicionando na lista.
				lista.add(cli);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} 
		return lista;
	}
	
	public Cliente select(int idCli){
		String sql = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cliente cli = null;
		
		try {
			
			//CRIANDO A INSTRUÇÃO SQL = SELECT ALL
			sql = "SELECT * FROM TBL_CLIENTE WHERE ID_CLI = ?";
			
			//Criando a conexão.
			ps = con.prepareStatement(sql);
			
			//Popular a instrução SQL com o parâmetro que foi passado.
			ps.setInt(1, idCli);
			
			//Criando o ResultSet que armazena o resultado da consulta.
			rs = ps.executeQuery();
			
			//Criando uma estrutura para percorrer o ResultSet e armazenar seu resultado em uma lista
			while (rs.next()) {
				//A cada nova iteração do while será criado um novo objeto Cliente
				cli = new Cliente();
				//Populando o objeto.
				cli.setId(Integer.parseInt(rs.getNString("id_cli")));
				cli.setNome(rs.getNString("nome_cli"));
				cli.setSobrenome(rs.getNString("sobrenome_cli"));
				cli.setDtNasc(new SimpleDateFormat("YYYY-MM-DD").parse(rs.getNString("data_nasc_cli")));
				cli.setGenero(rs.getNString("genero_cli").charAt(0));
				cli.setTelefone(rs.getNString("tel_cli"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} 
		return cli;
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

		String sql = null;
		PreparedStatement ps = null;
		int status = 0;
		
		try {
		//CRIANDO A INSTRUÇÃO SQL
		sql = "UPDATE TBL_CLIENTE SET NOME_CLI = ?,SOBRENOME_CLI = ?,DATA_NASC_CLI = TO_DATE(?,'yyyy-MM-dd'),"
				+ "GENERO_CLI = ?,TEL_CLI = ? WHERE ID_CLI = ?";
		
		//Criando a conexão
		ps = con.prepareStatement(sql);
		
		
		//POPULANDO A CONEXÃO COM O OBJETO
		ps.setString(1, cli.getNome());
		ps.setString(2, cli.getSobrenome());
		ps.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(cli.getDtNasc()));
		ps.setString(4, String.valueOf(cli.getGenero()));
		ps.setString(5, cli.getTelefone());
		ps.setInt(6, idCli);
		
		//Gerando o retorno para avaliação
		status = ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	public int delete(int idCli){
		
		String sql = null;
		PreparedStatement ps = null;
		int status = 0;
		
		try {
			//Criando a instrução SQL
			sql = "DELETE FROM TBL_CLIENTE WHERE ID_CLI = ?";
			
			//Criando a conexão
			ps = con.prepareStatement(sql);
			
			//Popula a instrução SQL
			ps.setInt(1, idCli);
			
			//Coletando o status da operação
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

}









