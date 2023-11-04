package fcul.mei.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.Set;

public class User {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany(mappedBy="users")
    private Set<Group> groups;

    @OneToMany(mappedBy = "users")
    private Set<Message> messages;

    public User(String username, String password, Set<Group> groups){
        this.username = username;
        this.password = password;
    }

}
