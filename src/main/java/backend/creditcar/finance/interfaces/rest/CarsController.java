package backend.creditcar.finance.interfaces.rest;

import backend.creditcar.finance.domain.model.queries.GetAllCarsQuery;
import backend.creditcar.finance.domain.model.queries.GetCarByIdQuery;
import backend.creditcar.finance.domain.services.CarCommandService;
import backend.creditcar.finance.domain.services.CarQueryService;
import backend.creditcar.finance.interfaces.rest.resources.CarResource;
import backend.creditcar.finance.interfaces.rest.resources.CreateCarResource;
import backend.creditcar.finance.interfaces.rest.transform.CarResourceFromEntityAssembler;
import backend.creditcar.finance.interfaces.rest.transform.CreateCarCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/cars", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Cars", description = "Car Management Endpoints")
public class CarsController {
    private final CarCommandService carCommandService;
    private final CarQueryService carQueryService;

    public CarsController(CarCommandService carCommandService, CarQueryService carQueryService) {
        this.carCommandService = carCommandService;
        this.carQueryService = carQueryService;
    }

    @PostMapping
    public ResponseEntity<CarResource> createCar(CreateCarResource resource){
        var createCarCommand = CreateCarCommandFromResourceAssembler.toCommandFromResource(resource);
        var carId = carCommandService.handle(createCarCommand);
        if(carId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getCarByIdQuery = new GetCarByIdQuery(carId);
        var car = carQueryService.handle(getCarByIdQuery);
        if(car.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var carResource = CarResourceFromEntityAssembler.toResourceFromEntity(car.get());
        return new ResponseEntity<>(carResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CarResource>> getAllCars(){
        var getAllCarsQuery = new GetAllCarsQuery();
        var cars = carQueryService.handle(getAllCarsQuery);
        if(cars.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var carResources = cars.stream().map(CarResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(carResources);
    }
}
