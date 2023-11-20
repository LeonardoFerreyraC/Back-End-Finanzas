package backend.creditcar.finance.domain.services;

import backend.creditcar.finance.domain.model.aggregates.Loan;
import backend.creditcar.finance.domain.model.queries.GetLoanByIdQuery;
import backend.creditcar.finance.domain.model.queries.GetLoansByUserIdQuery;

import java.util.List;
import java.util.Optional;

public interface LoanQueryService {
    Optional<Loan> handle(GetLoanByIdQuery query);
    List<Loan> handle(GetLoansByUserIdQuery query);
}
