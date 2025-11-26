package org.gestion.service;

import org.gestion.model.Eleve;
import org.gestion.repository.Eleverepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class EleveserviceTest {

    @Mock
    Eleverepository eleverepository;
    @InjectMocks
    Eleveservice eleveservice;
    @Test
    void create() {
        Eleve eleved = new Eleve();
        eleved.setName("dilane");
        eleved.setEmail("dilane@gmail.com");
        eleved.setClasse("pf3");
        eleved.setTelephone("653552518");
        eleved.setAnne("2021");
        when(this.eleverepository.save(eleved)).thenReturn(eleved);
        Eleve p = this.eleveservice.create(eleved);
        assertThat(p).isEqualTo(eleved);
    }

    @Test
    void shouldReturnEleveByEmail(){
        Eleve eleved = new Eleve();
        eleved.setName("dilane");
        eleved.setEmail("dilane@gmail.com");
        eleved.setClasse("pf3");
        eleved.setTelephone("653552518");
        eleved.setAnne("2021");
        when(this.eleverepository.save(eleved)).thenReturn(eleved);
        when(this.eleverepository.findByEmail(eleved.getEmail())).thenReturn(eleved);
        Eleve p = this.eleveservice.readBYEmail(eleved.getEmail());
        Assertions.assertEquals("dilane@gmail.com",p.getEmail());
    }
}