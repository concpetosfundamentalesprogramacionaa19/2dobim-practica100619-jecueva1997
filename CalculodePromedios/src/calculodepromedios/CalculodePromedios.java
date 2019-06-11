/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculodepromedios;

import java.io.File;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author jecueva1997
 */
public class CalculodePromedios {
    public static void leerRegistros() {
        try // lee registros del archivo, usando el objeto Scanner
        {
            Scanner entrada = new Scanner(new File("data/tabula-FWC_2018_"
                    + "Squadlists_4.csv"));
            // Declaracion de variables
            double sumaheight = 0;
            double sumagoals = 0;
            float a = 0;
            double promheight = 0;
            double promgoals = 0;
            // Utilizacion del ciclo while
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                // System.out.println(linea);
                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split("\\|")));
                double dato = Double.parseDouble(linea_partes.get(9));
                double dato1 = Double.parseDouble(linea_partes.get(11));
                // Se esta calculando la suma de Height
                sumaheight = sumaheight + dato;
                // Se esta calculando la suma de Goals
                sumagoals = sumagoals + dato1;
                a++;
                
            } 
            entrada.close();
            // Se calcula el promedio de Height
            promheight = sumaheight/a;
            // Se calcula el promedio de Goals
            promgoals = sumagoals/a;
            // Presentacion de datos
            System.out.printf("El promedio Height es: %.2f\nEl promedio de "
                    + "Goals es: %.2f", promheight, promgoals);
        }
        catch (Exception e) {
            // Mensaje por si este leyebdo mal el archivo
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        }
    } 
}
