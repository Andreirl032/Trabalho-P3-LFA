import java.util.Hashtable;

//FEITO POR ANDREI RAMOS LOPES
public class AFNparaAFD {
    //Atributos
    AFN automato;
    //Construtor
    public AFNparaAFD(AFN automato) {
        this.automato = automato;
    }

    public static void main(String[] args) {

    }

    AFD converterAFNParaAFD(AFN automatoND){
        AFD automatoD = new AFD();
        Hashtable <String[],String[]> tabelaAFN = new Hashtable<>();
        for(int i:automatoD.getEstados()){
            for(char j:automatoD.getAlfabeto()) {
                String[] keys = {String.format("%d",i),String.format("%c",j)};
                int values_count=0;
                String[] values = new String[automatoD.getPrograma().length];
                for(int k=0;k<automatoD.getPrograma().length;k++){
                    if(automatoD.acharEstadoOrigem(automatoD.getPrograma()[k])==i){
                    values[values_count++]=String.format("%d",automatoD.acharEstadoAlvo(automatoD.getPrograma()[k]));
                    }
                }
                tabelaAFN.put(keys,values);
            }
        }
        return automatoD;
    }
}
