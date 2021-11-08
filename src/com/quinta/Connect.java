package com.quinta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Connect {
    Socket sk;
    PrintStream pr;
    Cifrario cf=new Cifrario();
    BufferedReader p;
    public Connect(){
        try {
            sk=new Socket("127.0.0.1",80);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void k(){
        Scanner s=new Scanner(System.in);
        System.out.println("Inserire la chiave per il quale cifrare");
        cf.setChiave(s.nextInt());
    }

    public void send(){
        try {
            p=new BufferedReader(new InputStreamReader(sk.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("Inserire un messaggio..");
        String msg=sc.nextLine();
        cf.setParola(msg);
        msg=cf.cifraCes();
        try {
            pr=new PrintStream(sk.getOutputStream());
            pr.println(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(p.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Sent."+ msg);
        sc.close();
    }









}
