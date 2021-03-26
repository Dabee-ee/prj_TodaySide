package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.write.Write;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class WriteRepository {

    private final EntityManager em;

    public void save(Write write) {
        em.persist(write);
    }

    public Write findOne(Long id) {
        return em.find(Write.class, id);
    }

    public List<Write> findAll() {
        return em.createQuery("select w from Write w",Write.class)
                .getResultList();
    }
}

