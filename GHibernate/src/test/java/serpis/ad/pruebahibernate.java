package serpis.ad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class pruebahibernate {

	public static void main(String[]args){
		EntityManagerFactory entityManagerFactory =
		Persistence.createEntityManagerFactory("serpis.ad.ghibernate");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Categoria categoria = entityManager.find(Categoria.class, 1L);
		System.out.println(categoria);
		entityManager.getTransaction().commit();
		entityManagerFactory.close();
		}
}
