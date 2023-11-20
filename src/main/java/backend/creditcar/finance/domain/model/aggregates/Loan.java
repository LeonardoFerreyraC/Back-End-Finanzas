package backend.creditcar.finance.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float cokRate;

    private Float TEA;

    private Float TEP;

    private String gracePeriod;

    private String graceMonths;

    private Float price;

    private Float balanceFinance;

    private Float loanAmount;

    private Float creditLifeInsuranceRate;

    private Integer feesPerYear;

    private Integer totalFees;

    private Float vehicleInsuranceRate;

    private Float commission;

    private Float portage;

    private Float administrativeExpenses;

    private Float finalFee;

    private Long userId;

    private Float VAN;

    private Float TIR;

    private String date;

    private String state;

    public Loan(){}

    public Loan(Float cokRate, Float TEA, Float TEP, String gracePeriod, String graceMonths,
                Float price, Float balanceFinance, Float loanAmount, Float creditLifeInsuranceRate,
                Integer feesPerYear, Integer totalFees, Float vehicleInsuranceRate, Float commission,
                Float portage, Float administrativeExpenses, Float finalFee, Long userId, Float VAN,
                Float TIR, String date, String state) {
        this.cokRate = cokRate;
        this.TEA = TEA;
        this.TEP = TEP;
        this.gracePeriod = gracePeriod;
        this.graceMonths = graceMonths;
        this.price = price;
        this.balanceFinance = balanceFinance;
        this.loanAmount = loanAmount;
        this.creditLifeInsuranceRate = creditLifeInsuranceRate;
        this.feesPerYear = feesPerYear;
        this.totalFees = totalFees;
        this.vehicleInsuranceRate = vehicleInsuranceRate;
        this.commission = commission;
        this.portage = portage;
        this.administrativeExpenses = administrativeExpenses;
        this.finalFee = finalFee;
        this.userId = userId;
        this.VAN = VAN;
        this.TIR = TIR;
        this.date = date;
        this.state = state;
    }

    public Loan updateInformation(Float cokRate, Float TEA, Float TEP, String gracePeriod, String graceMonths,
                                  Float price, Float balanceFinance, Float loanAmount, Float creditLifeInsuranceRate,
                                  Integer feesPerYear, Integer totalFees, Float vehicleInsuranceRate, Float commission,
                                  Float portage, Float administrativeExpenses, Float finalFee, Long userId, Float VAN,
                                  Float TIR, String date, String state){
        this.cokRate = cokRate;
        this.TEA = TEA;
        this.TEP = TEP;
        this.gracePeriod = gracePeriod;
        this.graceMonths = graceMonths;
        this.price = price;
        this.balanceFinance = balanceFinance;
        this.loanAmount = loanAmount;
        this.creditLifeInsuranceRate = creditLifeInsuranceRate;
        this.feesPerYear = feesPerYear;
        this.totalFees = totalFees;
        this.vehicleInsuranceRate = vehicleInsuranceRate;
        this.commission = commission;
        this.portage = portage;
        this.administrativeExpenses = administrativeExpenses;
        this.finalFee = finalFee;
        this.userId = userId;
        this.VAN = VAN;
        this.TIR = TIR;
        this.date = date;
        this.state = state;
        return this;
    }
}
