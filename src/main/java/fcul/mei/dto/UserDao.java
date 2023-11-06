package fcul.mei.dto;

import fcul.mei.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class UserDao implements JpaRepository<User, String> {

}
