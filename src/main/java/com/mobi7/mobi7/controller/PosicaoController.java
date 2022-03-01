package com.mobi7.mobi7.controller;


import com.mobi7.mobi7.entity.Posicao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping ("/api/v1/posicao")
public class PosicaoController {


    //Serviço Restfull
    @GetMapping(value = "/status", produces = "application/json")
    public ResponseEntity<Posicao> init() throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z '('z')'", Locale.ENGLISH);
        Date date = format.parse("Wed Dec 19 2018 15:07:19 GMT -0300 (BRT)");
        Posicao posicao = new Posicao();
        posicao.setId(1L);
        posicao.setPlaca("TESTE01");
        posicao.setDataPosicao(date);
        posicao.setVelocidade(0);
        posicao.setIgnicao(true);
        posicao.setLongitude(-51.469891);
        posicao.setLatitude(-25.3649141);

        return ResponseEntity.ok(posicao);
        }
    }







