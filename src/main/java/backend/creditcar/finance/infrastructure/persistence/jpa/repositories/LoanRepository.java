package backend.creditcar.finance.infrastructure.persistence.jpa.repositories;

import backend.creditcar.finance.domain.model.aggregates.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByUserId(Long userId);
}
