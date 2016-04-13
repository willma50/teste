 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BDMySql{
	
	private static BDMySql singleton = null;
	private Connection con;

	//padrao de projeto que cria uma única instancia da classe BDMySql
	public static BDMySql getInstance(){
		if (singleton == null)
		{
			singleton = new BDMySql();
		}		
			return singleton;
	}
	
	//construtor que conecta ao banco
	//Connection
public	BDMySql(){
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();

		      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdprojeto",
		        "root", "ifba");
							   
		}
		catch(Exception e) {
			System.out.println("Nao foi possível realizar a conexão.");
		}
		//return con;
	}
	//Executar consultas no banco: SELECTs
	public ResultSet executarBuscaSQL(String sql){
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rs;
		 }
		 catch(Exception e) {
			System.out.println("Nao foi possível recuperar dados.");
			return null;			
		 }
	}
	
	public int executarBuscaSQL2(String sql){
		int Cpf;
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			Cpf = rs.getInt("cpf");
			
			System.out.println(Cpf);
			return Cpf;
			//return rs;
		 }
		 catch(Exception e) {
			System.out.println("Nao foi possível recupear dados.");
			return 1;
		 }
		
	}
	//executar atualizações no banco: INSERTs, UPDATEs, DELETEs
	public void executarSQL(String sql){
		 try{
			 
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
			
		 }
		 catch(Exception e) {
			System.out.println("Nao foi possível executar SQL.");
		 }
	}
	
												
	
	
Connection	getConnection(){
	return con;
		
	}
	//fechando a conexão
	public void fecharConexao(){
		try{
			con.close();
		 }
		 catch(Exception e) {
			System.out.println("Nao foi possível fechar a conexão.");
		 }
	   
	}
	
	public void finalize(){
	 	fecharConexao();
  }

}
 
