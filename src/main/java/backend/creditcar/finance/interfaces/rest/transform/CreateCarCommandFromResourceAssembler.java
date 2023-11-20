package backend.creditcar.finance.interfaces.rest.transform;

import backend.creditcar.finance.domain.model.commands.CreateCarCommand;
import backend.creditcar.finance.interfaces.rest.resources.CreateCarResource;

public class CreateCarCommandFromResourceAssembler {
    public static CreateCarCommand toCommandFromResource(CreateCarResource resource){
        return new CreateCarCommand(resource.name(), resource.year(), resource.color(), resource.price(),
                resource.imageURL());
    }
}
