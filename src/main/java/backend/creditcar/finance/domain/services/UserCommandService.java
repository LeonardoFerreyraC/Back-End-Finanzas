package backend.creditcar.finance.domain.services;

import backend.creditcar.finance.domain.model.commands.CreateUserCommand;

public interface UserCommandService {
    Long handle(CreateUserCommand command);
}
