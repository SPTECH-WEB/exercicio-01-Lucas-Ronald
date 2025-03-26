package br.com.exemplo.apifaturas.service;

import br.com.exemplo.apifaturas.model.Fatura;
import br.com.exemplo.apifaturas.repository.FaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaturaService {

    private FaturaRepository faturaRepository;
    public FaturaService(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    public List<Fatura> listarTodos() {
        return faturaRepository.findAll();
    }

    public Optional<Fatura> buscarPorId(Long id) {
        return faturaRepository.findById(id);
    }

    public Fatura salvar(Fatura fatura) {
        return faturaRepository.save(fatura);
    }

    public void deletarPorId(Long id) {
        faturaRepository.deleteById(id);
    }
}
