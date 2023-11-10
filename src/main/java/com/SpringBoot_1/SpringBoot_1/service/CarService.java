package com.SpringBoot_1.SpringBoot_1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpringBoot_1.SpringBoot_1.dao.CarDao;
import com.SpringBoot_1.SpringBoot_1.entity.Car;
import com.SpringBoot_1.SpringBoot_1.exception.CarNotFoundException;
import com.SpringBoot_1.SpringBoot_1.exception.NullCarException;
import com.SpringBoot_1.SpringBoot_1.responsestructure.ResponseStructure;

@Service
public class CarService {

	@Autowired
	private CarDao dao;

	public ResponseEntity<ResponseStructure<Car>> saveCar(Car car) {

		if (car != null) {
			System.out.println("Entering With Null Values");
			ResponseStructure response = new ResponseStructure();
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage("Car Object is Created Successfully...!");
			response.setData(car);
			dao.saveCar(car);
			return new ResponseEntity<ResponseStructure<Car>>(response, HttpStatus.CREATED);
		}
		throw new NullCarException();
	}

	public ResponseEntity<ResponseStructure<Car>> findCar(int id) {

		Car car = dao.findCar(id);

		if (car != null) {

			ResponseStructure response = new ResponseStructure();
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMessage("Your Excpected car is present.");
			response.setData(car);
			return new ResponseEntity<ResponseStructure<Car>>(response, HttpStatus.FOUND);

		}
		throw new CarNotFoundException();
	}

	public Car updateCar(Car car) {

		if (car != null) {
			return dao.updateCar(car);
		}
		return null;
	}

public ResponseEntity<ResponseStructure<Car>> deleteCar(int id) {
		
		Car c = dao.findCar(id) ;
		
		if (c != null) {
			
			ResponseStructure response = new ResponseStructure() ;
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("deleted successfully");
			response.setData("Deleted");
			dao.deleteCar(id) ;
			return new ResponseEntity<ResponseStructure<Car>>(response, HttpStatus.OK) ;
		}
		throw new CarNotFoundException () ;
}

	public List<Car> findCarByColor(String color) {

		return dao.findByCarColor(color);
	}

	public List<Car> findCarByName(String name) {

		return dao.findByCarName(name);
	}
}
