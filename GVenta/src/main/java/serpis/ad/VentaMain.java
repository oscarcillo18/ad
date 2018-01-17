package serpis.ad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.w3c.dom.events.Event;
import org.jboss.*;


public class VentaMain {
	
private static EntityManagerFactory entityManagerFactory; 
	
	public static void main(String[] args) {		
		entityManagerFactory =
				Persistence.createEntityManagerFactory("serpis.ad.gventa");
		
		//showCategorias();
		//showArticulos();
		showCliente();
		
		
		
		//showCliente();
		//newPedido();
		//showPedidos();
		
		entityManagerFactory.close();
		

	}
	
	private static void showCategorias() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Categoria> categorias = entityManager
				.createQuery("from Categoria order by id", Categoria.class).getResultList();
		for (Categoria categoria : categorias)
			System.out.println(categoria);
		entityManager.getTransaction().commit();
	}
	
	private static void showArticulos() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Articulo> articulos= entityManager
				.createQuery("from Articulo order by id", Articulo.class).getResultList();
		for (Articulo articulo: articulos)
			System.out.println(articulo);
		entityManager.getTransaction().commit();
	}
	
	private static void showCliente() {
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	entityManager.getTransaction().begin();
	List<Cliente> clientes = entityManager
			.createQuery("from Cliente order by id", Cliente.class).getResultList();
	for (Cliente cliente: clientes)
		System.out.println(cliente);
	entityManager.getTransaction().commit();
	}
	
	/* private static void showPedidos() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Pedido> pedidos = entityManager
				.createQuery("from pedido order by id", Pedido.class).getResultList();
		for (Pedido pedido : pedidos)
			System.out.println(pedido);
		entityManager.getTransaction().commit();
	} */
	
	/*
	private static void newPedido() {
		System.out.println("Creando pedido nuevo ");
		Pedido pedido = new Pedido();
		pedido.setFecha(new Date());
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(pedido);
		System.out.println("Creada " + pedido);
		entityManager.getTransaction().commit();
	}*/
}