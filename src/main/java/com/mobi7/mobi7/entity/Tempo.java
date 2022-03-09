
package com.mobi7.mobi7.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Tempo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalDateTime tempo;
    private String placa;
    private String pontoInteresse;
    private Double latitude;
    private Double longitude;



    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPontoInteresse() {
        return pontoInteresse;
    }

    public void setPontoInteresse(String pontoInteresse) {
        this.pontoInteresse = pontoInteresse;
    }

    public LocalDateTime getTempo(int i) {
        return tempo;
    }

    public void setTempo(String tempo) {

        this.tempo = LocalDateTime.now();
    }


    public void setTempo() {
    }
}






