package com.idat.tapia.model;

import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "universidad")
@Entity
public class Universidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUniversidad;
    private String universidad;

    @OneToOne
    @JoinColumn(name="id_malla", nullable = false, unique = true,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_malla) references malla_curricular (id_malla)"))
    private MallaCurricular malla;


}
