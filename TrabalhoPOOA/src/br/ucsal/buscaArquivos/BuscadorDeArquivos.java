package br.ucsal.buscaArquivos;

import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BuscadorDeArquivos {
	public static void main(String[] args) throws IOException{
		Path dir = Paths.get("C:\\Users\\brend\\OneDrive");
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o nome do arquivo que deseja buscar: ");
		String nomeArquivo = input.nextLine();
		
		NavegacaoDeDiretorios navDir = new NavegacaoDeDiretorios(nomeArquivo);
		Files.walkFileTree(dir, navDir);
		
		input.close();
	}
}
