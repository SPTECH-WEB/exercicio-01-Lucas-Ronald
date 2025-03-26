package br.com.exemplo.apifaturas.controller;

import br.com.exemplo.apifaturas.model.Fatura;
import br.com.exemplo.apifaturas.repository.FaturaRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faturas")
public class FaturaController {

    private FaturaRepository faturaRepository;
    public FaturaController(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    @GetMapping
    public List<Fatura> listarFaturas(){
        return faturaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fatura> buscar(@PathVariable Long id){
        Optional<Fatura> fatura = faturaRepository.findById(id);
        return fatura.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fatura> criarFatura(@Valid @RequestBody Fatura fatura){
        Fatura novaFatura = faturaRepository.save(fatura);
        return ResponseEntity.ok(novaFatura);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFatura(@PathVariable Long id){
        if(faturaRepository.findById(id).isPresent()){
            faturaRepository.deleteById(id);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fatura> atualizarFatura(@PathVariable Long id, @Valid @RequestBody Fatura fatura){
        if(faturaRepository.findById(id).isPresent()){
            fatura.setId(id);
            Fatura faturaAtualizada = faturaRepository.save(fatura);
            return ResponseEntity.ok(faturaAtualizada);
        }
        return ResponseEntity.notFound().build();
    }
}
