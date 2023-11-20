package backend.creditcar.finance.application.internal.commandservices;

import backend.creditcar.finance.domain.model.aggregates.Loan;
import backend.creditcar.finance.domain.model.commands.CreateLoanCommand;
import backend.creditcar.finance.domain.model.commands.UpdateLoanCommand;
import backend.creditcar.finance.domain.services.LoanCommandService;
import backend.creditcar.finance.infrastructure.persistence.jpa.repositories.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanCommandServiceImpl implements LoanCommandService {
    private final LoanRepository loanRepository;

    public LoanCommandServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Long handle(CreateLoanCommand command) {
        var loan = new Loan(command.cokRate(), command.TEA(), command.TEP(), command.gracePeriod(),
                command.graceMonths(), command.price(), command.balanceFinance(), command.loanAmount(),
                command.creditLifeInsuranceRate(), command.feesPerYear(), command.totalFees(),
                command.vehicleInsuranceRate(), command.commission(), command.portage(),
                command.administrativeExpenses(), command.finalFee(), command.userId(), command.VAN(),
                command.TIR(), command.date(), command.state());
        loanRepository.save(loan);
        return loan.getId();
    }

    @Override
    public Optional<Loan> handle(UpdateLoanCommand command) {
        var loanToUpdate = loanRepository.findById(command.id()).get();
        var updatedLoan = loanRepository.save(loanToUpdate.updateInformation(command.cokRate(), command.TEA(),
                command.TEP(), command.gracePeriod(), command.graceMonths(), command.price(),
                command.balanceFinance(), command.loanAmount(), command.creditLifeInsuranceRate(),
                command.feesPerYear(), command.totalFees(), command.vehicleInsuranceRate(),
                command.commission(), command.portage(), command.administrativeExpenses(),
                command.finalFee(), command.userId(), command.VAN(), command.TIR(), command.date(), command.state()));
        return Optional.of(updatedLoan);
    }
}
