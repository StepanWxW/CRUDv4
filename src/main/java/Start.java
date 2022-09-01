import model.Region;
import org.hibernate.Session;
import util.HibernateSessionFactory;

public class Start {
    public static void main(String[] args) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Region region = new Region();
        region.setName("Tomsk");
        session.save(region);
        session.getTransaction().commit();
        session.close();
        HibernateSessionFactory.close();
    }
}
