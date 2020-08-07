package com.esig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.esig.domain.Registro;

import java.util.List;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM REGISTRO WHERE STATUS = true", nativeQuery = true)
    void deleteAllStatusCompleted();

    
   
    @Query(value = "SELECT * FROM REGISTRO WHERE STATUS = ?1", nativeQuery = true)
    List<Registro> findByStatus(Boolean b);

}