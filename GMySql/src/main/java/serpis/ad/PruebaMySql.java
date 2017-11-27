package serpis.ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaMySql {

	public static void main(String[] args) throws SQLException {
		// TODO conectar
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/dbprueba", "root", "sistemas");
	
	connection.close();
	}
}
