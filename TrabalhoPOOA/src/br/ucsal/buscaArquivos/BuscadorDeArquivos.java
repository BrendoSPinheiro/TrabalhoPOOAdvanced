package br.ucsal.buscaArquivos;

import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BuscadorDeArquivos {

	private static Scanner input = new Scanner(System.in);
	private static Scanner scop = new Scanner(System.in);

	public static void main(String[] args) throws IOException{

		//procuraDuplicados();

		long tempoi = System.currentTimeMillis();
		procuraArquivo();
		System.out.println("Execução demorou: " + (System.currentTimeMillis() - tempoi));

		/*Path dir = Paths.get("/Users/leonardoalvarenga/eclipse-workspace/TrabalhoPOOAvan-ado");
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o nome do arquivo que deseja buscar: ");
		String nomeArquivo = input.nextLine();
		NavegacaoDeDiretorios navDir = new NavegacaoDeDiretorios(nomeArquivo);
		Files.walkFileTree(dir, navDir);

		input.close();*/

		/*int op = 0;

		while(op != 9) {
			System.out.println("------------------------------MENU----------------------------");
			System.out.println("|                                                            |");
			System.out.println("|    1 - Procurar por arquivos duplicados no diretório       |");
			System.out.println("|    2 - Procurar por um arquivos específico no diretório    |");
			System.out.println("|                                                            |");
			System.out.println("|    9 - sair                                                |");
			System.out.println("|                                                            |");
			System.out.println("--------------------------------------------------------------");
			System.out.print("Escolha uma das opções acima: ");


			op = scop.nextInt();

			switch (op) {
				case 1:
					procuraDuplicados();
					break;
				case 2:
					procuraArquivo();
					break;
				default:
					System.out.println("Opção inválida");
					break;
			}


		}*/
	}

	private static void procuraArquivo() throws IOException {
		System.out.println("Digite o endereço do diretório que deseja pesquisar:");
		String enderecoDir = input.nextLine();
		Path dir = Paths.get(enderecoDir);
		System.out.println("Informe o nome do arquivo que deseja buscar: ");
		String nomeArquivo = input.nextLine();
		NavegacaoDeDiretoriosPorNome navDir = new NavegacaoDeDiretoriosPorNome(nomeArquivo);
		Files.walkFileTree(dir, navDir);
		System.out.println("terminou");

		input.close();
	}

	private static void procuraDuplicados() throws IOException {
		System.out.println("Digite o endereço do diretório que deseja pesquisar:");
		String enderecoDir = input.nextLine();
		Path dir = Paths.get(enderecoDir);
		NavegacaoDeDiretorios navDir = new NavegacaoDeDiretorios(dir);
		Files.walkFileTree(dir, navDir);

		System.out.println(ListaArquivosSingleton.lista.size());
		if(ListaArquivosSingleton.lista.size() > 0)
			for (String arquivo: ListaArquivosSingleton.lista) {
				System.out.println(arquivo);
			}



		input.close();
	}
}
