package com.mobi7.mobi7.controller;

import com.mobi7.mobi7.entity.PontoInteresse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/pontos")

public class PontoIntresseController {

    //Serviço Restfull
    @GetMapping(value = "/status{pontos}", produces = "application/json")
    public ResponseEntity<List<PontoInteresse>> init() throws ParseException {


        PontoInteresse pontoInteresse = new PontoInteresse();
        pontoInteresse.setId(1L);
        pontoInteresse.setNome("PONTO 1");
        pontoInteresse.setRaio(300);
        pontoInteresse.setLatitude(-25.56742701740896);
        pontoInteresse.setLongitude(-51.47653363645077);

        PontoInteresse pontoInteresse2 = new PontoInteresse();
        pontoInteresse2.setId(2L);
        pontoInteresse2.setNome("PONTO 2");
        pontoInteresse2.setRaio(300);
        pontoInteresse2.setLatitude(-25.568056);
        pontoInteresse2.setLongitude(-51.480278);



        List<PontoInteresse> pontosInteresse = new ArrayList<PontoInteresse>();
        pontosInteresse.add(pontoInteresse);
        pontosInteresse.add(pontoInteresse2);

        return new ResponseEntity(pontosInteresse, HttpStatus.OK);

    }
    }



