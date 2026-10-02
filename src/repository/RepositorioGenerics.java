package repository;

import model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class RepositorioGenerics<T> {

    //Lista do tipo Generica(Recebe qualquer tipo)
    private final List<T> listaElementos = new ArrayList<>();

    //Adicionar elementos a Lista Generica
    public void adicionarElemento(T elemento){
        listaElementos.add(elemento);
    }

    //ADICIONAR TODOS OS ELEMENTOS DE UMA LISTA GENERICA(? extends T)
    public void adicionarTodosElementos(List<? extends T> elementos){
        listaElementos.addAll(elementos);
    }

    //Lista uma cópia da lista original dos elementos
    public List<T> listarElementos(){
        return new ArrayList<>(listaElementos);
    }

    // Remover elemento da lista
    public boolean removerElemento(T elemento){
        return listaElementos.remove(elemento);
    }

    //Retorna lista caso for vazia
    public boolean listaVazia(){
        return listaElementos.isEmpty();
    }

    //Retorna tamanho da lista
    public int tamanhoLista(){
        return listaElementos.size();
    }

    //Metodo generico: Transfere uma lista para outra lista
    public static <T> void copiarListaPara(List<? extends T> origem, List<? super T> destino){
        destino.addAll(origem);
    }

    //Total de elementos da lista
    public static void exebirQuantidadeLista(List<?> lista){
        System.out.println("Quantidade de items da lista: " + lista.size());
    }
}
