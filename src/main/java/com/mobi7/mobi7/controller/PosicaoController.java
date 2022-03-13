
package com.mobi7.mobi7.controller;
import com.mobi7.mobi7.entity.Posicao;
import com.mobi7.mobi7.posicoes.util.ConvertSeconsdInsDays;
import com.mobi7.mobi7.posicoes.util.FormatDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/posicao")
public class PosicaoController {

    //Serviço Restfull

    private static final Long SEGUNDOSDIA = 86400l;
    @GetMapping(value = "/status{placa}", produces = "application/json")
    public ResponseEntity<Posicao> init(@RequestParam String placa) throws ParseException {



        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z '('z')'", Locale.ENGLISH);
        Date date = format.parse("Mon Mar 07 2022 12:04:09 GMT -0200 (BRT)");
        Date date1 = format.parse("Mon Mar 07 2022 13:06:16 GMT -0200 (BRT)");
         Date atual = FormatDate.execute(format);


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
        posicao1.setDataPosicao(date1);
        posicao1.setVelocidade(0);
        posicao1.setIgnicao(false);
        posicao1.setLongitude(-51.469953);
        posicao1.setLatitude(-25.364846);




        List<Posicao> posicoes = new ArrayList<Posicao>();
        posicoes.add(posicao);
        posicoes.add(posicao1);

        List<Posicao> placas = posicoes.stream().filter(item -> item.getPlaca().equals(placa)).collect(Collectors.toList());
        List <Posicao> posicaoPorPlaca =placa.isEmpty()?posicoes:placas;
        if(!posicaoPorPlaca.isEmpty()){



            for (int i = 0; i < posicaoPorPlaca.size() - 1; i++) {
                if (i < posicaoPorPlaca.size()) {


                    long diferencaTimesTamps = posicaoPorPlaca.get(i + 1).getDataPosicao().getTime() - posicaoPorPlaca.get(i).getDataPosicao().getTime();

                    Long segundos = TimeUnit.MILLISECONDS.toSeconds(diferencaTimesTamps);

                    ConvertSeconsdInsDays convertSeconsdInsDays = new ConvertSeconsdInsDays(segundos);


                    Date dataCorrente = posicaoPorPlaca.get(i).getDataPosicao();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(dataCorrente);

                     posicaoPorPlaca.get(i).setTempo(convertSeconsdInsDays.execute());
                    posicaoPorPlaca.get(i).setDescricao(" O Veiculo " + posicaoPorPlaca.get(i).getPlaca()+" Estava  no dia " +ajustarHora(calendar.get(Calendar.DAY_OF_MONTH))+ "/"
                            + ajustarHora(calendar.get(Calendar.MONTH)) + "/"
                            + ajustarHora(calendar.get(Calendar.YEAR)) +" as "
                            + ajustarHora(calendar.get(Calendar.HOUR)) +":"
                            + ajustarHora(calendar.get(Calendar.MINUTE))
                            +":"+ ajustarHora(calendar.get(Calendar.SECOND)));

                }
            }


            long diferencaTimesTamps = atual.getTime() -posicoes.get(posicaoPorPlaca.size()-1).getDataPosicao().getTime() ;

            Long segundos = TimeUnit.MILLISECONDS.toSeconds(diferencaTimesTamps);

            ConvertSeconsdInsDays convertSeconsdInsDays = new ConvertSeconsdInsDays(segundos);

            Date dataCorrente = posicaoPorPlaca.get(posicaoPorPlaca.size()-1).getDataPosicao();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataCorrente);

             posicaoPorPlaca.get(posicaoPorPlaca.size()-1).setTempo(convertSeconsdInsDays.execute());
            posicaoPorPlaca.get(posicaoPorPlaca.size()-1).setDescricao(" O Veiculo " + posicaoPorPlaca.get(posicaoPorPlaca.size()-1).getPlaca()+" estava no dia " + ajustarHora(calendar.get(Calendar.DAY_OF_MONTH))+ "/"
                    + ajustarHora(calendar.get(Calendar.MONTH)) + "/"
                    + ajustarHora(calendar.get(Calendar.YEAR)) +" as "
                    + ajustarHora(calendar.get(Calendar.HOUR)) +":"
                    + ajustarHora(calendar.get(Calendar.MINUTE))
                    +":"+ ajustarHora(calendar.get(Calendar.SECOND)));

             posicaoPorPlaca.get(posicaoPorPlaca.size()-1).setTempo(convertSeconsdInsDays.execute());

        }
        return new ResponseEntity(posicaoPorPlaca, HttpStatus.OK);


    }
        private  String ajustarHora (int arg) {

        return arg < 10? "0" +arg:String.valueOf(arg);
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













