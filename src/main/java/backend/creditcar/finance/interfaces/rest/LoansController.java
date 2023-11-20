package backend.creditcar.finance.interfaces.rest;

import backend.creditcar.finance.domain.model.queries.GetLoanByIdQuery;
import backend.creditcar.finance.domain.services.LoanCommandService;
import backend.creditcar.finance.domain.services.LoanQueryService;
import backend.creditcar.finance.interfaces.rest.resources.CreateLoanResource;
import backend.creditcar.finance.interfaces.rest.resources.LoanResource;
import backend.creditcar.finance.interfaces.rest.resources.UpdateLoanResource;
import backend.creditcar.finance.interfaces.rest.transform.CreateLoanCommandFromResourceAssembler;
import backend.creditcar.finance.interfaces.rest.transform.LoanResourceFromEntityAssembler;
import backend.creditcar.finance.interfaces.rest.transform.UpdateLoanCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/loans", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Loans", description = "Loan Management Endpoints")
public class LoansController {
    private final LoanQueryService loanQueryService;
    private final LoanCommandService loanCommandService;

    public LoansController(LoanQueryService loanQueryService, LoanCommandService loanCommandService) {
        this.loanQueryService = loanQueryService;
        this.loanCommandService = loanCommandService;
    }

    @PostMapping
    public ResponseEntity<LoanResource> createLoan(@RequestBody CreateLoanResource resource){
        var createLoanCommand = CreateLoanCommandFromResourceAssembler.toCommandFromResource(resource);
        var loanId = loanCommandService.handle(createLoanCommand);
        if(loanId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getLoanByIdQuery = new GetLoanByIdQuery(loanId);
        var loan = loanQueryService.handle(getLoanByIdQuery);
        if(loan.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var loanResource = LoanResourceFromEntityAssembler.toResourceFromEntity(loan.get());
        return new ResponseEntity<>(loanResource, HttpStatus.CREATED);
    }

    @PutMapping("/{loanId}")
    public ResponseEntity<LoanResource> updateLoan(@PathVariable Long loanId,
                                                   @RequestBody UpdateLoanResource resource){
        var updateLoanCommand = UpdateLoanCommandFromResourceAssembler.toCommandFromResource(loanId, resource);
        var updatedLoan = loanCommandService.handle(updateLoanCommand);
        if(updatedLoan.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var loanResource = LoanResourceFromEntityAssembler.toResourceFromEntity(updatedLoan.get());
        return ResponseEntity.ok(loanResource);
    }
}
