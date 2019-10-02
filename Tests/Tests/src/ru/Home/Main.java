package ru.Home;

//package Tests;

//import com.sun.tools.javac.util.ArrayUtils;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.stream.*;




public class Main {

    private static void Write(Object[] _cities){
        File fl = new File("output.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fl));
            for (Object ct :
                    _cities) {
                bw.write(ct.toString());
                bw.newLine();
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static ArrayList<String> ReadFile(String _file){

        ArrayList<String> AL_Cities = new ArrayList<>();
        File fl = new File(_file);

        if (fl.canRead()){
            try {
                BufferedReader br = new BufferedReader(new FileReader(fl));
                String ln;
                while ((ln = br.readLine())!= null)
                {
                    AL_Cities.add(ln);
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return AL_Cities;
    }

    private static void CheckLetters(char[] _arrA, char[] _arrB, ArrayList<String> _Al_Cities, HashSet<String> _hs_Cities ){
        String StrArrA = new String (_arrA);
        for (int i=0; i<_arrA.length ;i++) {
            //int x = Arrays.binarySearch(_arrA, _arrB[i]);
           // int x = Arrays.asList(_arrA).indexOf(_arrB[i]);
            // _arrA.
            int x = StrArrA.indexOf(_arrB[i]);
            

            if (x != i && x >= 0){
                String city = _Al_Cities.get(x);
                _hs_Cities.add(city);
            }
        }
    }

    private static Object[]  FaceControl ( ArrayList<String> _Al_Cities) {

        //ArrayList<String> ReturnCities = new ArrayList<>();
        HashSet<String> hs_Cities = new HashSet<>();

        int LoopSize = _Al_Cities.size();
        char [] arrFL = new char[LoopSize];
        char[] arrLL = new char[LoopSize];

        for (Integer i = 0; i < LoopSize; i++) {
            String city = _Al_Cities.get(i);
            arrFL[i] = city.toLowerCase().charAt(0);//)toCharArray()[0];
            arrLL[i] = city.toCharArray()[city.length()-1];
        }
        /*Arrays.sort(arrLL);
        Arrays.sort(arrFL);*/
        //Arrays.binarySearch(arrFL, arrLL[0]);
        CheckLetters(arrFL, arrLL, _Al_Cities, hs_Cities);
        CheckLetters(arrLL, arrFL, _Al_Cities, hs_Cities);

        return hs_Cities.toArray();
    }

    private void RunArrTest01(){
        System.out.println("Hello world");
        String path = "C:\\Users\\User\\Desktop\\input.txt";

        ArrayList<String> AL_Cities = new ArrayList<>();
        AL_Cities.add("London");
        AL_Cities.add("Niderland");
        AL_Cities.add("Daniya");
        AL_Cities.add("Argentina");
        AL_Cities.add("Moscow");
        Object[] Cities = FaceControl(AL_Cities);
        for (Object city :
                Cities) {
            System.out.print(city.toString());
        }
    }

    private static void RunSortBuble(int[] arr){

        int O = 0;
        for (int i = 0; i < arr.length; i ++){
            O++;
            for (int j = i+1; j < arr.length; j++){
                O++;
                if (arr[i] < arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                 }
            }
        }

        System.out.println("Number of iterations = "+O);
    }


    private static void RunSortMeth2(int[] arr){

        int O = 0;

        for (int i = 1; i < arr.length; i ++) {
            O++;
            for (int j = i; j > 0; j --) {
                O++;
                if (arr[j] > arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }



        System.out.println("Number of iterations = "+O);
    }

     private static  void RunSortMeth3(int[] arr){

        int O = 0;
        for (int i = 0; i < arr.length; i ++){
            int tmp, out = 0, mark;
            mark = arr[i];

            for (int j = i+1; j < arr.length; j++){
                O ++;
                if (arr[j] < mark){
                    mark = arr[j];
                    out = j;
                }
            }
            O ++;
            tmp = arr[i];
            arr[out] = tmp;
            arr[i] = mark;

        }


         System.out.println("Number of iterations = "+O);
    }

    private static void PrintArr(int [] arr){
        for (int i = 0; i < arr.length; i ++){
            System.out.println(arr[i]);
        }
    }

    private static void EstimateSort(int _meth, int[] arr) {
        Date dtStart = new Date();
        System.out.println(dtStart);
        if (_meth == 1) {
            RunSortBuble(arr);
        } else if (_meth == 2) {
            RunSortMeth2(arr);
        } else if (_meth == 3) {
            RunSortMeth3(arr);
        }
        Date dtEnd = new Date();
        System.out.println(dtEnd);
        System.out.println(dtEnd.getTime() - dtStart.getTime() + " milliseconds");
    }


    public static void main(String[] args) {

        int[] arr1 = new int[1000];
        for (int i = 0; i < arr1.length; i ++){
            arr1[i] = (int) (Math.random() * 1000);
        }
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();

        System.out.println("Пузырьковый метод");
        EstimateSort(1, arr1);
        System.out.println("Метод выбора");
        EstimateSort(2, arr2);
        System.out.println("Метод вставки");
        EstimateSort(3, arr3);

        MyArray myArray = new MyArray(10);
        myArray.Add("Hello");
        myArray.Add("Hello2");
        myArray.Add("Hello3");
        myArray.PrintMyArray();
        System.out.println("Элемент с именем \"Hello3\" есть? "  +myArray.Find("Hello3"));
        myArray.Delete("Hello3");
        System.out.println("Элемент с именем \"Hello3\" есть? "  +myArray.Find("Hello3"));
        myArray.PrintMyArray();
      /*  PrintArr(arr1);
        PrintArr(arr2);
        PrintArr(arr3);*/
    }
}
