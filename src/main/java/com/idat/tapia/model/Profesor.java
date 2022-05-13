package com.idat.tapia.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "profesor")
@Entity
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProfesor;
    private String profesor;

    @ManyToMany(mappedBy = "profesor", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Curso> cursos = new ArrayList<Curso>();

}
