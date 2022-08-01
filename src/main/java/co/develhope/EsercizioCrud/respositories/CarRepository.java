package co.develhope.EsercizioCrud.respositories;


import co.develhope.EsercizioCrud.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}
