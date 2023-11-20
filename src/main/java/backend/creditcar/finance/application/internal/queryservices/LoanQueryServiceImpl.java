package backend.creditcar.finance.application.internal.queryservices;

import backend.creditcar.finance.domain.model.aggregates.Loan;
import backend.creditcar.finance.domain.model.queries.GetLoanByIdQuery;
import backend.creditcar.finance.domain.model.queries.GetLoansByUserIdQuery;
import backend.creditcar.finance.domain.services.LoanQueryService;
import backend.creditcar.finance.infrastructure.persistence.jpa.repositories.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanQueryServiceImpl implements LoanQueryService {
    private final LoanRepository loanRepository;

    public LoanQueryServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Optional<Loan> handle(GetLoanByIdQuery query) {
        return loanRepository.findById(query.id());
    }

    @Override
    public List<Loan> handle(GetLoansByUserIdQuery query) {
        return loanRepository.findByUserId(query.userId());
    }
}
