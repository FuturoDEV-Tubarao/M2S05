package br.senai.sc.todolist.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import br.senai.sc.todolist.model.Tarefa;

public class GeradorArquivo {

    public static void gerar(String nomeArquivo, List<Tarefa> lista) {
        try {
            Path path = Paths.get(nomeArquivo);
            Files.deleteIfExists(path);
            Files.createFile(path);
            for(Tarefa tarefa: lista) {
                String linha = tarefa.toString() + "\n";  // quebra de linha
                Files.writeString(path, linha, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            System.out.println("Falha na gravação de arquivo!!");
        }
    }

}