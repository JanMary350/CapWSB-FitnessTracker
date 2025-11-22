package pl.wsb.fitnesstracker.workoutsession;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.wsb.fitnesstracker.training.api.Training;

// TODO: Define the Event entity with appropriate fields and annotations
@Entity
@Table(name="workout_session")
@NoArgsConstructor()
public class WorkoutSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(optional = false)
    @JoinColumn(name="training_id")
    private Training trainingId;

    @Column(nullable = false, name = "timestamp")
    private String timestamp;

    @Column(nullable = false, name = "startLatitude")
    private double startLatitude;

    @Column(nullable = false, name = "startLongitude")
    private double startLongitude;

    @Column(nullable = false, name = "endLatitude")
    private double endLatitude;

    @Column(nullable = false, name = "endLongitude")
    private double endLongitude;

    @Column(nullable = false, name = "altitude")
    private double altitude;

    public WorkoutSession(Training trainingId,
                          String timestamp,
                          double startLatitude,
                          double startLongitude,
                          double endLatitude,
                          double endLongitude,
                          double altitude) {
        this.trainingId = trainingId;
        this.timestamp = timestamp;
        this.startLatitude = startLatitude;
        this.startLongitude = startLongitude;
        this.endLatitude = endLatitude;
        this.endLongitude = endLongitude;
        this.altitude = altitude;
    }


}
