package com.SpringBoot_1.SpringBoot_1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.SpringBoot_1.SpringBoot_1.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{
	
	@Query("SELECT c FROM Car c WHERE c.color = ?1")
	List<Car> findByColor(String color);
	
	@Query("SELECT c FROM Car c WHERE c.name = :name")
	List<Car> findByName(String name) ;

	@Query("SELECT c FROM Car c WHERE c.id = ?1")
	Car findById(int id) ;
}
