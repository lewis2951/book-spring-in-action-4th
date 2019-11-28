package spittr.db.jpa;

import org.springframework.stereotype.Repository;
import spittr.db.SpittleRepository;
import spittr.domain.Spittle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaSpittleRepository implements SpittleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public List<Spittle> findRecent() {
        return findRecent(10);
    }

    @Override
    public List<Spittle> findRecent(int count) {
        return (List<Spittle>) entityManager.createQuery("select s from Spittle s order by s.postedTime desc")
                .setMaxResults(count)
                .getResultList();
    }

    @Override
    public Spittle findOne(long id) {
        return entityManager.find(Spittle.class, id);
    }

    @Override
    public Spittle save(Spittle spittle) {
        entityManager.persist(spittle);
        return spittle;
    }

    @Override
    public List<Spittle> findBySpitterId(long spitterId) {
        return (List<Spittle>) entityManager.createQuery("select s from Spittle s, Spitter sp where s.spitter = sp and sp.id=? order by s.postedTime desc")
                .setParameter(1, spitterId)
                .getResultList();
    }

    @Override
    public void delete(long id) {
        entityManager.remove(findOne(id));
    }

    public List<Spittle> findAll() {
        return (List<Spittle>) entityManager.createQuery("select s from Spittle s").getResultList();
    }

}
