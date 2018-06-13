package interface_grafica;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import codigos.Fornecedor;

public class CriaArquivoTexto {
	
	static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/perfumariajava";
	
	private static Formatter output;
	public static void OpenFile(){
		try{
			output = new Formatter("C:\\Users\\GabrielCouto\\Desktop\\Gabriel.txt");
		}
		catch(SecurityException s){
			System.err.println(s);
			System.exit(1);
		}
		catch(FileNotFoundException f){
			System.err.println(f);
			System.exit(1);
		}
	}
	
	public static void addRecords() throws SQLException{
		
		ArrayList<Fornecedor> ArrForn = new ArrayList<Fornecedor>();
		
		String cnpj, nome, email, endereco, telefone;
	
		ResultSet rs = null;
		Connection con = null;
		Statement stm = null;
		
		
		
		con = DriverManager.getConnection(DATABASE_URL, "root", "Uikujgt2@");
		stm = con.createStatement();
		rs = stm.executeQuery("select * from fornecedor");
	
		
		while(rs.next()){
		
			cnpj = rs.getString("cnpj");
			nome = rs.getString("nome");
			email = rs.getString("email");
			endereco = rs.getString("endereco");
			telefone = rs.getString("telefone");
				
			
			
			Fornecedor forne = new Fornecedor(cnpj, nome, email, endereco, telefone);
			ArrayList<Fornecedor> f = new ArrayList<Fornecedor>();
			output.format("%s %s %s %s %s\r\n" ,cnpj, nome, email, endereco, telefone);			
			
		}
		
		//output.format( "%s %s %s %s %s\n", ArrForn);
		
		
		
	}
		public static void closeFile(){
			if(output != null){
				output.close();
			}
		}
	}
