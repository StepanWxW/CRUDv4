package repository.implementation;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import model.Post;
import org.hibernate.Session;
import repository.PostRepository;
import util.SessionUtil;

import java.sql.Timestamp;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {
    SessionUtil sessionUtil = new SessionUtil();
    @Override
    public Post create(Post post) {
        Session session = sessionUtil.openTransactionSession();
        post.setCreated(new Timestamp(System.currentTimeMillis()));
        post.setUpdated(new Timestamp(System.currentTimeMillis()));
        session.persist(post);
        session.getTransaction().commit();
        session.close();
        return post;
    }

    @Override
    public List<Post> getAll() {
        List<Post> postsList;
        Session session = sessionUtil.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Post> cq = cb.createQuery(Post.class);
        cq.from(Post.class);
        postsList = session.createQuery(cq).getResultList();
        session.close();
        return postsList;
    }

    @Override
    public Post getById(Long id) {
        Session session = sessionUtil.openSession();
        Post post = session.get(Post.class, id);
        session.close();
        return post;
    }

    @Override
    public Post update(Post post) {
        Post post1 = getById(post.getPost_id());
        try(Session session = sessionUtil.openTransactionSession()) {
        post.setCreated(post1.getCreated());
        post.setUpdated(new Timestamp(System.currentTimeMillis()));
        session.update(post);
        session.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("Post whit id: " + post.getPost_id() + " is missing.");
        }
        return post;
    }

    @Override
    public void remove(Long id) {
        try(Session session = sessionUtil.openTransactionSession()) {
        Post post = session.load(Post.class, id);
        session.delete(post);
        session.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("Post whit id: " + id + " is missing.");
        }
    }
}
