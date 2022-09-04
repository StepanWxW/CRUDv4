package repository.implementation;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import model.Region;
import org.hibernate.Session;
import repository.RegionRepository;
import util.SessionUtil;

import java.util.List;

public class RegionRepositoryImpl implements RegionRepository {
    SessionUtil sessionUtil = new SessionUtil();
    @Override
    public Region create(Region region) {
        Session session = sessionUtil.openTransactionSession();
        session.persist(region);
        session.getTransaction().commit();
        session.close();
        return region;
    }

    @Override
    public List<Region> getAll() {
        List<Region> regionList;
        Session session = sessionUtil.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Region> cq = cb.createQuery(Region.class);
        cq.from(Region.class);
        regionList = session.createQuery(cq).getResultList();
        session.close();
        return regionList;
    }

    @Override
    public Region getById(Long id) {
        Session session = sessionUtil.openSession();
        Region region = session.get(Region.class, id);
        session.close();
        return region;
    }

    @Override
    public Region update(Region region) {
        try(Session session = sessionUtil.openTransactionSession()) {
            session.saveOrUpdate(region);
            session.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("Region whit id: " + region.getRegion_id() + " is missing.");
        }
        return region;
    }

    @Override
    public void remove(Long id) {
        try(Session session = sessionUtil.openTransactionSession()) {
            Region region = session.load(Region.class, id);
            session.delete(region);
            session.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("Region whit id: " + id + " is missing.");
        }
    }
}
