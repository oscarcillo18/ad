package serpis.ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ArticuloDao {

	public static void Eliminar() throws SQLException {
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/dbprueba", "root", "sistemas");
		
		Statement stmt = connection.createStatement();
        Scanner sn = new Scanner(System.in);
        
        System.out.println("Introduce un numero para eliminar" );
        
        long id = sn.nextInt();
        String sql = "DELETE * FROM articulo where ID= ?";
        
        PreparedStatement pst = connection.prepareStatement(sql);
        
        pst.setLong(1, id);
        pst.executeUpdate();
        
        stmt.close();
        connection.close();

	}

}
