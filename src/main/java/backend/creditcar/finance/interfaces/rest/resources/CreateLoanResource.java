package backend.creditcar.finance.interfaces.rest.resources;

public record CreateLoanResource(Float cokRate, Float TEA, Float TEP, String gracePeriod, String graceMonths,
                                 Float price, Float balanceFinance, Float loanAmount, Float creditLifeInsuranceRate,
                                 Integer feesPerYear, Integer totalFees, Float vehicleInsuranceRate, Float commission,
                                 Float portage, Float administrativeExpenses, Float finalFee, Long userId, Float VAN,
                                 Float TIR, String date, String state) {
}
