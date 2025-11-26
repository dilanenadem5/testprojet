package org.gestion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoEleve {
    private Long id;
    private String name;
    private String email;
    private String classe;
    private String telephone;
    private String anne;
}
