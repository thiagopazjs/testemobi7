package com.mobi7.mobi7.repository;

import com.mobi7.mobi7.entity.Posicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PosicaoRepository extends JpaRepository <Posicao, Long> {

    @Query("from Posicao p where p.dataPosicao between :dataIni and :dataFin")
    public List<Posicao> getListByData(Date dataIni, Date dataFin);




}
