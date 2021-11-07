package com.example.medicine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.medicine.model.Medicine;

@Repository
public interface MedicineRepo extends JpaRepository<Medicine,Long> {

}
