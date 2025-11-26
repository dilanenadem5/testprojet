package org.gestion.repository;

import org.gestion.model.Eleve;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class EleverepositoryTest {
    @Autowired
    Eleverepository eleveRepository;
    @Test
    void shoulReadByEmail() {
        Eleve eleved = new Eleve();
                eleved.setName("dilane");
                eleved.setEmail("dilane@gmail.com");
                eleved.setClasse("pf3");
                eleved.setTelephone("653552518");
                eleved.setAnne("2021");
        eleveRepository.save(eleved);
        Eleve elevedb = eleveRepository.findByEmail(eleved.getEmail());
        Assertions.assertNotNull(elevedb);
        Assertions.assertEquals("dilane@gmail.com", elevedb.getEmail());
        Assertions.assertEquals(1, elevedb.getId());

    }
}