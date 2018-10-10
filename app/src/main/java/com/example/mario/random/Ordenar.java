package com.example.mario.random;
import java.util.Random;
public class Ordenar {

        private int arraySize = 5;
        private int[] theArray = new int[30];
        public String listaInicial="";
        public String listaBubble="";
        public int contador =0;
        Random random = new Random();


        public void generateRandomArray(){
            for(int i = 0; i < arraySize; i++){
                theArray[i] = (int)(Math.random()*10)+10;
            }
            for (int i = 0; i < 5; i++) {
                theArray[i] = random.nextInt(100);
            }
            for (int i =0; i<theArray.length;i++) {
                this.listaInicial += String.valueOf(theArray[i]);
            }
        }
        public void printHorzArray(int i, int j){
            for(int n = 0; n < 30; n++){
                System.out.print("-");
            }
            System.out.println();
            for(int n = 0; n < arraySize; n++){
                System.out.print("| " + n + "  ");
            }
            System.out.println("|");
            for(int n = 0; n < 30; n++)System.out.print("-");
            System.out.println();
            for(int n = 0; n < arraySize; n++){
                System.out.print("| " + theArray[n] + " ");
            }
            System.out.println("|");
            for(int n = 0; n < 30; n++)System.out.print("-");
            System.out.println();
            if(j != -1){
                for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");
                System.out.print(j);
            }
            if(i != -1){
                for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");
                System.out.print(i);
            }
            System.out.println();
        }
        public void bubbleSort(){
            for(int i = arraySize - 1; i > 1; i--){
                for(int j = 0; j < i; j++){
                    if(theArray[j] > theArray[j + 1]){
                        contador++;
                        swapValues(j, j+1);
                        printHorzArray(i, j);
                        listaBubble +=String.valueOf(theArray);
                    }
                    else{
                        contador++;
                    }
                }
            }
            System.out.println("Complejidad: "+contador);
        }
        public void swapValues(int indexOne, int indexTwo){

            int temp = theArray[indexOne];
            theArray[indexOne] = theArray[indexTwo];
            theArray[indexTwo] = temp;

        }
        public static void main(String[] args){
            Ordenar newArray = new Ordenar();
            newArray.generateRandomArray();
            newArray.printHorzArray(-1,-1);
            newArray.bubbleSort();
        }
    }
