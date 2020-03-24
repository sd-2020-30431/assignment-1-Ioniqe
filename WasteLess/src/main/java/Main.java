import model.Charities;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args){

        Charities charity = new Charities("Saint Nicolas");
        Charities charity2 = new Charities();

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(charity);

//            charity2 = session.get(Charities.class, 10);
//            charity2.setName("Food Haven");
//            session.delete(charity2);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List< Charities > charities = session.createQuery("from Charities", Charities.class).list();
            charities.forEach(c -> System.out.println(c.getId() + " | " +c.getName()));

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
}

//TODO create -> din xml cu create/create-drop in loc de update
//TODO read cu get sau load? | cu createQuery ("from ceva")
//TODO update -> cu get si apoi update (trebe id)
//TODO delete cu get (trebe id) si apoi delete
//TODO insert cu save
