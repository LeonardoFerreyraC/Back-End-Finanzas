package backend.creditcar.finance.domain.services;

import backend.creditcar.finance.domain.model.aggregates.Car;
import backend.creditcar.finance.domain.model.queries.GetAllCarsQuery;
import backend.creditcar.finance.domain.model.queries.GetCarByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CarQueryService {
    Optional<Car> handle (GetCarByIdQuery query);
    List<Car> handle(GetAllCarsQuery query);
}
