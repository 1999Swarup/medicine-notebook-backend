package com.example.medicine.model;


import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="medicine")
public class Medicine {

	@Column(name="medicine_Name")
	private String medicineName;
	
	@Column(name="disease_Name")
	private String diseaseName;
	
	@JsonFormat(pattern="HH:mm")
	@Column(name="medicine_time")
	private Time medicineTime;
	
	@Column(name="medicine_time_order")
	private String medicineOrder;
	
	public String getMedicineOrder() {
		return medicineOrder;
	}
	public void setMedicineOrder(String medicineOrder) {
		this.medicineOrder = medicineOrder;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	public Medicine()
	{
		
	}
	
	public Medicine(String medicineName, String diseaseName, Time medicineTime, String medicineOrder) {
		super();
		this.medicineName = medicineName;
		this.diseaseName = diseaseName;
		this.medicineTime = medicineTime;
		this.medicineOrder = medicineOrder;
	}
	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public Time getMedicineTime() {
		return medicineTime;
	}

	public void setMedicineTime(Time medicineTime) {
		this.medicineTime = medicineTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
}
