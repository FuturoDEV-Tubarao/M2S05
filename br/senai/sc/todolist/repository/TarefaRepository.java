package br.senai.sc.todolist.repository;

import java.util.ArrayList;
import java.util.List;

import br.senai.sc.todolist.exception.TarefaException;
import br.senai.sc.todolist.model.Tarefa;

public class TarefaRepository {

    private List<Tarefa> tarefas = new ArrayList<>(); // simulando BD
    private int identificador = 0;  // sequencial para id
    
    public void gravar(Tarefa tarefa) {
        tarefa.setId(++identificador);
        tarefas.add(tarefa);
    }

    public List<Tarefa> consultar() {
        return tarefas;
    }

    public void excluir(int id) {
       List<Tarefa> atualizadas = new ArrayList<>();
       for (Tarefa tarefa : tarefas) {
        if (tarefa.getId() != id)
            atualizadas.add(tarefa);
       } 
       tarefas = atualizadas;
       // tarefas.removeIf(t -> t.getId() != id);  // mesma coisa, no paradigma funcional 
    }

    public Tarefa consultarPorId(int id) {
        for(Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }
        return null;
        // return tarefas.stream().filter(t -> t.getId() == id).findFirst().orElse(null); // mesma coisa, paradigma funcional
    }

    public void marcarComoConcluida(int id) throws TarefaException {
        boolean atualizou = false;
        for(Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                tarefa.setConcluida(true);
                atualizou = true;
            }
        }
        if (!atualizou)
            throw new TarefaException("Tarefa com id não localizado");
    }

}
