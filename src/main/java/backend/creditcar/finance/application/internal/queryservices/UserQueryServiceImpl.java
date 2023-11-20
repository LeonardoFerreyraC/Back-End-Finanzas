package backend.creditcar.finance.application.internal.queryservices;

import backend.creditcar.finance.domain.model.aggregates.User;
import backend.creditcar.finance.domain.model.queries.GetUserByEmailQuery;
import backend.creditcar.finance.domain.model.queries.GetUserByIdQuery;
import backend.creditcar.finance.domain.services.UserQueryService;
import backend.creditcar.finance.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return userRepository.findById(query.id());
    }

    @Override
    public Optional<User> handle(GetUserByEmailQuery query) {
        return userRepository.findByEmail(query.email());
    }
}
