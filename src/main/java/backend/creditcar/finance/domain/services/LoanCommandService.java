package backend.creditcar.finance.domain.services;

import backend.creditcar.finance.domain.model.aggregates.Loan;
import backend.creditcar.finance.domain.model.commands.CreateLoanCommand;
import backend.creditcar.finance.domain.model.commands.UpdateLoanCommand;

import java.util.Optional;

public interface LoanCommandService {
    Long handle(CreateLoanCommand command);

    Optional<Loan> handle(UpdateLoanCommand command);
}
