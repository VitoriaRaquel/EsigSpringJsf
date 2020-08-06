package com.esig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.esig.domain.Registro;

import java.util.List;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {

    @Transactional(readOnly=true)
    List<Registro> findByStatus(Boolean status);

}