
package miguelcoreas;

import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 * Nombre de la Clase: MiguelCoreas
 * Fecha: 19/04/2018
 * Version: 1.0
 * CopyRight: MiguelCoreas
 * @author Miguel Coreas
 */
public class MiguelCoreas {

    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        
        String nombre[] = new String [999];
        double salario[] = new double [999];
        double cantHoras[] = new double [999];
        double salarioC[] = new double [999];
        double salFinal[] = new double [999];
        double planilla[] = new double [999];
        
        int nIng = 0;
        int menu = 0;
        int cBonos = 0;
        int cSal=0;
        
        
        do{
            menu = Integer.parseInt(JOptionPane.showInputDialog(null," [1] - Agregar Empleado \n [2] - Calcular planilla \n [3] - Salir","Menu",1));
        switch(menu){
            case 1:
              nombre[nIng] = JOptionPane.showInputDialog(null,"Ingrese nombre del Empleado: ","Datos",1);
              salario[nIng] = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese Salario que gana por hora: ","Datos",1));
              cantHoras[nIng] = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese la cantidad de horas trabajadas : ","Datos",1));
              //Calculo de Salario por horas
              salarioC[nIng]=salario[nIng]*cantHoras[nIng];
              //Calculo de Planilla
              planilla[nIng]=salarioC[nIng]-(salarioC[nIng]*0.10);
              
              if(salarioC[nIng] > 0 && salarioC[nIng]<350)
              {
                  salFinal[nIng]=salarioC[nIng]+100;
                  cBonos=cBonos+100;
              }else if(salarioC[nIng]>350 && salarioC[nIng]<700)
              {
                  salFinal[nIng]=salarioC[nIng]+200;
                  cBonos=cBonos+200;
              }else if(salarioC[nIng]>=700)
              {
                  salFinal[nIng]=salarioC[nIng]+250;
                  cSal=cSal+1;
                  cBonos=cBonos+250;
              }
              
              nIng++;
              
            case 2:
                if(nIng>0)
                {
                for(int i=0; i<=nIng;i++)
                {
                JOptionPane.showMessageDialog(null,"Registro ["+i+1+"]\n"+
                                                   "Nombre: "+nombre[i]+
                                                "\n Salario: "+(nf,salarioC[i])+
                                                "\n Planilla: "+(nf,planilla[i])+
                                                "\n Salario Final(Con bonos y descuento): "+(nf,salFinal[i]),"Datos",1);
                }
                JOptionPane.showMessageDialog(null,"Cantidad total de bonos a pagar por la empresa: "+(nf,cBonos));
                JOptionPane.showMessageDialog(null,"Cantidad de Empleados que superan salarios de $700: "+cSal);
                }else
                {
                    JOptionPane.showMessageDialog(null,"Ingrese un registro antes",3);
                }
            default:
                
                if(menu!3)
                {
                JOptionPane.showMessageDialog(null,"Ingrese una opcion correcta",3);
                }
        }   
                
            
        }while(menu!=3);
    }
    
}
