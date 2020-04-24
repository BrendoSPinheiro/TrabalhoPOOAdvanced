package br.ucsal.buscaArquivos;

import java.util.ArrayList;

public class ListaArquivosSingleton {

    public static ArrayList<String> lista = new ArrayList<String>();

    public static final ListaArquivosSingleton INSTANCE = new ListaArquivosSingleton();

    private ListaArquivosSingleton() {

    }
}
