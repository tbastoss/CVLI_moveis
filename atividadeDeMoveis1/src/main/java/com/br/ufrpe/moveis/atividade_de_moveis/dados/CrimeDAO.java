package com.br.ufrpe.moveis.atividade_de_moveis.dados;

import com.br.ufrpe.moveis.atividade_de_moveis.beans.Crime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CrimeDAO extends JpaRepository<Crime, Integer> {

    public List<Crime> findAllByDataOcorrenciaBetween(Date inicio, Date fim);

    public List<Crime> findAllBySexo(String sexo);
}
