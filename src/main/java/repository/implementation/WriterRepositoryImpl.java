package repository.implementation;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import model.Writer;
import org.hibernate.Session;
import repository.WriterRepository;
import util.SessionUtil;

import java.util.List;

public class WriterRepositoryImpl implements WriterRepository {
    SessionUtil sessionUtil = new SessionUtil();
    @Override
    public Writer create(Writer writer) {
        Session session = sessionUtil.openTransactionSession();
        session.persist(writer);
        session.getTransaction().commit();
        session.close();
        return writer;
    }

    @Override
    public List<Writer> getAll() {
        List<Writer> writerList;
        Session session = sessionUtil.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Writer> cq = cb.createQuery(Writer.class);
        cq.from(Writer.class);
        writerList = session.createQuery(cq).getResultList();
        session.close();
        return writerList;
    }

    @Override
    public Writer getById(Long id) {
        Session session = sessionUtil.openSession();
        Writer writer = session.get(Writer.class, id);
        session.close();
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        try(Session session = sessionUtil.openTransactionSession()) {
        session.saveOrUpdate(writer);
        session.getTransaction().commit();
        } catch (EntityNotFoundException e) {
        System.out.println("Writer whit id: " + writer.getWriter_id() + " is missing.");
    }
        return writer;
    }

    @Override
    public void remove(Long id) {
        try(Session session = sessionUtil.openTransactionSession()) {
        Writer writer = session.load(Writer.class, id);
        session.delete(writer);
        session.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("Writer whit id: " + id + " is missing.");
        }
    }
}
