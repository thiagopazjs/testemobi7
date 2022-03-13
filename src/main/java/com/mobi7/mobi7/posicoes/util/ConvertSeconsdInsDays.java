package com.mobi7.mobi7.posicoes.util;


public class ConvertSeconsdInsDays {

    private static final Long SEGUNDOSDIA = 86400l;
    private static final int SEGUNDOSHORA = 3600;
    private static final int SEGUNDOMINUTO = 60;
    private Long totalDeSegundos;



   public ConvertSeconsdInsDays (Long toTalDeSegundos){

        this.totalDeSegundos =toTalDeSegundos;

    }


    public String execute (){

        String result = "";
        if (this.getDias() > 0) {
            String totalDeDias = this.getDias() > 1? "s": "";
            result = "Total de " + this.getDias() + " dia" + totalDeDias + " ";

        } if (this.getHoras() > 0) {
            String totalDeHoras = this.getHoras() > 1? "s": "";
            result +=  this.getHoras() + " Hora" + totalDeHoras ;

            if (this.getMinutos() > 0) {
                String totaldeMinutos = this.getMinutos() > 1? "s": "";
                result +=  " e " + this.getMinutos() + " minuto" + totaldeMinutos ;

            }

        }

        return !result.isEmpty()? result: "Acabou de entrar no ponto";

    }


    private Long getDias (){

        return this.totalDeSegundos /SEGUNDOSDIA;

    }

    private int getHoras (){

        Long segundosRestantes = this.totalDeSegundos % SEGUNDOSDIA;
        return Integer.parseInt(String.valueOf(segundosRestantes / SEGUNDOSHORA));



    }

    private int getMinutos (){

        Long segundosRestantes = this.totalDeSegundos % SEGUNDOSDIA;

        Long  segundosRestantesHoras = segundosRestantes % SEGUNDOSHORA;

        return Integer.parseInt(String.valueOf(segundosRestantesHoras /SEGUNDOMINUTO));



    }


}


