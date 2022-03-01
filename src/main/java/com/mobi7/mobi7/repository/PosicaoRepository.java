package com.mobi7.mobi7.repository;

import com.mobi7.mobi7.entity.Posicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PosicaoRepository extends JpaRepository <Posicao, Long> {



   
}
