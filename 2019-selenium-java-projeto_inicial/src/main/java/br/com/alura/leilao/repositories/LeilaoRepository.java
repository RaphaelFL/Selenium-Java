package br.com.alura.leilao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.leilao.model.Leilao;

public interface LeilaoRepository extends JpaRepository<Leilao, Long> {

}
