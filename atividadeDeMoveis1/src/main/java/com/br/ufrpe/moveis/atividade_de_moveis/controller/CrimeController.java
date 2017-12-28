package com.br.ufrpe.moveis.atividade_de_moveis.controller;

import com.br.ufrpe.moveis.atividade_de_moveis.beans.Crime;
import com.br.ufrpe.moveis.atividade_de_moveis.dados.CrimeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/crimes")
public class CrimeController extends SuperTypeController<Crime>{

    @Autowired
    private CrimeDAO crimeDAO;

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<Crime>> listarCrimes(){
        return new ResponseEntity<List<Crime>>(this.crimeDAO.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Crime> save(@RequestBody Crime o) {
        if(o != null){
            crimeDAO.save(o);
            return new ResponseEntity<Crime>(o, HttpStatus.OK);
        }else{
            return new ResponseEntity<Crime>(HttpStatus.NO_CONTENT);
        }

    }

//    @CrossOrigin
//    @PostMapping("/save")
//    public ResponseEntity<Crime> save(@RequestBody Crime crime) {
//        if(crime != null){
//            this.crimeDAO.save(crime);
//            return new ResponseEntity<Crime>(crime, HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<Crime>(HttpStatus.NO_CONTENT);
//        }
//    }

    @CrossOrigin
    @GetMapping("/sexo/{sexo}")
    public ResponseEntity<List<Crime>> findBySexo(@PathVariable("sexo") Integer sexo){
        String paramentro = "";
        if(sexo == 1) {
            paramentro = "MASCULINO";
            return new ResponseEntity<List<Crime>>(crimeDAO.findAllBySexo(paramentro), HttpStatus.OK);
        }
        else {
            paramentro = "FEMININO";
            return new ResponseEntity<List<Crime>>(crimeDAO.findAllBySexo(paramentro), HttpStatus.OK);
        }
    }

    @CrossOrigin
    @GetMapping(path = "/data")
    public ResponseEntity<List<Crime>> filtroData(@RequestParam String inicio, @RequestParam String fim) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        return new ResponseEntity<List<Crime>>(crimeDAO.findAllByDataOcorrenciaBetween(sdf.parse(inicio), sdf.parse(fim)), HttpStatus.OK);
    }
}