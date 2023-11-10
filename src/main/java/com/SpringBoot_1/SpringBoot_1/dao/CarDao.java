package com.SpringBoot_1.SpringBoot_1.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringBoot_1.SpringBoot_1.entity.Car;
import com.SpringBoot_1.SpringBoot_1.repository.CarRepository;

@Repository
public class CarDao {
	
	@Autowired
	private CarRepository repo ;
	
	public Car saveCar(Car car) {
		return repo.save(car) ;
	}
	
	public Car findCar(int id) {
		 return repo.findById(id) ;
	}
	
	public Car updateCar(Car car) {
		return repo.save(car);
	}
	
	public boolean deleteCar(int id) {
		
		if (findCar(id) != null) {
			Car car = findCar(id) ;
			repo.delete(car);
			return true ;
		}
		return false ;
	}
	
	public List<Car> findByCarColor(String color){
		
		if (!color.isEmpty()) {
			return repo.findByColor(color) ;
		}
		return null;
	}
	
public List<Car> findByCarName(String name){
		
		if (!name.isEmpty()) {
			return repo.findByName(name) ;
		}
		return null;
	}
}
