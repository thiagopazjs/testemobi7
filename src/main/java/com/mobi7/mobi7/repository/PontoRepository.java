package com.mobi7.mobi7.repository;

import com.mobi7.mobi7.entity.PontoInteresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoRepository extends JpaRepository <PontoInteresse,Long> {

}
