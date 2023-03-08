package co.develhope.crudexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Car")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    public CarController(){

    }

    @PostMapping("")
    public Car createNewCar(@RequestBody Car car) {
        return carRepository.saveAndFlush(car);
    }

    @GetMapping("/getAllCars")
    public List<Car> findAllCarById() {
        return carRepository.findAll();
    }

    @GetMapping("/getCar/{carId}")
    public Optional<Car> getCar(@PathVariable int carId){
        return carRepository.findById(carId);
    }

    @DeleteMapping("/deleteCar/{carId}")
    public void deleteCarById(@PathVariable int carId) {
        carRepository.deleteById(carId);
    }

}
