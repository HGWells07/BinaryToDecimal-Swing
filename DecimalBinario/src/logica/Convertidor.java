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
