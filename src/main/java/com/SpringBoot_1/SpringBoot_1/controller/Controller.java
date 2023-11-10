package com.SpringBoot_1.SpringBoot_1.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot_1.SpringBoot_1.entity.Car;
import com.SpringBoot_1.SpringBoot_1.responsestructure.ResponseStructure;
import com.SpringBoot_1.SpringBoot_1.service.CarService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class Controller {
	
	@Autowired
	private CarService service ;
	
	@ApiResponses(value = {@ApiResponse(description = "To save the Data...", responseCode = "200"),
			               @ApiResponse(description = "Unable to save the data..", responseCode = "400")})
	@Operation(description = "To save the Data to the Data Base", summary = "Data is Strored")
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Car>> saveCar(@RequestBody Car car) {
		
		return service.saveCar(car) ;
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<ResponseStructure<Car>> findCar (@PathVariable int id) {
		return service.findCar(id) ;
	}
	
	@ApiResponses(value = {@ApiResponse(description = "This EndPoint will help to save the Update",responseCode = "200"),
	                       @ApiResponse(description = "Unable to save the update..!", responseCode = "404" )})
	@Operation(description = "This will help us save the alter the data", summary = "Updating the Data")
	@PutMapping(value = "/update")
	public Car updateCar( @RequestBody Car car) {
		return service.updateCar(car) ;
	}
	
	@DeleteMapping("/delete/{id}")
		public ResponseEntity<ResponseStructure<Car>> deleteCar(@PathVariable int id) {
			return service.deleteCar(id) ;
	}
	
	@GetMapping("/color/{color}")
	public List<Car> findBycarColor(@PathVariable String color){
		return service.findCarByColor(color) ;
	}
	
	@GetMapping("/car/name/{name}")
	public List<Car> findBycarName(@PathVariable String name){
		return service.findCarByName(name) ;
	}
}
