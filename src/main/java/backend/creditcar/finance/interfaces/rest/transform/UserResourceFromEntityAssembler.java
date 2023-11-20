package backend.creditcar.finance.interfaces.rest.transform;

import backend.creditcar.finance.domain.model.aggregates.User;
import backend.creditcar.finance.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user){
        return new UserResource(user.getId(), user.getName(), user.getLastName(), user.getEmail(),
                user.getPassword());
    }
}
