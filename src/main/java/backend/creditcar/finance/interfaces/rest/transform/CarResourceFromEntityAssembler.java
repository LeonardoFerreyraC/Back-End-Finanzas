package backend.creditcar.finance.interfaces.rest.transform;

import backend.creditcar.finance.domain.model.aggregates.Car;
import backend.creditcar.finance.interfaces.rest.resources.CarResource;

public class CarResourceFromEntityAssembler {

    public static CarResource toResourceFromEntity(Car car){
        return new CarResource(car.getId(), car.getName(), car.getYear(), car.getColor(), car.getPrice(),
                car.getImageURL());
    }
}
