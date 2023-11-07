package fcul.mei.repositories;

import fcul.mei.mappers.IMapper;
import fcul.mei.mappers.UserMapper;
import jakarta.persistence.EntityManager;
import model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IMapper<User, String> {

    private final EntityManager entityManager;
    private final UserMapper userMapper;

    public UserRepository(EntityManager entityManager, UserMapper userMapper) {
        this.entityManager = entityManager;
        this.userMapper =  userMapper;
    }

    @Override
    public User get(String username) {
        return userMapper.get(username);
    }

    public Boolean save(User user){
        return userMapper.save(user);
    }


}
