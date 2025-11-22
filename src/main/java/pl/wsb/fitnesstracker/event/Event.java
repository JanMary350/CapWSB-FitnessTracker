package pl.wsb.fitnesstracker.event;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.wsb.fitnesstracker.user.api.User;

// TODO: Define the Event entity with appropriate fields and annotations
@Table
@Entity
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="startTime")
    private String startTime;

    @Column(name="endTime")
    private String endTime;

    @Column(name="country")
    private String country;

    @Column(name="city")
    private String city;

    public Event(String name,
                 String description,
                 String startTime,
                 String endTime,
                 String country,
                 String city) {
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.country = country;
        this.city = city;
    }

}
