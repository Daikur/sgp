package com.fpmislata.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g ORDER BY g.id")})
@Table(name = "grupos")

public class Grupo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 45)
    private String curso;

    @Column(nullable = false, length = 45)
    private String grupo;

    @Column(nullable = false, length = 45)
    private int id_tutor;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Tutor tutor;

    public Grupo(int id, String curso, String grupo, int id_tutor) {
        this.id = id;
        this.curso = curso;
        this.grupo = grupo;
        this.id_tutor = id_tutor;
    }

    public Grupo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(int id_tutor) {
        this.id_tutor = id_tutor;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grupo other = (Grupo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Grupo{" + "id=" + id + ", curso=" + curso + ", grupo=" + grupo + ", id_tutor=" + id_tutor + ", tutor=" + tutor + '}';
    }

    
    
    
}
