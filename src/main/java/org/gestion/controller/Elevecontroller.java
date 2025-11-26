package org.gestion.controller;

import lombok.RequiredArgsConstructor;
import org.gestion.dto.DtoEleve;
import org.gestion.model.Eleve;
import org.gestion.service.Eleveservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/eleve")
public class Elevecontroller {
    private final Eleveservice eleveservice;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DtoEleve> read(){
        return this.eleveservice.read();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DtoEleve readById(@PathVariable("id") Long id){
        return this.eleveservice.readById(id);
    }
    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Eleve readByEmail(@PathVariable("email") String email){
        return this.eleveservice.readBYEmail(email);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Eleve create(@RequestBody Eleve eleve){
       return this.eleveservice.create(eleve);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody Eleve eleve){
        return this.eleveservice.update(id, eleve);
    }
    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        this.eleveservice.delete(id);
    }

}
