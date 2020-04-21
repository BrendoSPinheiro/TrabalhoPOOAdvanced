package br.ucsal.buscaArquivos;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class NavegacaoDeDiretorios extends SimpleFileVisitor<Path>{
	
	private String arquivo = "";
	
	public NavegacaoDeDiretorios(String nomeArquivo) {
		this.arquivo = nomeArquivo.toUpperCase();
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		String arquivoSistema = file.getFileName().toString().toUpperCase();
		if(arquivoSistema.endsWith(arquivo)) {
			System.out.println("nome do arquivo: "+arquivoSistema);
			System.out.println("Diretório do arquivo: "+file.toAbsolutePath());
		}
		return FileVisitResult.CONTINUE;	
	}
}
