package serpis.ad;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ArticuloDao {

	public static void Listar() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba","root","sistemas");
		Statement stmt = connection.createStatement();

	    String sql = "SELECT * FROM articulo";
	    ResultSet rs = stmt.executeQuery(sql);
	    
	    while(rs.next()){
	         long id  = rs.getLong("id");
	         String nombre = rs.getString("nombre");
	         BigDecimal precio = rs.getBigDecimal("precio");
	         long categoria = rs.getLong("categoria");

	         System.out.println("ID: " + id + " nombre: " + nombre + " precio: " + precio + " categoria: " + categoria);
	      }
	    
	      rs.close();
	      stmt.close();
	}
	
	public static void Editar() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba", "root", "sistemas");
		Statement stp = connection.createStatement();
		Scanner sn = new Scanner(System.in);
		System.out.print("Introduce id del dato a modificar: ");
		long id = sn.nextLong();
		String sql = "SELECT * FROM articulo where ID =" + id;
		ResultSet rs = stp.executeQuery(sql);

		while (rs.next()) {
			String nombre = rs.getString("nombre");
			BigDecimal precio = rs.getBigDecimal("precio");
			long categoria = rs.getLong("categoria");
			System.out.println(
					"ID: " + id + " nombre: " + nombre + " 		categoria: " + categoria + " 		precio: " + precio);
		}
		
		sn.nextLine();
		System.out.println("¿Qué deseas editar? Nombre/Categoria/Precio");
		String editar = sn.nextLine().toLowerCase();

		if (editar.equals("nombre")) {
			System.out.println("Introduzca el nombre: ");
			String newN = sn.nextLine();
			String entryN = "UPDATE articulo SET nombre = '" + newN + "' WHERE id = " + id;
			PreparedStatement pst = connection.prepareStatement(entryN);
			pst.executeUpdate();
			pst.close();
			System.out.println("Dato actualizado.");

		} else if (editar.equals("categoria")) {
			System.out.println("Introduzca la Categoria: ");
			long newC = sn.nextLong();
			String entryC = "UPDATE articulo SET categoria = '" + newC + "' WHERE id = " + id;
			PreparedStatement pst = connection.prepareStatement(entryC);
			pst.executeUpdate();
			pst.close();
			System.out.println("Dato actualizado.");

		} else if (editar.equals("precio")) {
			System.out.println("Introduzca la Precio: ");
			String newP = sn.nextLine();
			String entryP = "UPDATE articulo SET precio = '" + newP + "' WHERE id = " + id;
			PreparedStatement pst = connection.prepareStatement(entryP);
			pst.executeUpdate();
			pst.close();
			System.out.println("Dato actualizado.");
		}
		rs.close();
		stp.close();
		connection.close();
	}
	
	public static void Consultar() throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/dbprueba","root","sistemas");
		Statement stmt = connection.createStatement();
		
		Scanner sn = new Scanner(System.in);
		System.out.print("Introduce el registro que deseas consultar: ");
		int idConsultar = sn.nextInt();
	    String sql = "SELECT * FROM articulo where id=" + idConsultar;
	    ResultSet rs = stmt.executeQuery(sql);
	    
	    while(rs.next()){
	         long id  = rs.getLong("id");
	         String nombre = rs.getString("nombre");
	         BigDecimal precio = rs.getBigDecimal("precio");
	         long categoria = rs.getLong("categoria");

	         System.out.println("ID: " + id + " nombre: " + nombre + " precio: " + precio + " categoria: " + categoria);
	      }

	    rs.close();
	    stmt.close();
	}
	
	public static void Eliminar() throws SQLException {
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/dbprueba", "root", "sistemas");
		
		Statement stmt = connection.createStatement();
        Scanner sn = new Scanner(System.in);
        
        System.out.println("Introduce un numero para eliminar" );
        
        long id = sn.nextInt();
        String sql = "DELETE FROM articulo where ID= ?";
        
        PreparedStatement pst = connection.prepareStatement(sql);
        
        pst.setLong(1, id);
        pst.executeUpdate();
        
        stmt.close();
        connection.close();

	}
	public static void Nuevo() throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/dbprueba", "root", "sistemas");
		Statement stp = connection.createStatement();
		Scanner sn = new Scanner(System.in);
		System.out.println("Introduce un Nombre: ");
		String nombre = sn.nextLine();
		System.out.println("Introduce un Categoria: ");
		long categoria = sn.nextLong();
		System.out.println("Introduce un Precio: ");
		double precio = sn.nextDouble();
		String sql = "INSERT INTO articulo (nombre, categoria, precio) VALUES ('" + nombre + "', "
				+ "'" + categoria + "', '" + precio + "')";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.executeUpdate();
		pst.close();
		connection.close();
	}

}
