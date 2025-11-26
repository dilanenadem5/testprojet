package org.gestion.repository;

import org.gestion.model.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Eleverepository extends JpaRepository<Eleve, Long> {
    Eleve findByEmail(String email);
}
