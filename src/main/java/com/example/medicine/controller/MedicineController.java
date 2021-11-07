package com.example.medicine.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.medicine.exception.ResourceNotFoundException;
import com.example.medicine.model.Medicine;
import com.example.medicine.repository.MedicineRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2/")
public class MedicineController {
	@Autowired
	private MedicineRepo medRepo;
	
	//get all medicines rest api
	@GetMapping("/medicines")
	public List<Medicine> getAllMedicine(){
		return medRepo.findAll();
	}
	    // create medicines rest api
		@PostMapping("/medicines")
		public Medicine createMedicine(@RequestBody Medicine medicine) {
			return medRepo.save(medicine);
		}
		// get medicines by id rest api
		@GetMapping("/medicines/{id}")
		public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) {
			Medicine medicine = medRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Medicine not exist with id :" + id));
			return ResponseEntity.ok(medicine);
		}
		
		// update medicines rest api		
		@PutMapping("/medicines/{id}")
		public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestBody Medicine medicineDetails){
			Medicine medicine = medRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Medicine not exist with id :" + id));
			
			medicine.setMedicineName(medicineDetails.getMedicineName());
			medicine.setDiseaseName(medicineDetails.getDiseaseName());
			medicine.setMedicineTime(medicineDetails.getMedicineTime());
			medicine.setMedicineOrder(medicineDetails.getMedicineOrder());
			
			Medicine updateMedicine = medRepo.save(medicine);
			return ResponseEntity.ok(updateMedicine);
		}
		
		// delete medicines rest api
		@DeleteMapping("/medicines/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteMedicine(@PathVariable Long id){
			Medicine medicine = medRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Medicine not exist with id :" + id));
			
			medRepo.delete(medicine);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}	
}
