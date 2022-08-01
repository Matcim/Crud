package co.develhope.EsercizioCrud.controller;


import co.develhope.EsercizioCrud.entities.Car;
import co.develhope.EsercizioCrud.respositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class Controller {

    @Autowired
    private CarRepository carRepository;

    @PostMapping
    public Car postPar(@RequestBody Car car) {

        Car car1 = carRepository.saveAndFlush(car);
        return car1;
    }

    @GetMapping
    public List<Car> getCars() {

        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable Long id) {

        Optional<Car> sigleCar = carRepository.findById(id);
        try {
            if (carRepository.existsById(id)) {
                throw new Exception("la macchina selezionata esiste");
            } else {
                System.out.println("la macchina selezionata non esiste");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sigleCar;
    }

    @PutMapping("/{type}")
    public Car carUpdate(@RequestBody Car car) {

        Car carUpdate = carRepository.saveAndFlush(car);

        try {
            if (carUpdate.equals(car)) {
                System.out.println("la macchina è aggiornata");
            } else {
                System.out.println("impossibile aggiornare la macchina");
                throw new Exception("impossibile aggiornare la macchina");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carUpdate;
    }

    @DeleteMapping("/{id}")
    public void deleteSingleCar(@PathVariable long id) {

        try {
            if (carRepository.existsById(id)){
                System.out.println("id cancellato");
            }else{
                System.out.println("id da cancellare non esiste");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @DeleteMapping
    public void deleteAllCar(@RequestParam List<Long> car) {

           carRepository.deleteAllById(car);
    }
}
