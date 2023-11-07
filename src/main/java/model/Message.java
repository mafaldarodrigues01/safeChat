package model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity(name = "Message")
@Table(name = "message")
public class Message {

    @Column(name = "message")
    @NonNull
    private String message;

    @ManyToOne
    @JoinColumn(name = "user")
    @NonNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "group")
    @NonNull
    private Group group;

    public Message(String message, User user, Group group){
        this.message = message;
        this.user = user;
        this.group = group;
    }

}
