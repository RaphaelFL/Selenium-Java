package br.com.alura.leilao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.leilao.model.Lance;

public interface LanceRepository extends JpaRepository<Lance, Long> {

}
