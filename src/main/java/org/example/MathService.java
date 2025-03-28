package org.example;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.ArrayList;

public class MathService {

    public static void main(String[] args){
        createSequence(5);
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

        return null;
    }
}
