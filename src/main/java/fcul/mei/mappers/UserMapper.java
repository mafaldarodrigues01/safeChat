package fcul.mei.mappers;

import jakarta.persistence.EntityManager;
import model.User;

public class UserMapper implements IMapper<User, String>{


    private final EntityManager entityManager;

    public UserMapper(EntityManager em) {
        this.entityManager = em;
    }


    @Override
    public User get(String username) {
        return entityManager.find(User.class, username);
    }

    @Override
    public Boolean save(User user) {
        entityManager.persist(user);
        return true;
    }
}
