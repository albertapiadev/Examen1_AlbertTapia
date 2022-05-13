package com.idat.tapia.model;

import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "malla_curricular")
@Entity
public class MallaCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMalla;
    private String anio;

    @JoinColumn(name = "id_curso",
            nullable = false,
            unique = true,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_curso) references curso(id_curso)"))
    @ManyToOne
    private Curso cursos;

    @OneToOne(mappedBy = "malla")
    private Universidad universidad;

}
