package com.mobi7.mobi7.controller;
import com.mobi7.mobi7.entity.Placas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/placa")
public class PlacasController {

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Placas>> init() throws ParseException {

        Placas placa = new Placas();
        placa.setId(1L);
        placa.setPlaca("TESTE001");

        Placas placas2 = new Placas();
        placas2.setId(2L);
        placas2.setPlaca("TESTE001");


        List<Placas> placas = new ArrayList<Placas>();
        placas.add(placa);
        placas.add(placas2);



        return new ResponseEntity(placas, HttpStatus.OK);

    }
}
