/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_eduardovaldez;
//fila 1 asiento 8
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author guali
 */
public class Lab1P2_EduardoValdez {

    static Random rand = new Random();
    static Scanner leer = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Ingrese el tamaño de la matriz: ");
        int size = leer.nextInt();
        int matrix[][] = generarmatriz(size);
        if (size > 4 && size % 2 != 0) {
            imprimir(matrix);
            System.out.println("\nMatriz Ordenada");
            matrix=ordenarmatriz(matrix);
            imprimir(matrix);
            System.out.println("\nArreglo de Medianas");
            ArrayList<Integer>list = new ArrayList<>();
            list = medianas(matrix);
            imprimir2(list);
            System.out.println("\nOrdenamiento de Mediana");
            bubblesort2(list,0);
            imprimir2(list);
            System.out.println("\nMediana de Medianas");
            int num = meddemed(list);
            System.out.println(num);

        } else {
            System.out.println("El tamaño debe ser mayor a 4, y debe ser un numero impar");
        }
        
        

    }
    public static void bubblesort(int[] arreglo,int n) {
        int num1 = 0;
        int num2 = 0;
        if(n<arreglo.length){
            for (int j = 0; j < arreglo.length-1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    num1 = arreglo[j];
                    num2 = arreglo[j + 1];
                    arreglo[j] = num2;
                    arreglo[j + 1] = num1;
                }
            
        }
            bubblesort(arreglo,n+1);
        }
       

    }
        public static void bubblesort2(ArrayList<Integer> list,int n) {
        int num1 = 0;
        int num2 = 0;
        if(n<list.size()) {
            for (int j = 0; j < list.size()-1; j++) {
                if (list.get(j) > list.get(j+1)) {
                    num1 = list.get(j);
                    num2 = list.get(j+1);
                    list.set(j, num2);
                    list.set(j+1, num1);
                }
            }
            bubblesort2(list,n+1);
        }

    }
    //calcular mediana de medianas
    public static int meddemed (ArrayList<Integer> lista){
        int numero = 0;
        for(int i = 0; i<lista.size();i++){
            if(i==lista.size()/2){
               numero = lista.get(i);
            }
        }
        return numero;
    }
    
    //llenar arraylist de medianas
    public static ArrayList<Integer> medianas (int [][] matriz){
        ArrayList<Integer> list = new ArrayList<>();
        int tam = matriz.length/2;

        for(int i = 0; i<matriz.length;i++){
            for(int j = 0; j<matriz.length;j++){
                if(j==tam){
                   int num = matriz[i][j];
                   list.add(num);
                }
            }
        }
        return list;
        
    }
    
    //ordenar matriz con bubblesort
    public static int[][]ordenarmatriz(int[][] a){
        int[][]matriz = new int [a.length][a.length];
        for(int i = 0 ; i<a.length;i++){
            int []array = new int [a.length];
            for(int j = 0 ; j<a.length;j++){
               array[j] = a[i][j]; 
               
            }
            bubblesort(array,0);
               for(int n = 0; n <a.length;n++){
                   matriz[i][n]=array[n];
               }
            
        }
        return matriz;
    }
    
    //generar la matriz
    public static int[][] generarmatriz(int tamaño) {
        int matriz[][] = new int[tamaño][tamaño];
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                int numero = rand.nextInt(10);
                matriz[i][j] = numero;
            }
        }
        return matriz;
    }
    
//imprimir la matriz
    public static void imprimir(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println();
        }
    }

    //imprimir el arraylist
    public static void imprimir2(ArrayList<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.print("[" + lista.get(i) + "]");
        }
    }
    

    


}
