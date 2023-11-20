package backend.creditcar.finance.infrastructure.persistence.jpa.repositories;

import backend.creditcar.finance.domain.model.aggregates.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
