package backend.creditcar.finance.interfaces.rest.transform;

import backend.creditcar.finance.domain.model.aggregates.Loan;
import backend.creditcar.finance.interfaces.rest.resources.LoanResource;

public class LoanResourceFromEntityAssembler {

    public static LoanResource toResourceFromEntity(Loan loan){
        return new LoanResource(loan.getId(), loan.getCokRate(), loan.getTEA(), loan.getTEP(), loan.getGracePeriod(),
                loan.getGraceMonths(), loan.getPrice(), loan.getBalanceFinance(), loan.getLoanAmount(),
                loan.getCreditLifeInsuranceRate(), loan.getFeesPerYear(), loan.getTotalFees(),
                loan.getVehicleInsuranceRate(), loan.getCommission(), loan.getPortage(),
                loan.getAdministrativeExpenses(), loan.getFinalFee(), loan.getUserId(), loan.getVAN(),
                loan.getTIR(), loan.getDate(), loan.getState());
    }
}
