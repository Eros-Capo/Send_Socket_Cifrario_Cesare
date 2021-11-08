package com.quinta;

public class Cifrario {

    private String alfabeto="ABCDEFGHIJKLMNOPQRSTUV";
    private String parola;
    private int chiave;

    public Cifrario(){ }

    public void setParola(String parola) {
        parola = parola.toUpperCase();
        this.parola=parola.replaceAll(" ","");
    }

    public void setChiave(int chiave) {
        this.chiave = chiave;
    }

    public String cifraCes(){
        int temp=0;
        String cifrato="";
        for (int i=0;i<parola.length();i++) {
            temp=(int)parola.charAt(i)+chiave;
            if (temp>=90){
                temp-=26;
            }
            cifrato+=(char)temp;
        }
        return cifrato;
    }
}
