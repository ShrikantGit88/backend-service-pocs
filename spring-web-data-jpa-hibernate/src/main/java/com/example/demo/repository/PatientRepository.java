package com.example.demo.repository;

import com.example.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	//findBy methods example
	List<Patient> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);

	List<Patient> findByFirstNameContaining(String firstName);

	//JPQL (Java Persitence Query Language) static query
	@Query("from Patient")
	List<Patient> findAllPatients();

	//JPQL named static query
	@Query("from Patient p where p.firstName=:firstName")
	List<Patient> findPatientsByfName(@Param("firstName") String firstName);
	//JPQL Native Query
	@Query(value = "select * from patient p where p.first_name = :firstName", nativeQuery = true)
	List<Patient> findPatientsByfNameNative(@Param("firstName") String firstName);


}
