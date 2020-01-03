
package application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Seller;

class MainJPA {
	
	public static void main(String[] args) {
		
		// Record entity
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemyJava2019-JPA");
//		EntityManager em = emf.createEntityManager();
//		Seller seller = new Seller(null, "Dino da Silva Sauro", "dino@familiadinossauro.com", 3500.0, LocalDate.of(1983, 3, 7) , new Department(2,""));
//		System.out.println(seller);
//		em.getTransaction().begin();
//		em.persist(seller);
//		em.getTransaction().commit();
//		em.close();
//		emf.close();


		// Retrive entity
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemyJava2019-JPA");
//		EntityManager em = emf.createEntityManager();
//		Seller seller = em.find(Seller.class, 2);
//		System.out.println(seller);
//		em.close();
//		emf.close();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemyJava2019-JPA");
		EntityManager em = emf.createEntityManager();
		Query query = em.createNativeQuery("SELECT * FROM SELLER", Seller.class);
		@SuppressWarnings("unchecked")
		List<Seller> sellers = query.getResultList(); 
		sellers.forEach(System.out::println);
		em.close();
		emf.close();
			    
	}
	
}