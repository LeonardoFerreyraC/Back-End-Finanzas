package backend.creditcar.finance.domain.services;

import backend.creditcar.finance.domain.model.commands.CreateCarCommand;

public interface CarCommandService {
    Long handle(CreateCarCommand command);
}
