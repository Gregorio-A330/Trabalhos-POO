package interface_grafica;

import java.sql.SQLException;

public class TestaArquivo {

	public static void main(String[] args) {

		CriaArquivoTexto.OpenFile();
		try {
			CriaArquivoTexto.addRecords();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CriaArquivoTexto.closeFile();

	}

}
