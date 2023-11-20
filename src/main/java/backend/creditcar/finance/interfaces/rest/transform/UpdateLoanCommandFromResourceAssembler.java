package backend.creditcar.finance.interfaces.rest.transform;

import backend.creditcar.finance.domain.model.commands.UpdateLoanCommand;
import backend.creditcar.finance.interfaces.rest.resources.UpdateLoanResource;

public class UpdateLoanCommandFromResourceAssembler {
    public static UpdateLoanCommand toCommandFromResource(Long loanId, UpdateLoanResource resource){
        return new UpdateLoanCommand(loanId, resource.cokRate(), resource.TEA(), resource.TEP(),
                resource.gracePeriod(), resource.graceMonths(), resource.price(), resource.balanceFinance(),
                resource.loanAmount(), resource.creditLifeInsuranceRate(), resource.feesPerYear(),
                resource.totalFees(), resource.vehicleInsuranceRate(), resource.commission(), resource.portage(),
                resource.administrativeExpenses(), resource.finalFee(), resource.userId(), resource.VAN(),
                resource.TIR(), resource.date(), resource.state());
    }
}
