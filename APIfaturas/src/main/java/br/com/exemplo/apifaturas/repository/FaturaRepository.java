package br.com.exemplo.apifaturas.repository;

import br.com.exemplo.apifaturas.model.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaturaRepository extends JpaRepository<Fatura, Long> {
}
