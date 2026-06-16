package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class Arquivos {

    public static void main(String[] args) throws IOException {     
       ler();
       
        
    }

 

    private static void ler() throws FileNotFoundException, IOException {
         // LEITURA

        // Escolhendo o arquivo que será lido
        String arqLeitura = "dados.csv";
                
        BufferedReader buffRead = new BufferedReader(new FileReader(arqLeitura));
        
        System.out.println("Lendo o arquivo " + arqLeitura);
        
        String linha = buffRead.readLine();
        
         ArrayList<Cadastro> p = new ArrayList<>();
         
        int x=0;
        
        while (x<4){
          
            linha = buffRead.readLine();
            p.add(new  Cadastro(linha));
            x++;
        }
        
        for (int i = 0; i < p.size(); i++) {
            System.out.println(p.get(i));
        }
        
        buffRead.close();

    }
    
}