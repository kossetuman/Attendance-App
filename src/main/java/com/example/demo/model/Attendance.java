package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String workStart;
	
	@NotBlank
	private String workFinish;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date workDay;
	
	@ManyToOne
	private Department department;
	
	private String actualWorkingHours;
	
//	private String siteUser_id;
	
	
	
	
}
