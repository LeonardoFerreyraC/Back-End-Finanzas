package backend.creditcar.finance.interfaces.rest;

import backend.creditcar.finance.domain.model.queries.GetUserByEmailQuery;
import backend.creditcar.finance.domain.model.queries.GetUserByIdQuery;
import backend.creditcar.finance.domain.services.UserCommandService;
import backend.creditcar.finance.domain.services.UserQueryService;
import backend.creditcar.finance.interfaces.rest.resources.CreateUserResource;
import backend.creditcar.finance.interfaces.rest.resources.UserResource;
import backend.creditcar.finance.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import backend.creditcar.finance.interfaces.rest.transform.UserResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Users", description = "User Management Endpoints")
public class UsersController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public UsersController(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource resource){
        var createUserCommand = CreateUserCommandFromResourceAssembler.toCommandFromResource(resource);
        var userId = userCommandService.handle(createUserCommand);
        if(userId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var user = userQueryService.handle(getUserByIdQuery);
        if(user.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<UserResource> getUserByEmail(@RequestParam String email){
        var getUserByEmailQuery = new GetUserByEmailQuery(email);
        var user = userQueryService.handle(getUserByEmailQuery);
        if(user.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }
}
