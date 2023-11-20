package backend.creditcar.finance.interfaces.rest;

import backend.creditcar.finance.domain.model.queries.GetLoansByUserIdQuery;
import backend.creditcar.finance.domain.services.LoanQueryService;
import backend.creditcar.finance.interfaces.rest.resources.LoanResource;
import backend.creditcar.finance.interfaces.rest.transform.LoanResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/users/{userId}/loans", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Users")
public class UserLoansController {
    private final LoanQueryService loanQueryService;

    public UserLoansController(LoanQueryService loanQueryService) {
        this.loanQueryService = loanQueryService;
    }

    @GetMapping
    public ResponseEntity<List<LoanResource>> getLoansByUserId(@PathVariable Long userId){
        var getLoansByUserIdQuery = new GetLoansByUserIdQuery(userId);
        var loans = loanQueryService.handle(getLoansByUserIdQuery);
        var loanResources = loans.stream().map(LoanResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(loanResources);
    }
}
