package com.br.ufrpe.moveis.atividade_de_moveis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public abstract class SuperTypeController<T> implements Serializable {

    @CrossOrigin
    @PostMapping("/save")
    public abstract ResponseEntity<T> save(@RequestBody T o);
}
