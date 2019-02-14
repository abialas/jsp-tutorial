package pl.sdacademy.user;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

/**
 * Created by adam.
 */
@Singleton
public class MemberDAO {

    @PersistenceContext(unitName = "testPersistenceUnit")
    private EntityManager entityManager;

    void saveMember(MemberAccount memberAccount) {
        if (memberAccount.getId() != null) {
            entityManager.merge(memberAccount);
        } else {
            entityManager.persist(memberAccount);
        }
    }

    Collection<MemberAccount> getMembers() {
        Query query = entityManager.createQuery("select u from MemberAccount u");
        return query.getResultList();
    }

    MemberAccount findById(Long userId) {
        return entityManager.find(MemberAccount.class, userId);
    }

}
