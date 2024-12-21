package arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CalculoSalBruto 
{
	public static void main(String args[])
	{
		Map<String, Double> salBrutoHash = new HashMap<>();
        Map<String, Double> descHash = new HashMap<>();

        try 
        {
            BufferedReader salBrutoReader = new BufferedReader(new FileReader("salbruto.dat"));
            BufferedReader descReader = new BufferedReader(new FileReader("desc.dat"));

            String linha;
            while ((linha = salBrutoReader.readLine()) != null) //le ate acabar o arquivo
            {
                String[] parts = linha.split(" ");
                String cpf = parts[0];
                double salBruto = Double.parseDouble(parts[1]);
                salBrutoHash.put(cpf, salBruto);
            }
            while ((linha = descReader.readLine()) != null) //le ate acabar o arquivo
            {
                String[] parts = linha.split(" ");
                String cpf = parts[0];
                double desc = Double.parseDouble(parts[1]);
                descHash.put(cpf, desc);
            }
            PrintWriter writer = new PrintWriter("salliq.txt");
            for (String cpf : salBrutoHash.keySet()) 
            {
                double salBruto = salBrutoHash.get(cpf);
                double desc = descHash.getOrDefault(cpf, 0.0);//pega o valor de desconto ou assume como 0 o desconto
                double salLiq = salBruto - desc;
                writer.println(cpf + " " + salLiq);
            }

            salBrutoReader.close();
            descReader.close();
            writer.close();

        } catch (IOException e) 
        {
            System.out.println("Erro ao processar os arquivos: " + e.getMessage());
        }
	}
}
