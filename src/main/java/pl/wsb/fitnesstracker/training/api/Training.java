package pl.wsb.fitnesstracker.training.api;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.wsb.fitnesstracker.training.internal.ActivityType;
import pl.wsb.fitnesstracker.user.api.User;

import java.util.Date;

@Entity
@Table(name="trainings")
@Getter
@NoArgsConstructor
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Column(nullable = false, name = "startTime")
    private Date startTime;

    @Column(nullable = false, name = "endTime")
    private Date endTime;

    @Column(nullable = false, name = "activityType")
    @Enumerated(EnumType.STRING)
    private ActivityType activityType;

    @Column(nullable = false, name = "distance")
    private double distance;

    @Column(nullable = false, name = "averageSpeed")
    private double averageSpeed;

    public Training(
            final User user,
            final Date startTime,
            final Date endTime,
            final ActivityType activityType,
            final double distance,
            final double averageSpeed) {
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activityType = activityType;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
    }

}