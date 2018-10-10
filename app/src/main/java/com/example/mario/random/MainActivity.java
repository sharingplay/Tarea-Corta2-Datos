package com.example.mario.random;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private TextView display2;
    private TextView display3;
    private TextView display4;
    private TextView display5;

    private int valor;
    private int compBubble;
    private static int compQuick;
    private String listaTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.textoV);
        display2 = findViewById(R.id.BubbleView);
        display3 = findViewById(R.id.compBubb);
        display4 = findViewById(R.id.QuickView);
        display5 = findViewById(R.id.compQuick);

    }
    public void Main(View view) {
        int size=5;
        int[] lista = new int[size];
        int[] lista2 = lista;
        //int[] inverso = {5,4,3,2,1};
        Random random = new Random();
        String listaFinal = "";
        String listaOrd = "";
        String listaOrd2 = "";
        for (int i = 0; i < size; i++) {//llena la lista con numeros aleatorios
            valor = random.nextInt(100);
            lista[i] = valor;
            listaFinal = listaFinal + String.valueOf(lista[i]) + ',';
        }
        //insertionSort(lista2);
        bubbleSort(lista);
        for (int j = 0; j < size; j++) {
            listaOrd = listaOrd + String.valueOf(lista[j]) + ',';
        }
        display.setText("Lista Desordenada: "+listaFinal);
        for (int k = 0; k < size; k++) {
            listaOrd2 = listaOrd2 + String.valueOf(lista2[k]) + ',';
        }
        //display3.setText(listaOrd2);
        QuickSort(lista);

    }

    public void bubbleSort(int[] arr) {
        int temp;
        compBubble = 0;
        listaTotal = "";
        for (int i = 0; i < arr.length; i++) {
            compBubble ++;
            for (int j = 1; j < (arr.length - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    compBubble ++;
                    //swap elementos
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
                compBubble ++;
                listaTotal+=concatenar(arr)+"\n";
            }
        }
        display2.setText(listaTotal);
        display3.setText("Comparaciones: "+String.valueOf(compBubble));
    }
    public String concatenar(int[]arr) {
        String temporal = "";
        for (int n = 0; n < arr.length; n++) {
            temporal += (arr[n] + ",");
        }
        return temporal;
    }

    public void QuickSort(int array[]) {
            compQuick=0;
            int low = 0;
            int high = array.length - 1;
            quickSort(array, low, high);
            listaTotal+=concatenar(array);
            display4.setText(listaTotal);
            display5.setText("Comparaciones: "+String.valueOf(compQuick));

        }

        public static void quickSort(int[] arr, int low, int high) {
            compQuick++;
            if (arr == null || arr.length == 0)
                return;

            if (low >= high)
                return;
            compQuick++;
            // pick the pivot
            int middle = low + (high - low) / 2;
            int pivot = arr[middle];

            // make left < pivot and right > pivot
            int i = low, j = high;
            while (i <= j) {
                compQuick++;
                while (arr[i] < pivot) {
                    compQuick++;
                    i++;
                }

                while (arr[j] > pivot) {
                    compQuick++;
                    j--;
                }

                if (i <= j) {
                    compQuick++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
            }

            // recursively sort two sub parts
            if (low < j)
                compQuick++;
                quickSort(arr, low, j);

            if (high > i)
                compQuick++;
                quickSort(arr, i, high);
        }
    }
