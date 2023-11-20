package backend.creditcar.finance.interfaces.rest.transform;

import backend.creditcar.finance.domain.model.commands.CreateLoanCommand;
import backend.creditcar.finance.interfaces.rest.resources.CreateLoanResource;

public class CreateLoanCommandFromResourceAssembler {
    public static CreateLoanCommand toCommandFromResource(CreateLoanResource resource){
        return new CreateLoanCommand(resource.cokRate(), resource.TEA(), resource.TEP(), resource.gracePeriod(),
                resource.graceMonths(), resource.price(), resource.balanceFinance(), resource.loanAmount(),
                resource.creditLifeInsuranceRate(), resource.feesPerYear(), resource.totalFees(),
                resource.vehicleInsuranceRate(), resource.commission(), resource.portage(),
                resource.administrativeExpenses(), resource.finalFee(), resource.userId(),
                resource.VAN(), resource.TIR(), resource.date(), resource.state());
    }
}
