package com.br.ufrpe.moveis.atividade_de_moveis.beans;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "crime")
public class Crime implements Serializable{

    @Id
    @GeneratedValue
    private Integer crime_id;
    private String cidade;
    @Column(name = "data_ocorrencia")
    private Date dataOcorrencia;
    private int idade;
    private String nome;
    private String objeto_utilizado;
    private int qtd_vitimas;
    private String sexo;
    private String tipo_crime;
}
