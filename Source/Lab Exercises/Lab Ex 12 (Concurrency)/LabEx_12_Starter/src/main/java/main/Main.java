package main;

import java.text.NumberFormat;
import java.util.List;


import IO.FileIO;
import model.Name;


public class Main {

    static NumberFormat nf = NumberFormat.getPercentInstance();

    public static void main(String[] args) {

        List<Name> list = FileIO.parseFile("CA.txt");

        list.forEach(System.out::println);

    }
}





