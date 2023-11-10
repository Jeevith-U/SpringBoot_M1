package com.SpringBoot_1.SpringBoot_1.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Component
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "idgen")
	@SequenceGenerator(name = "idgen", initialValue = 10, allocationSize = 10,sequenceName = "seqId")
	private int id ;
	private String name ;
	private String color ;
	private double price ;

}
