package backend.creditcar.finance.application.internal.commandservices;

import backend.creditcar.finance.domain.model.aggregates.User;
import backend.creditcar.finance.domain.model.commands.CreateUserCommand;
import backend.creditcar.finance.domain.services.UserCommandService;
import backend.creditcar.finance.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long handle(CreateUserCommand command) {
        var user = new User(command.name(), command.lastName(), command.email(), command.password());
        userRepository.save(user);
        return user.getId();
    }
}
