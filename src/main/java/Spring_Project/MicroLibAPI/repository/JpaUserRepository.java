package Spring_Project.MicroLibAPI.repository;

import Spring_Project.MicroLibAPI.domain.Users;
import jakarta.persistence.EntityManager;

import java.util.Map;
import java.util.Optional;

public class JpaUserRepository implements UserRepository {

    private final EntityManager em;
    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Users save(Users user) {
        em.persist(user);
        return user;
    }

    @Override
    public Optional<Users> findById(Long id) {
        return Optional.ofNullable(em.find(Users.class, id));
    }
}
