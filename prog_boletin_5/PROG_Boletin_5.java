/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog_boletin_5;

/**
 *
 * @author fsancheztemprano
 */
public class PROG_Boletin_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuenta cta1 = new Cuenta();
        Cuenta cta2 = new Cuenta("nombre2", 200);
        Cuenta cta3 = new Cuenta("nombre3", 300);
        Cuenta cta4 = new Cuenta("nombre4", 400);
        
        cta3.visualizarCta();
        cta4.visualizarCta();
        
        cta4.transfer(cta3, Cuenta.introNum("Transferir a la cuenta :" + cta3.getNumCuenta()));
        
        cta3.visualizarCta();
        cta4.visualizarCta();
        
        
    }
    
}
