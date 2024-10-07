package com.mycompany.sistempakar;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SistemPakar {
   public static List<Rule> getKnowledge() throws FileNotFoundException, IOException {
        List<Rule> rules;
        try (FileReader reader = new FileReader("D:\\Nabilah\\COLLEGE\\SistemPakar\\src\\main\\java\\com\\mycompany\\sistempakar\\knowledge_base.txt"); BufferedReader bufferedReader = new BufferedReader(reader)) {
            rules = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //mengambil string bagian fact dulu baru conclusion
                rules.add(new Rule(
                        Arrays.asList(line.split("-")[0].split(",")),
                        line.split("-")[1].trim()));
            }
        }
        return rules;
    }
    
        public static void main(String[] args) {
        System.out.println("Selamat datang di CORNDOC!");

        try {
            UI tampilan = new UI();
            tampilan.showQuestion();

            // Mengambil fakta dari jawaban user
            Set<String> facts = tampilan.getFacts();

            // Mendapatkan knowledge base
            List<Rule> rules = getKnowledge();
            

            // Melakukan inferensi menggunakan forward chaining
            Set<String> inferedFacts = InferenceForwardChaining.doForwardChaining(rules, facts);
            

            // Daftar kesimpulan dan penyakit yang ingin dicek
            String[] conclusions = {"m", "n", "o", "p", "q", "r"};
            String[] diseases = {"BULAI", "BUSUK", "KARAT DAUN", "LUKA BAKAR", "PENGGEREK BATANG", "PENGGEREK TONGKOL"};

            // Loop untuk cek semua kesimpulan dengan nama penyakit
            for (int i = 0; i < conclusions.length; i++) {
                boolean isTrue = inferedFacts.contains(conclusions[i]);
                tampilan.showConclusion(isTrue, facts, inferedFacts, diseases[i]);
            }
        } catch (IOException e) {
            
        }
    }


    
}
