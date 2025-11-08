package pl.wsb.fitnesstracker.healthmetrics;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;

@Entity
@Table(name="Health_Metrics")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class HealthMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "weight")
    private double weight;

    @Column(name = "height")
    private double height;

    @Column(name = "heart_rate")
    private int heartRate;

    public HealthMetrics(User user, LocalDate date, double weight, double height, int heartRate) {
        this.date = date;
        this.weight = weight;
        this.height = height;
        this.user = user;
        this.heartRate = heartRate;
    }

}
