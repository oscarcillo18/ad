package serpis.ad;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void Menu() throws SQLException {
		 
        Scanner sn = new Scanner(System.in);
        int opcion = 0; 
 
            System.out.println("1. Salir");
            System.out.println("2. Nuevo");
            System.out.println("3. Editar");
            System.out.println("4. Eliminar");
            System.out.println("5. Consultar");
            System.out.println("6. Listar");
 
            try {
 
                System.out.println("Elige una opción");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Salir");
                        break;
                    case 2:
                        System.out.println("Nuevo");
                        break;
                    case 3:
                        System.out.println("Editar");
                        break;
                    case 4:
                    	System.out.println("Eliminar");
                    	ArticuloDao.Eliminar();
                        break;
                    case 5:
                    	System.out.println("Consultar");
                        break;
                    case 6:
                    	System.out.println("Listar");
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 6");
                        break;
                }
            } catch (InputMismatchException e) {          
                System.out.println("Debes insertar un número");    
                Menu();
            }
        

	}

}
