package com.mobi7.mobi7.controller;

import com.mobi7.mobi7.entity.Posicao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

import java.util.stream.Collectors;
;

@RestController
@RequestMapping("/api/v1/posicao")
public class PosicaoController {

    //Serviço Restfull

    @GetMapping(value = "/status{placa}", produces = "application/json")
    public ResponseEntity<Posicao> init(@RequestParam String placa) throws ParseException {



        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z '('z')'", Locale.ENGLISH);
        Date date = format.parse("Mon Mar 07 2022 20:04:09 GMT -0200 (BRT)");
        Date date1 = format.parse("Mon Mar 07 2022 20:04:09 GMT -0200 (BRT)");


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
        posicao1.setPlaca("TESTE02");
        posicao1.setDataPosicao(date1);
        posicao1.setVelocidade(0);
        posicao1.setIgnicao(false);
        posicao1.setLongitude(-51.469953);
        posicao1.setLatitude(-25.364846);


        List<Posicao> posicoes = new ArrayList<Posicao>();
        posicoes.add(posicao);
        posicoes.add(posicao1);

        List<Posicao> posicaoPorPlaca = posicoes.stream().filter(item -> item.getPlaca().equals(placa)).collect(Collectors.toList());
        if(!posicaoPorPlaca.isEmpty()) {


            int i;
            for (i = 0; i < posicaoPorPlaca.size() - 1; i++) {
                if (i < posicaoPorPlaca.size()) {


                    Date dataCorrente = posicaoPorPlaca.get(i).getDataPosicao();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(dataCorrente);

                    posicaoPorPlaca.get(posicaoPorPlaca.size() - 1).setDescricao(" O Veiculo " + posicaoPorPlaca.get(posicaoPorPlaca.size() - 1).getPlaca() + " estava no dia " + calendar.get(Calendar.DAY_OF_MONTH) + "/"
                            + calendar.get(Calendar.MONTH) + "/"
                            + calendar.get(Calendar.YEAR) + " as "
                            + calendar.get(Calendar.HOUR) + ":"
                            + calendar.get(Calendar.MINUTE)
                            + ":" + calendar.get(Calendar.SECOND) + " na posicao " + posicaoPorPlaca.get(i).getLatitude()+ " " + posicaoPorPlaca.get(i).getLongitude()+ " com a ignição Ligada "+
                            "Para visualiazar a posicão no google maps:https://maps.google.com/maps?q="+posicaoPorPlaca.get(i).getLatitude()+ posicaoPorPlaca.get(i).getLongitude());

                }
            }

            Date dataCorrente = posicaoPorPlaca.get(posicaoPorPlaca.size() - 1).getDataPosicao();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataCorrente);


            posicaoPorPlaca.get(posicaoPorPlaca.size() - 1).setDescricao(" O Veiculo " + posicaoPorPlaca.get(posicaoPorPlaca.size() - 1).getPlaca() + " estava no dia " + calendar.get(Calendar.DAY_OF_MONTH) + "/"
                    + calendar.get(Calendar.MONTH) + "/"
                    + calendar.get(Calendar.YEAR) + " as "
                    + calendar.get(Calendar.HOUR) + ":"
                    + calendar.get(Calendar.MINUTE)
                    + ":" + calendar.get(Calendar.SECOND) + " na posicao " + posicaoPorPlaca.get(i).getLatitude()+ " " + posicaoPorPlaca.get(i).getLongitude()+ " com a ignição Desligada "+
                    "Para visualiazar a posicão no google maps:https://maps.google.com/maps?q="+posicaoPorPlaca.get(i).getLatitude()+ posicaoPorPlaca.get(i).getLongitude());


        }



        return new ResponseEntity(posicaoPorPlaca, HttpStatus.OK);


    }



   /* @Autowired

   Se for realizar injeção de dependencias usar este código"

    private PosicaoRepository posicaoRepository;
    PosicaoController(PosicaoRepository posicaoRepository) {
        Posicao Posicao = new Posicao();
        posicaoRepository.saveAll(Arrays.asList(Posicao));
        this.posicaoRepository = posicaoRepository;
    }
    @GetMapping("/posicao-por-data")
    public List<Posicao> posicaoByData(@RequestParam(required = false) Date dataIni, @RequestParam(required = false) Date dataFin) {
        return posicaoRepository.getListByData(dataIni, dataFin);
    }*/


}











