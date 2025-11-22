package pl.wsb.fitnesstracker.userEvent;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import pl.wsb.fitnesstracker.event.Event;
import pl.wsb.fitnesstracker.user.api.User;

@Entity
@Table
@NoArgsConstructor
public class UserEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="event_id")
    @Nullable
    private Event eventid;

    @Column
    @Nullable
    private String status;

    public UserEvent(User userId,
                     Event eventid,
                     String status) {
        this.userId = userId;
        this.eventid = eventid;
        this.status = status;
    }
}
