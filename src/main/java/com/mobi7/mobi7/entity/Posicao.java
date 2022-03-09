package com.mobi7.mobi7.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor

public class Posicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "placa")
    private String placa;

    @Column(name = "data_posicao")
    private Date dataPosicao;

    @Column(name = "velocidade")
    private Integer velocidade;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "ignicao")
    private Boolean ignicao;

    @Column(name = "descricao")
    private String descricao;

    public Posicao() {

    }


    public Posicao(String s, Date parse, int parseInt, double parseDouble, double parseDouble1, boolean parseBoolean) {
    }
}
