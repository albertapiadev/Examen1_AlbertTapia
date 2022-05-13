package com.idat.tapia.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "curso")
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;
    private String curso;
    private String descripcion;
    private int idMalla;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name="curso_profesor",
            joinColumns =
            @JoinColumn(
                    name="id_profesor",
                    nullable = false,
                    unique = true,
                    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_profesor) references profesor (id_profesor)")),

            inverseJoinColumns =
            @JoinColumn(
                    name="id_curso",
                    nullable = false,
                    unique = true,
                    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_curso) references curso (id_curso)"))
    )
    private List<Profesor> profesor = new ArrayList<Profesor>();

    @OneToMany(mappedBy = "cursos")
    private List<MallaCurricular> malla = new ArrayList<MallaCurricular>();

}
