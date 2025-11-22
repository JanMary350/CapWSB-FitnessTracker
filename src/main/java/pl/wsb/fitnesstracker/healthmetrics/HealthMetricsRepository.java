package pl.wsb.fitnesstracker.healthmetrics;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class HealthMetricsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<HealthMetrics> findAll() {
        return entityManager.createQuery("SELECT h FROM HealthMetrics h", HealthMetrics.class)
                .getResultList();
    }

    public Optional<HealthMetrics> findById(Long id) {
        return Optional.ofNullable(entityManager.find(HealthMetrics.class, id));
    }

    public List<HealthMetrics> findByUser(User user) {
        TypedQuery<HealthMetrics> q = entityManager.createQuery(
                "SELECT h FROM HealthMetrics h WHERE h.user = :user", HealthMetrics.class);
        q.setParameter("user", user);
        return q.getResultList();
    }

    public Optional<HealthMetrics> findByUserAndDate(User user, LocalDate date) {
        TypedQuery<HealthMetrics> q = entityManager.createQuery(
                "SELECT h FROM HealthMetrics h WHERE h.user = :user AND h.date = :date", HealthMetrics.class);
        q.setParameter("user", user);
        q.setParameter("date", date);
        return q.getResultStream().findFirst();
    }

    public List<HealthMetrics> findByDateBetween(LocalDate startDate, LocalDate endDate) {
        TypedQuery<HealthMetrics> q = entityManager.createQuery(
                "SELECT h FROM HealthMetrics h WHERE h.date BETWEEN :start AND :end", HealthMetrics.class);
        q.setParameter("start", startDate);
        q.setParameter("end", endDate);
        return q.getResultList();
    }

    @Transactional
    public HealthMetrics save(HealthMetrics metrics) {
        return entityManager.merge(metrics);
    }

}