package org.example;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.ArrayList;

public class MathService {

    public static void main(String[] args){
        // aca se deberia ejecutar el metodo createSequence
        // y posteriormente convertirlo en Json
    }

    private static ArrayList<Integer> createSequence(int number){
        ArrayList<Integer> sequence = new ArrayList<>();
        sequence.add(number);
        while (number != 1){
            if(number % 2 == 0){
                number = number / 2;
            } else {
                number = (3 * number) + 1;
            }
            sequence.add(number);
        }
        return sequence;
    }

    private static JSONPObject createJson(){
        // En este metodo el ideal es que pasar el ArrayList obtenido en CreateSequence a Json
        // En este caso no lo implemente debido a a problemas con el Json
        return null;
    }
}
