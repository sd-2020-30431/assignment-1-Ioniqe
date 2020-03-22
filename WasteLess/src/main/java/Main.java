import model.Charities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args){
        Charities charity = new Charities(1, "Saint John");
        Charities charity2 = new Charities(4, "Mother Mary");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.merge(charity);
        entityManager.merge(charity2);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();
    }
}
