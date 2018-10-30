/*
Escribe unha clase Conta para representar unha conta bancaria. Os datos da conta son: 
nome do cliente (String),
número de conta (String) 
saldo (double).

A clase conterá os seguintes métodos: 

Constructor por defecto

Constructor con todos os parámetros

Métodos setters/getters para asignar e obter os datos da conta.

Métodos ingreso e reintegro. Un ingreso consiste en aumentar o saldo na cantidade que se indique. 
Esa cantidade non pode ser negativa.

 Un reintegro consiste en diminuír o saldo nunha cantidade pero antes débese comprobar que hai saldo suficiente. A cantidade non pode ser negativa.
 Os métodos ingreso e reintegro devolven true si a operación púidose realizar ou false en caso contrario. 

O método visualizar que amosa todos os datos do cliente

Método transferencia que permita pasar diñeiro dunha conta a outra sempre que na conta de orixe haxa diñeiro suficiente para poder facela. Exemplo de uso do método transferencia:
cuentaOrigen.transferencia(cuentaDestino, importe);
que indica que queremos facer unha transferencia desde cuentaOrigen a cuentaDestino do importe indicado. 

 */
package prog_boletin_5;

import java.util.Scanner;

/**
 *
 * @author fsancheztemprano
 */
public class Cuenta {

    private String nombre;
    private String numCuenta;
    private double saldo;
    public static int cuentaTop=0;
    private static final String prefijoBanco = "ES";

    public Cuenta(){
        numCuenta = asignarCuenta();
    }

    public Cuenta(String nom, double sld){
        nombre = nom;
        saldo = sld;
        numCuenta = asignarCuenta();
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nom){
        nombre = nom;
    }
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double sld){
        saldo = sld;
    }
    public String getNumCuenta(){
        return numCuenta;
    }
    public static String asignarCuenta(){
        return (prefijoBanco +""+ ++cuentaTop);
    }
    public void ingreso(){
        double ingreso = Cuenta.introNum("Ingreso");
        saldo += ingreso;
    }
    public void reintegro(){
        double reintegro = Cuenta.introNum("Reintegro");
        if(saldo < reintegro){
            System.out.println("Saldo Insuficiente, saldo actual: " + saldo + ".");
        }else{            
            saldo += reintegro;
        }
    }
    /**
     * solicita introducir un numero por consola y luego verifica que dicho numero sea positivo
     * 
     * @param operacion tipo string para indicarque tipo de operacion vamos a realizar (ingreso, reintegro o transferencia)
     * @return devuelve el numero introducido por consola solo si es positivo, si no lo es lo vuelve a solicitar
     */
    public static double introNum(String operacion){
        Scanner scan = new Scanner(System.in);
        double num = 0;
        while(num <= 0){
            System.out.println(operacion +": Introduce un numero positivo:");
            num = scan.nextDouble();
        }
        return num;
     }
    
    public void visualizarCta(){
        System.out.println("Cuenta: " + numCuenta + "\nTitular: " + nombre + "\nSaldo: "+saldo);
    }
    
    public void transfer(Cuenta dest, double tr){
        System.out.println("Transferencia de la cuenta: "+ this.numCuenta + " a la cuenta :" + dest.numCuenta);
        System.out.println("Importe: "+ tr);
        if(this.saldo<tr){
            System.out.println("Saldo Insuficiente, saldo actual: " + saldo + ".");         
        }else{
            this.saldo -= tr;
            dest.saldo +=tr;
            
            System.out.println("Transferencia Exitosa.");
        }
        
    }
    


}
