package fcul.mei.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.Set;

public class User {

    @Id
    @Column(name = "username")
     String username;

    @Column(name = "password")
     String password;

    @ManyToMany(mappedBy="users")
     Set<Group> groups;

    @OneToMany(mappedBy = "users")
    Set<Message> messages;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }


}
