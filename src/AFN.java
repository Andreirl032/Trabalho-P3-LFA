//FEITO POR ANDREI RAMOS LOPES
import java.util.Scanner;

public class AFN {
    int contador;
    char[] palavra;

    public AFN() {
    }

    public AFN(int contador, char[] palavra) {
        this.contador = contador;
        this.palavra = palavra;
    }

    public static void main(String[] args) {
        while(true){
        AFN automato = new AFN();
        String sentenca;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Entre com a sentença: ");
        sentenca = entrada.nextLine();
        automato.palavra=sentenca.toCharArray();
        if(funcao(automato.palavra, 1,0)){
            System.err.println("PALAVRA ACEITA PELO AUTÔMATO");
        } else{
            System.err.println("PALAVRA REJEITADA PELO AUTÔMATO");
        }
        }
    }

    static boolean funcao(char[] curChar, int curState,int count) {
        boolean afnd = false;
        if (curChar == null || (count>=curChar.length && curState!=4)) {
            return false;
        }

        switch (curState) {
            case 1:
                switch (curChar[count]) {
                case 'a':
                    afnd = funcao(curChar, 2,++count);
                    if (!afnd) {
                        return funcao(curChar, 1,++count);
                    }
                    return afnd;
                case 'b':
                    return funcao(curChar, 1,++count);
            }
            return false;
            case 2:
                switch (curChar[count]) {
                case 'a':
                    return funcao(curChar, 3,++count);
                case 'b':
                    return funcao(curChar, 3,++count);
            }
            return false;
            case 3:
                switch (curChar[count]) {
                case 'a':
                    return funcao(curChar, 4,++count);
            }
            return false;
            case 4:
                if(count>=curChar.length){
                    return true;
                }
                switch (curChar[count]) {
                case 'a':
                    return true;
                case 'b':
                    return true;
            }
            return false;
        }
        return false;
    }


}
