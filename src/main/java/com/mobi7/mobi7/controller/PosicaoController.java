package com.mobi7.mobi7.controller;


import com.mobi7.mobi7.entity.Posicao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

@RestController
@RequestMapping ("/api/v1/posicao")
public class PosicaoController {

    /*@Autowired
        SE FOR REALIZAR INJEÇÃO DE DEPENDENCIAS H2

        private PosicaoRepository posicaoRepository;
        PosicaoController(PosicaoRepository posicaoRepository) {
        Posicao Posicao = new Posicao();
        posicaoRepository.saveAll(Arrays.asList(Posicao));
        this.posicaoRepository = posicaoRepository;
    }*/

    //Serviço Restfull
    @GetMapping(value = "/status{posicoes}", produces = "application/json")
    public ResponseEntity<Posicao> init() throws ParseException {


        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z '('z')'", Locale.ENGLISH);
        Date date = format.parse("Wed Dec 19 2018 01:04:09 GMT -0200 (BRT)");

        Posicao posicao = new Posicao();

        posicao.setId(1L);
        posicao.setPlaca("TESTE01");
        posicao.setDataPosicao(date);
        posicao.setVelocidade(0);
        posicao.setIgnicao(true);
        posicao.setLongitude(-51.469891);
        posicao.setLatitude(-25.3649141);

        Posicao posicao1 = new Posicao();
        posicao1.setId(2L);
        posicao1.setPlaca("TESTE01");
        posicao1.setDataPosicao(date);
        posicao1.setVelocidade(0);
        posicao1.setIgnicao(false);
        posicao1.setLongitude(-51.469953);
        posicao1.setLatitude(-25.364846);


        List<Posicao> posicoes = new ArrayList<Posicao>();
        posicoes.add(posicao);
        posicoes.add(posicao1);

        return new ResponseEntity(posicoes, HttpStatus.OK);


        }

    /*@GetMapping(value = "/status{posicoes}", produces = "application/json")
    public ResponseEntity<Placa> init() throws ParseException {


        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z '('z')'", Locale.ENGLISH);
        Date date = format.parse("Wed Dec 19 2018 01:04:09 GMT -0200 (BRT)");

        Posicao posicao = new Posicao();

        posicao.setId(1L);
        posicao.setPlaca("TESTE01");
        posicao.setDataPosicao(date);
        posicao.setVelocidade(0);
        posicao.setIgnicao(true);
        posicao.setLongitude(-51.469891);
        posicao.setLatitude(-25.3649141);

        Posicao posicao1 = new Posicao();
        posicao1.setId(2L);
        posicao1.setPlaca("TESTE01");
        posicao1.setDataPosicao(date);
        posicao1.setVelocidade(0);
        posicao1.setIgnicao(false);
        posicao1.setLongitude(-51.469953);
        posicao1.setLatitude(-25.364846);


        List<Posicao> posicoes = new ArrayList<Posicao>();
        posicoes.add(posicao);
        posicoes.add(posicao1);

        return new ResponseEntity(posicoes, HttpStatus.OK);


        */


    }










