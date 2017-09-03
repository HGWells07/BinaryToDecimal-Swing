/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Charly Anguiano
 */
public class Convertidor {
    
    /**
     * <h1>decimalABinario</h1>
     * 
     * Transforma números de decimal a un String equivalente a su binario
     * 
     * @param decimal Entero que se quiere transformar a binario
     * @return resultado Cadena de texto de 1 y 0s que representa al decimal en binario
     */
    public String decimalABinario(int decimal){
        ArrayList<Integer> binArray = new ArrayList<>();
        String resultado = "";
        while (decimal > 0){
            binArray.add(decimal % 2);
            decimal /= 2;
        }
        Collections.reverse(binArray);
        for (int temp: binArray){
            resultado += String.valueOf(temp);
        }
        return resultado;
    }
    
    /**
     * <h1>decimalABinario</h1>
     * 
     * Toma un binario en String y en base a sus valores en cada posición
     * crea un valor numérico
     * 
     * @param binario binario que se quiere convertir a string
     * @return resultado Resultado decimal del binario
     * @throws java.lang.Exception Indica que la String que se pasó no es binrio
     */
    public int binarioADecimal(String binario) throws Exception{
        ArrayList<Integer> binarioList = new ArrayList<>();
        
        for (char temp: binario.toCharArray()){
            binarioList.add(Character.getNumericValue(temp));
        }
        Collections.reverse(binarioList);
        int resultado = 0;
        for (int i=0; i<binarioList.size(); i++){
            if(binarioList.get(i)!=1 && binarioList.get(i)!=0){
                throw new Exception();
            }
            if(binarioList.get(i) == 1){
                resultado += Math.pow(2, i);
            }
        }
        return resultado;
    }
    
}
