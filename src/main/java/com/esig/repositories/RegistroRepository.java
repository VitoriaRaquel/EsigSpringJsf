package com.esig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.esig.domain.Registro;

import java.util.List;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {
    
   
    @Query(value = "SELECT * FROM REGISTRO WHERE STATUS = ?1", nativeQuery = true)
    List<Registro> findByStatus(Boolean b);

}