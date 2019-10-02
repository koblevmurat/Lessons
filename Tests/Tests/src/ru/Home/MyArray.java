package ru.Home;

import java.util.Arrays;

public class MyArray  {
    private  int Size;
    private Object[] Arr;
    private int Current;


    public MyArray(int _Size) {
        this.Size = _Size;
        this.Arr = new Object[Size];
        this.Current = 0;
    }

    public MyArray() {
        this(100);
    }

    public boolean Add(Object el){
        if (this.Current < this.Size) {
            this.Arr[Current] = el;
            Current++;
            return true;
        }
        else
        {
            return false;
        }
    }
    private int IndexOf(Object el){
        for (int i = 0; i <= Current; i ++){
            if (Arr[i] == el)
            {return i;}
        }
        return -1;
    }
    public boolean Find(Object el)
    {
        if (IndexOf(el)>=0)
            return true;
        else
            return false;
    }

    public void Delete(Object el){
        int x = IndexOf(el);
        if (x >= 0){
            for (int i = x; i < Current; i++){
                Arr[i] = Arr[i+1];
            }
            Current--;
        }
    }

    public void PrintMyArray(){
        for (int i = 0; i < Current; i++) {
            System.out.println(Arr[i]);
        }
    }


}
