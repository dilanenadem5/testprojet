package org.gestion.service;

import lombok.RequiredArgsConstructor;
import org.gestion.dto.DtoEleve;
import org.gestion.model.Eleve;
import org.gestion.repository.Eleverepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class Eleveservice {
    private final Eleverepository eleveRepository;

    public List<DtoEleve> read() {
        return  this.eleveRepository.findAll().stream().map(e->new DtoEleve(e.getId(),e.getName(),e.getEmail(),e.getClasse(),e.getTelephone(),e.getAnne())).collect(Collectors.toList());
    }
    public DtoEleve readById(Long id) {
        return this.eleveRepository.findById(id).map(e->new DtoEleve(e.getId(),e.getName(),e.getEmail(),e.getClasse(),e.getTelephone(),e.getAnne())).orElseThrow(()-> new IllegalArgumentException("eleve not found id" + id));
    }
    public Eleve create(Eleve eleve) {
        Eleve elevedb = this.eleveRepository.findByEmail(eleve.getEmail());
        if (elevedb != null ){
            throw new RuntimeException("eleve does exist for" + eleve.getEmail());
        }
        return this.eleveRepository.save(eleve);
    }
    public ResponseEntity<Void> update(Long id, Eleve eleve) {
        Eleve elevedb = this.eleveRepository.findById(id).orElseThrow(()-> new RuntimeException("eleve not found id" + id));
        elevedb.setName(eleve.getName());
        elevedb.setEmail(eleve.getEmail());
        elevedb.setClasse(eleve.getClasse());
        elevedb.setTelephone(eleve.getTelephone());
        elevedb.setAnne(eleve.getAnne());
        this.eleveRepository.save(eleve);
        return  ResponseEntity.status(HttpStatus.OK).build();
    }

    public void delete(Long id) {
        Eleve eleve = this.eleveRepository.findById(id).orElseThrow(()-> new RuntimeException("eleve not found id " +id));
        this.eleveRepository.deleteById(eleve.getId());
    }

    public Eleve readBYEmail(String email) {
         return this.eleveRepository.findByEmail(email);
    }
}
