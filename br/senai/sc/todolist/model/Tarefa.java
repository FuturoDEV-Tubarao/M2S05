package br.senai.sc.todolist.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefa {
    
    private Integer id;

    private String texto;

    private boolean concluida; // false

    private LocalDateTime dataCriacao;

    
    public Tarefa() {
        this.dataCriacao = LocalDateTime.now();
    }

    public Tarefa(String texto) {
        this();
        this.texto = texto;
    }


    @Override
    public String toString() {
        return "Tarefa id=" + id + 
        ", texto=" + texto + 
        ", concluida=" + (concluida ? "sim" : "não") + 
        ", dataCriacao=" + dataCriacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }


    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

}
