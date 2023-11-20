package backend.creditcar.finance.application.internal.queryservices;

import backend.creditcar.finance.domain.model.aggregates.Car;
import backend.creditcar.finance.domain.model.queries.GetAllCarsQuery;
import backend.creditcar.finance.domain.model.queries.GetCarByIdQuery;
import backend.creditcar.finance.domain.services.CarQueryService;
import backend.creditcar.finance.infrastructure.persistence.jpa.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarQueryServiceImpl implements CarQueryService {
    private final CarRepository carRepository;

    public CarQueryServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Optional<Car> handle(GetCarByIdQuery query) {
        return carRepository.findById(query.id());
    }

    @Override
    public List<Car> handle(GetAllCarsQuery query) {
        return carRepository.findAll();
    }
}
