package br.ucsal.buscaArquivos;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class NavegacaoDeDiretoriosPorNome extends SimpleFileVisitor<Path>{

    private String arquivo = "";
    private ArrayList<String> lista = new ArrayList<String>();

    public NavegacaoDeDiretoriosPorNome(String nomeArquivo) {
        this.arquivo = nomeArquivo.toUpperCase();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

        Thread t1 = new Thread(() -> {

            String arquivoSistema = file.getFileName().toString().toUpperCase();
            if(arquivoSistema.contains(arquivo)) {
                System.out.println("nome do arquivo: "+arquivoSistema);
                System.out.println("Diretório do arquivo: "+file.toAbsolutePath());
                lista.add("nome do arquivo: "+arquivoSistema +" --- Diretório do arquivo: "+file.toAbsolutePath());
            }
        }, arquivo);

        t1.start();


        return FileVisitResult.CONTINUE;

    }
}