package fcul.mei.model;

import jakarta.persistence.*;

@Entity(name = "Message")
@Table(name = "message")
public class Message {

    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "group")
    private Group group;

}
