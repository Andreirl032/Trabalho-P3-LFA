//FEITO POR ANDREI RAMOS LOPES
import java.util.Scanner;


//Transformar AFN em extend do AFD futuramente???
public class AFN {
    //Atributos
    int[] estados;
    int estadoInicial;
    String[] programa;
    int[] estadosFinais;
    char []alfabeto;

    //Atributos da execução do autômato
    int contador;
    char[] palavra;

    //Construtores
    public AFN() {

    }
    public AFN(int[] estados, int estadoInicial, String[] programa, int[] estadosFinais) {
        this.estados = estados;
        this.estadoInicial = estadoInicial;
        this.programa = programa;
        this.estadosFinais = estadosFinais;
        MergeSort.mergeSort(this.estados,0,this.estados.length);
        MergeSort.mergeSort(this.programa,0,this.programa.length);
        MergeSort.mergeSort(this.estadosFinais,0,this.estadosFinais.length);
        this.alfabeto=gerarAlfabetoAPartirDeFuncaoPrograma(programa);
    }

    //Funções para geração de vetor contendo o alfabeto do autômato
    public int buscaBinariaRecursiva(
            char[] sortedArray, int key, int low, int high) {
        int middle = low  + ((high - low) / 2);

        if (high < low) {
            return -1;
        }

        if (key == sortedArray[middle]) {
            return middle;
        } else if (key < sortedArray[middle]) {
            return buscaBinariaRecursiva(
                    sortedArray, key, low, middle - 1);
        } else {
            return buscaBinariaRecursiva(
                    sortedArray, key, middle + 1, high);
        }
    }

    public int acharIndexLetraNaFuncaoPrograma(String programa){
        int index = -1;
        for(int i=0;i<programa.length();i++){
            if(programa.charAt(i)>='a' && programa.charAt(i)<='z'){
                index=i;
                break;
            }
        }
        return index;
    }

    public char[] gerarAlfabetoAPartirDeFuncaoPrograma(String[] programa){
        char[] alfabeto = new char[programa.length];
        int count=0;
        for(String s:programa){
            if(buscaBinariaRecursiva(alfabeto,s.charAt(acharIndexLetraNaFuncaoPrograma(s)),0,alfabeto.length)==-1){
                alfabeto[count++]=s.charAt(acharIndexLetraNaFuncaoPrograma(s));
            }
        }
        MergeSort.mergeSort(alfabeto,0,alfabeto.length);
        return alfabeto;
    }

    public int acharEstadoOrigem(String programa){
        return Integer.parseInt(programa.substring(0, acharIndexLetraNaFuncaoPrograma(programa) - 1));
    }

    public int acharEstadoAlvo(String programa){
        return Integer.parseInt(programa.substring(acharIndexLetraNaFuncaoPrograma(programa) + 1),programa.length());
    }

    //Getters e setters
    public int[] getEstados() {
        return estados;
    }

    public void setEstados(int[] estados) {
        this.estados = estados;
    }

    public int getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(int estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public String[] getPrograma() {
        return programa;
    }

    public void setPrograma(String[] programa) {
        this.programa = programa;
    }

    public int[] getEstadosFinais() {
        return estadosFinais;
    }

    public void setEstadosFinais(int[] estadosFinais) {
        this.estadosFinais = estadosFinais;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public char[] getPalavra() {
        return palavra;
    }

    public void setPalavra(char[] palavra) {
        this.palavra = palavra;
    }

    public char[] getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(char[] alfabeto) {
        this.alfabeto = alfabeto;
    }
}
