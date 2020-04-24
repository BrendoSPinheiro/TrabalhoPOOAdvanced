package br.ucsal.buscaArquivos;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class NavegacaoDeDiretorios extends SimpleFileVisitor<Path> {

	private String arquivo = "";
	Path dir;

	private ArrayList<String> lista = new ArrayList<String>();


	public NavegacaoDeDiretorios(Path dir) {

		this.dir = dir;
	}

	public NavegacaoDeDiretorios(String nomeArquivo) {
		this.arquivo = nomeArquivo.toUpperCase();
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

		/*String arquivoSistema = file.getFileName().toString().toUpperCase();
		if(arquivoSistema.endsWith(arquivo)) {
			System.out.println("nome do arquivo: "+arquivoSistema);
			System.out.println("Diret�rio do arquivo: "+file.toAbsolutePath());
		}
		return FileVisitResult.CONTINUE;*/

		Thread t1 = new Thread(() -> {

		},"t1");

		t1.start();

		if(this.arquivo.length() > 0){
			String arquivoSistema = file.getFileName().toString().toUpperCase();
//			System.out.println(arquivoSistema);
//			System.out.println(arquivo);
//			System.out.println(file.toAbsolutePath());
			if(arquivoSistema.equals(arquivo)) {
				//System.out.println("ta igual");
				this.lista.add("nome do arquivo: "+arquivoSistema+ " --- " + "Diret�rio do arquivo: "+file.toAbsolutePath());

				if(lista.size()>1)
					for (String arquivo: lista) {

						if(!ListaArquivosSingleton.lista.contains(arquivo)){
							ListaArquivosSingleton.lista.add(arquivo);
						}

					}

				//System.out.println("-----------------ADICIONADO-------------------------");
			}
			return FileVisitResult.CONTINUE;

		} else {

			String arquivoSistema = file.getFileName().toString().toUpperCase();

			Thread novaThread = new Thread(() -> {
				NavegacaoDeDiretorios novo = new NavegacaoDeDiretorios(arquivoSistema);
				try {
					Files.walkFileTree(this.dir ,novo);
				} catch (IOException e) {
					e.printStackTrace();
				}
			},arquivoSistema);

			novaThread.start();

			try {
				novaThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			return FileVisitResult.CONTINUE;
		}

	}
}
