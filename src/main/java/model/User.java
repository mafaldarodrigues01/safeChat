package model;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "User")
@Table(name = "user")
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
