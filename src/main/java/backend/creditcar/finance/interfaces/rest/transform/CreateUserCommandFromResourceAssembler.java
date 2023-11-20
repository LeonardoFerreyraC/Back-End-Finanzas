package backend.creditcar.finance.interfaces.rest.transform;

import backend.creditcar.finance.domain.model.commands.CreateUserCommand;
import backend.creditcar.finance.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand toCommandFromResource(CreateUserResource resource){
        return new CreateUserCommand(resource.name(), resource.lastName(), resource.email(), resource.password());
    }
}
