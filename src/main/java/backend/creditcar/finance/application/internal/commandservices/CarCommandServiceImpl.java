package backend.creditcar.finance.application.internal.commandservices;

import backend.creditcar.finance.domain.model.aggregates.Car;
import backend.creditcar.finance.domain.model.commands.CreateCarCommand;
import backend.creditcar.finance.domain.services.CarCommandService;
import backend.creditcar.finance.infrastructure.persistence.jpa.repositories.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarCommandServiceImpl implements CarCommandService {
    private final CarRepository carRepository;

    public CarCommandServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Long handle(CreateCarCommand command) {
        var car = new Car(command.name(), command.year(), command.color(), command.price(), command.imageURL());
        carRepository.save(car);
        return car.getId();
    }
}
