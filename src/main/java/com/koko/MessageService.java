package com.koko;


import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MessageService {


}

class Super{
    public int index=1;
}
class App extends Super {
    public App(int index) {
        index = index;
    }

    public static void main(String[] args) {
        int val=10;
        if((val>10? val++: --val)<10){
            System.out.print("MAC");
        }
        if(val<10){
            System.out.print("PC");
        }
    }
}



