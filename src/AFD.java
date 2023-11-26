//FEITO POR ANDREI RAMOS LOPES
import java.util.Scanner;

public class AFD {
    int contador;
    char[] palavra;

    public static void main(String[] args) {
        AFD automato = new AFD();
        String sentenca;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Entre com a sentença: ");
        sentenca = entrada.nextLine();
        automato.palavra=sentenca.toCharArray();
        automato.iniciar();
    }

    public void iniciar(){
        this.contador=0;
        q0();
    }
    public void q0(){
        if(contador<palavra.length){
            if(palavra[contador]=='a'){
                contador++;
                q1();
            }
            else if(palavra[contador]=='c'){
                contador++;
                qf();
            }
            else{
                qErro();
            }
        } else{
            qErro();
        }
    }
    public void q1(){
        if(contador<palavra.length){
            if(palavra[contador]=='b'){
                contador++;
                q2();
            }
            else{
                qErro();
            }
        } else{
            qErro();
        }
    }
    public void q2(){
        if(contador<palavra.length){
            if(palavra[contador]=='b'){
                contador++;
                q0();
            }
            else{
                qErro();
            }
        } else{
            qErro();
        }
    }
    public void qf(){
        System.err.println("PALAVRA ACEITA PELO AUTOMATO!");
    }
    public void qErro(){
        System.err.println("PALAVRA REJEITADA PELO AUTOMATO!");
    }
}
