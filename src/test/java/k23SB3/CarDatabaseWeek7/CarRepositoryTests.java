package k23SB3.CarDatabaseWeek7;
	
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import k23SB3.CarDatabaseWeek7.domain.Car;
import k23SB3.CarDatabaseWeek7.domain.CarRepository;

@DataJpaTest
public class CarRepositoryTests {
	@Autowired
	CarRepository carRepository;
	
	@Test
	public void findByBrandNameShouldReturnBrand() {
		List<Car> cars = carRepository.findByBrand("Ford");
		assertThat(cars.get(0).getBrand().equalsIgnoreCase("ford"));
		
	}
	
	
	@Test
	public void findCarOwner() {
		List<Car> cars = carRepository.findByOwnerLastName("Watson");
		assertThat(cars).hasSize(1);		
	}
	
	@Test
	public void saveCar() {
		Car car = new Car();
		carRepository.save(car);
		assertNotEquals(car.getId(), null);

	}
	
	@Test
	public void updateCar() {
		Optional<Car> car = carRepository.findById((long) 1);
		assertNotEquals(car.get().getId(), null);
		car.get().setBrand("testi");
		List<Car> cars = carRepository.findByBrand("testi");
		assertThat(cars).hasSize(1);		
	}
	
}
