package br.gov.sp.cps.springlab420262.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.cps.springlab420262.controller.View;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*
estrutura da classe Trabalho, que representa uma entidade de trabalho acadêmico no sistema. A classe possui os seguintes atributos:
create table tra_trabalho (
tra_id bigint generated always as identity,
tra_titulo varchar(100) not null unique,
tra_data_hora_entrega timestamp not null,
tra_descricao varchar(200),
tra_aluno bigint not null,
tra_nota int,
tra_justificativa varchar(100),
primary key(tra_id),
constraint tra_aln_fk foreign key(tra_aluno) references aln_aluno(aln_id)
);

1) Crie uma classe que mapeie a tabela criada;

*/

@Entity
@Table(name = "tra_trabalho")
public class Trabalho {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tra_id")
    @JsonView({View.TrabalhoView.class})
    private Long id;

    @Column(name = "tra_titulo", nullable = false, unique = true)
    @JsonView({View.TrabalhoView.class})
    private String titulo;

    @Column(name = "tra_data_hora_entrega", nullable = false)
    @JsonView({View.TrabalhoView.class})
    private String dataHoraEntrega;

    @Column(name = "tra_descricao")
    @JsonView({View.TrabalhoView.class})
    private String descricao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tra_aluno", nullable = false)
    @JsonView({View.TrabalhoView.class})
    private Aluno aluno;

    @Column(name = "tra_nota")
    @JsonView({View.TrabalhoView.class})
    private Integer nota;

    @Column(name = "tra_justificativa")
    @JsonView({View.TrabalhoView.class})
    private String justificativa;  
    
    public Trabalho(String titulo, String dataHoraEntrega, String descricao, Aluno aluno, Integer nota, String justificativa) {
        this.titulo = titulo;
        this.dataHoraEntrega = dataHoraEntrega;
        this.descricao = descricao;
        this.aluno = aluno;
        this.nota = nota;
        this.justificativa = justificativa;
    }

    public Trabalho() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataHoraEntrega() {
        return dataHoraEntrega;
    }

    public void setDataHoraEntrega(String dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }
   
}