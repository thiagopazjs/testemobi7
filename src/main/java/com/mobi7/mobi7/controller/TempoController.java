package com.mobi7.mobi7.controller;
import com.mobi7.mobi7.entity.Tempo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tempo")
public class TempoController {

    @GetMapping(value = "/status/check", produces = "application/json")

    public ResponseEntity<Tempo> init() throws ParseException {

        Tempo tempo = new Tempo();

        tempo.getTempo();


        List<Tempo> tempos = new ArrayList<Tempo>();


        return new ResponseEntity(tempos, HttpStatus.OK);


    }


}





