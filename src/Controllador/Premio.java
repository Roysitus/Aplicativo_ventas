
package Controllador;

public class Premio {
    
    public String premio(double monto_comprado){
        if(monto_comprado>=3000 && monto_comprado<=10000){
            return "Tiene como Premio : iPhone 10 S";
        }else if(monto_comprado>10000){
            return "Tiene como Premio : MackBookProo";
        }else{
            return "No tiene premio aun";
        }
    }
    
}
