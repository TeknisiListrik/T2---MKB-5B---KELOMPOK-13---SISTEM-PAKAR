package com.mycompany.sistempakar;
import java.util.*;


public class UI {
    
    private final ArrayList<String> questions;
    private final int answers[];
    
    public UI()
    {
        this.answers = new int[12];
        this.questions = new ArrayList<>();
        this.setQuestions();
    }
    
    private void setQuestions()
    {
        //Q1
        questions.add("Apakah tanaman anda mengalami pertumbuhan yang terhambat?");
        //Q2
        questions.add("Apakah tanaman anda mengalami pembentukan tongkol terganggu?");
        //Q3
        questions.add("Apakah tanaman anda mengalami beberapa bintik kecil bersatu membentuk bintik besar?");
        //Q4
        questions.add("Apakah tanaman anda mengalami bintik-bintik coklat muda memanjang dalam bentuk kumparan?");
        //Q5
        questions.add("Apakah tanaman anda mengalami bintik-bintik merah di pelepah?");
        //Q6
        questions.add("Apakah tanaman anda mengalami benang berbentuk tidak beraturan yang berwarna putih dan kemudian coklat?");
        //Q7
        questions.add("Apakah tanaman anda mengalami biji membengkak?");
        //Q8
        questions.add("Apakah tanaman anda mengalami kelobot terbuka dan banyak terdapat miselium jamur berwarna putih sampai hitam?");
        //Q9
        questions.add("Apakah tanaman anda mengalami terdapat lubang kecil pada daun?");
        //Q10
        questions.add("Apakah tanaman anda mengalami batang dan rumbai-rumbai (bunga jantan) yang mudah patah?");
        //Q11
        questions.add("Apakah tanaman anda mengalami rambut tongkol jagung terpotong/berkurang/kering?");
        //Q12
        questions.add("Apakah tanaman anda mengalami ujung tongkol terdapat lekukan?");
    }
    
    public void showQuestion()
    {
        Scanner sc = new Scanner(System.in);
        int i =0;
        for(String q: this.questions)
        {
            System.out.println(q);
            System.out.println("0. Tidak    1.Ya");
            int a = sc.nextInt();
            while(a != 0 && a!=1)
            {
                System.out.println("Jawaban tidak sesuai!");
                a = sc.nextInt();
            }
            answers[i] = a;
            System.out.println("Jawaban untuk pertanyaan " + (i + 1) + ": " + (a == 1 ? "Ya" : "Tidak")); 
            i++;
        }
    }
    
    public Set<String> getFacts()
    {
        Set<String> facts = new HashSet<>();
        if(answers[0] == 1)
            facts.add("a");
        if(answers[1] == 1)
            facts.add("b");
        if(answers[2] == 1)
            facts.add("c");
        if(answers[3] == 1)
            facts.add("d");
        if(answers[4] == 1)
            facts.add("e");
        if(answers[5] == 1)
            facts.add("f");
        if(answers[6] == 1)
            facts.add("g");
        if(answers[7] == 1)
            facts.add("h");
        if(answers[8] == 1)
            facts.add("i");
        if(answers[9] == 1)
            facts.add("j");
        if(answers[10] == 1)
            facts.add("k");
        if(answers[11] == 1)
            facts.add("l");
        return facts;
    }
    
  

        public void showConclusion(boolean isTrue, Set<String> facts, Set<String> inferedFacts, String disease) {
        System.out.println("Fakta yang didapat: " + facts);
        System.out.println("Fakta yang diinferensikan: " + inferedFacts);
            if (isTrue) {
                System.out.println("Tanaman terkena penyakit: " + disease);
            } else {
                System.out.println("Tanaman tidak terkena penyakit: " + disease);
            }
        }

    
    
}
