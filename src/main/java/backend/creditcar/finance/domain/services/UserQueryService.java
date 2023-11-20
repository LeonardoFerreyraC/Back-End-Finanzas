package backend.creditcar.finance.domain.services;

import backend.creditcar.finance.domain.model.aggregates.User;
import backend.creditcar.finance.domain.model.queries.GetUserByEmailQuery;
import backend.creditcar.finance.domain.model.queries.GetUserByIdQuery;

import java.util.Optional;

public interface UserQueryService {
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByEmailQuery query);
}
