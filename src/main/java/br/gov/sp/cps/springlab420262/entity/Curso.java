package br.gov.sp.cps.springlab420262.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.cps.springlab420262.controller.View;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "cur_curso")
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cur_id")
    @JsonView({View.DisciplinaView.class, View.CursoView.class})
    private Long id;

    @Column(name = "cur_sigla")
    @JsonView({View.DisciplinaView.class})
    private String sigla;


    @Column(name = "cur_nome")
    @JsonView({View.CursoView.class})
    private String nome;

    @OneToMany(mappedBy = "curso")
    private Set<Disciplina> disciplinas;

    public Curso(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public Curso() {
    }

    public Long getId() {
        return id;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
