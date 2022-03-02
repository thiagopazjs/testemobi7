package com.mobi7.mobi7.repository;

import com.mobi7.mobi7.entity.Tempo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempoRepository extends JpaRepository<Tempo, Long>{


}
