package fcul.mei.model;

import jakarta.persistence.*;

import java.util.Set;


@Entity(name = "Group")
@Table(name = "group")

public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int gid;

    @Column(name = "group_name")
    private String groupName;

    @ManyToMany(mappedBy = "")
    @JoinTable(name="group_user",
            joinColumns=@JoinColumn(name="username"),
            inverseJoinColumns=@JoinColumn(name="gid"))
    private Set<User> users;

    @OneToMany(mappedBy = "group")
    private Set<Message> messages;

}
