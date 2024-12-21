package array;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int[] vetor = new int[10];
        int posicao = 0, valor;
        int contador = 0;

        do
        {
            System.out.print("Digite a posição (-1 para parar): ");
            try 
            {
                posicao = scanner.nextInt();
                if (posicao == -1) 
                {
                    break;
                }

                if (posicao < 0 || posicao >= 10) {
                    System.out.println("Posição inválida. Tente novamente.");
                    continue;
                }

                System.out.print("Digite o valor: ");
                valor = scanner.nextInt();
                vetor[posicao] = valor;
                contador++;
            } catch (InputMismatchException e) 
            {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Posição inexistente. Tente novamente.");
            }
        }while(posicao != -1);

        System.out.println("Valores no vetor: ");
        for (int i = 0; i < contador; i++) 
        {
            System.out.println("Posição " + i + ": " + vetor[i]);
        }

        scanner.close();
    }
}
