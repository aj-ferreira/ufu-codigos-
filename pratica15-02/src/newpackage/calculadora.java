/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;
import java.util.ArrayList;
import java.util.List;
import java.lang.ArithmeticException;
import java.util.Scanner;

/**
 *
 * @author Amand
 */
public class calculadora <T extends Number> extends Thread {
    public calculadora(int s)
	{
		nome = Integer.toString(s);
	}
    private  T ultimoResultado;
    private String nome;
    public void soma(T x, T x2)
    {
        if(x instanceof Double)
        {
            ultimoResultado = (T) Double.valueOf( (x.doubleValue()+x2.doubleValue()) );
        }
        else if(x instanceof Float)
        {
            ultimoResultado = (T) Float.valueOf( (x.floatValue()+x2.floatValue()) );
        }
        else if(x instanceof Integer)
        {
            ultimoResultado = (T) Integer.valueOf( (x.intValue()+x2.intValue()) );
        }
        else if(x instanceof Long)
        {
            ultimoResultado = (T) Long.valueOf( (x.longValue()+x2.longValue()) );
        }

    }
    public void sub(T x, T x2)
    {
        if(x instanceof Double)
        {
            ultimoResultado = (T) Double.valueOf( (x.doubleValue()-x2.doubleValue()) );
        }
        else if(x instanceof Float)
        {
            ultimoResultado = (T) Float.valueOf( (x.floatValue()-x2.floatValue()) );
        }
        else if(x instanceof Integer)
        {
            ultimoResultado = (T) Integer.valueOf( (x.intValue()-x2.intValue()) );
        }
        else if(x instanceof Long)
        {
            ultimoResultado = (T) Long.valueOf( (x.longValue()-x2.longValue()) );
        }

    }
    public void div(T x, T x2)
    {
        if(x2.doubleValue() ==0)
        {
            throw new ArithmeticException("");
        }
        if(x instanceof Double)
        {
            ultimoResultado = (T) Double.valueOf( (x.doubleValue()/x2.doubleValue()) );
        }
        else if(x instanceof Float)
        {
            ultimoResultado = (T) Float.valueOf( (x.floatValue()/x2.floatValue()) );
        }
        else if(x instanceof Integer)
        {
            ultimoResultado = (T) Integer.valueOf( (x.intValue()/x2.intValue()) );
        }
        else if(x instanceof Long)
        {
            ultimoResultado = (T) Long.valueOf( (x.longValue()/x2.longValue()) );
        }

    }
    public void mult(T x, T x2)
    {
        if(x instanceof Double)
        {
            ultimoResultado = (T) Double.valueOf( (x.doubleValue()*x2.doubleValue()) );
        }
        else if(x instanceof Float)
        {
            ultimoResultado = (T) Float.valueOf( (x.floatValue()*x2.floatValue()) );
        }
        else if(x instanceof Integer)
        {
            ultimoResultado = (T) Integer.valueOf( (x.intValue()*x2.intValue()) );
        }
        else if(x instanceof Long)
        {
            ultimoResultado = (T) Long.valueOf( (x.longValue()*x2.longValue()) );
        }

    }

    public void pot(T x, T x2)
    {
        if(x instanceof Double)
        {
            ultimoResultado = (T) Double.valueOf( Math.pow(x.doubleValue(),x2.doubleValue()) );
        }
        else if(x instanceof Float)
        {
            ultimoResultado = (T) Float.valueOf( (float) Math.pow( x.floatValue(),x2.floatValue() ) );
        }
        else if(x instanceof Integer)
        {
            ultimoResultado = (T) Integer.valueOf( (int) Math.pow(x.intValue(),x2.intValue()) );
        }
        else if(x instanceof Long)
        {
            ultimoResultado = (T) Long.valueOf( (long) Math.pow(x.longValue(),x2.longValue()) );
        }

    }
    public void sqrt(T x)
    {
        if(x instanceof Double)
        {
            ultimoResultado = (T) Double.valueOf( Math.sqrt(x.doubleValue()) );
        }
        else if(x instanceof Float)
        {
            ultimoResultado = (T) Float.valueOf( (float) Math.sqrt( x.floatValue()) );
        }
        else if(x instanceof Integer)
        {
            ultimoResultado = (T) Integer.valueOf( (int) Math.sqrt(x.intValue()) );
        }
        else if(x instanceof Long)
        {
            ultimoResultado = (T) Long.valueOf( (long) Math.sqrt(x.longValue()) );
        }

    }
    public void cbrt(T x)
    {
        if(x instanceof Double)
        {
            ultimoResultado = (T) Double.valueOf( Math.cbrt(x.doubleValue()) );
        }
        else if(x instanceof Float)
        {
            ultimoResultado = (T) Float.valueOf( (float) Math.cbrt( x.floatValue()) );
        }
        else if(x instanceof Integer)
        {
            ultimoResultado = (T) Integer.valueOf( (int) Math.cbrt(x.intValue()) );
        }
        else if(x instanceof Long)
        {
            ultimoResultado = (T) Long.valueOf( (long) Math.cbrt(x.longValue()) );
        }
    }
    public void fatorial(T x )
    {
        if(x instanceof Integer || x instanceof Long  )
        {
            long y = 1;
            for(int f=2;f<x.intValue()+1;f++)
            {
                y *=f;
            }
            ultimoResultado = (T) Long.valueOf(y);
        }
        else
        {
            return;
        }
    }
    public void fib(T n)
    {
         if(n instanceof Integer || n instanceof Long  )
        {
            List<Long> total = new ArrayList<Long>();
            total.add((long) 1);total.add((long) 1);
            if(n.intValue() < 2)
            {
                return;
            }
            else
            {
                for(int i =0;i<n.intValue()-2;i++)
                {
                    total.add(total.get(i)+total.get(i+1));
                }
            }
            ultimoResultado = (T) total.get(n.intValue()-1);
        }
        else
        {
            return;
        }
    }
    public void pa(T p1, T r,T n)
    {
        if(p1 instanceof Double)
        {
            ultimoResultado = (T) Double.valueOf(p1.doubleValue()+ (r.doubleValue() * n.doubleValue()));
        }
        else if(p1 instanceof Float)
        {
            ultimoResultado = (T) Float.valueOf( p1.floatValue()+ (r.floatValue() * n.floatValue()));
        }
        else if(p1 instanceof Integer)
        {
            ultimoResultado = (T) Integer.valueOf( p1.intValue()+ (r.intValue() * n.intValue()) );
        }
        else if(p1 instanceof Long)
        {
            ultimoResultado = (T) Long.valueOf( p1.longValue()+ (r.longValue() * n.longValue()) );
        }
    }
    public void pg(T p1, T r,T n)
    {
        if(p1 instanceof Double)
        {
            ultimoResultado = (T) Double.valueOf(p1.doubleValue()+ ((double)Math.pow(r.doubleValue() ,n.doubleValue())));
        }
        else if(p1 instanceof Float)
        {
            ultimoResultado = (T) Float.valueOf( p1.floatValue()+ ((float)Math.pow(r.doubleValue() ,n.doubleValue())));
        }
        else if(p1 instanceof Integer)
        {
            ultimoResultado = (T) Integer.valueOf( p1.intValue()+ ((int)Math.pow(r.doubleValue() ,n.doubleValue())));
        }
        else if(p1 instanceof Long)
        {
            ultimoResultado = (T) Long.valueOf( p1.longValue()+ ((long)Math.pow(r.doubleValue() ,n.doubleValue())));
        }

    }
    public Number inputToNumber(String input) {
        Number number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e1) {
            try {
                number = Double.parseDouble(input);
            } catch (NumberFormatException e2) {
                try {
                    number = Long.parseLong(input);
                } catch (NumberFormatException e3) {
                    throw new IllegalArgumentException("Tipo de número inválido");
                }
            }
        }

        return number;
    }



    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        T a,b,c;
        boolean w=true;
        while (w)
        {
            System.out.println("Usando calculadora: "+ nome);
            System.out.println("Escolha uma operação:");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Potência");
            System.out.println("6. Raiz quadrática");
            System.out.println("7. Raiz cubica");
            System.out.println("8. Fatorial");
            System.out.println("9. Fibonacci");
            System.out.println("10. Progressão aritmética");
            System.out.println("11. Progressão geométrica");
            System.out.println("12. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao)
            {
                case 1: 
                {
                    System.out.println("Escolheu soma");
                    System.out.println("Entre o primeiro numero:");
                    String input = scanner.nextLine();
                    a = (T) inputToNumber(input);
                    System.out.println("Entre o segundo numero:");
                    input = scanner.nextLine();
                    b = (T) inputToNumber(input);
                    soma(a, b);
                    System.out.println("Calculadora :"+ nome);
                    mostrarResultado(ultimoResultado,scanner);
                    
                    break;
                }
                case 2: 
                {
                    System.out.println("Escolheu subtração");
                    System.out.println("Entre o primeiro numero:");
                    String input = scanner.nextLine();
                    a = (T) inputToNumber(input);
                    System.out.println("Entre o segundo numero:");
                    input = scanner.nextLine();
                    b = (T) inputToNumber(input);
                    sub(a, b);
                    System.out.println("Calculadora :"+ nome);
                    mostrarResultado(ultimoResultado,scanner);
                    break;
                }
                case 3:
                {
                    System.out.println("Escolheu multiplicação");
                    System.out.println("Entre o primeiro numero:");
                    String input = scanner.nextLine();
                    a = (T) inputToNumber(input);
                    System.out.println("Entre o segundo numero:");
                    input = scanner.nextLine();
                    b = (T) inputToNumber(input);
                    mult(a, b);
                    System.out.println("Calculadora :"+ nome);
                    mostrarResultado(ultimoResultado,scanner);
                    break;
                }
                case 4:
                {
                    System.out.println("Escolheu divisão");
                    System.out.println("Entre o primeiro numero:");
                    String input = scanner.nextLine();
                    a = (T) inputToNumber(input);
                    System.out.println("Entre o segundo numero:");
                    input = scanner.nextLine();
                    b = (T) inputToNumber(input);
                    div(a, b);
                    System.out.println("Calculadora :"+ nome);
                    mostrarResultado(ultimoResultado,scanner);
                    break;
                }
                case 5:
                {
                    System.out.println("Escolheu potencia");
                    System.out.println("Entre o primeiro numero:");
                    String input = scanner.nextLine();
                    a = (T) inputToNumber(input);
                    System.out.println("Entre o segundo numero:");
                    input = scanner.nextLine();
                    b = (T) inputToNumber(input);
                    pot(a, b);
                    System.out.println("Calculadora :"+ nome);
                    mostrarResultado(ultimoResultado,scanner);
                    break;
                }
                case 6: 
                {
                    System.out.println("Escolheu raaiz quadrada");
                    System.out.println("Digite o  número:");
                    String input = scanner.nextLine();
                    a = (T) inputToNumber(input);
                    sqrt(a);
                    System.out.println("Calculadora :"+ nome);
                    mostrarResultado(ultimoResultado,scanner);
                    break;
                }
                case 7:
                {
                    System.out.println("Escolheu raiz cubica");
                    System.out.println("Digite o  número:");
                    String input = scanner.nextLine();
                    a = (T) inputToNumber(input);
                    cbrt(a);
                    System.out.println("Calculadora :"+ nome);
                    mostrarResultado(ultimoResultado,scanner);
                    break;
                }
                case 8:
                {
                    System.out.println("Escolheu fatorial");
                    System.out.println("Digite o  número:");
                    String input = scanner.nextLine();
                    a = (T) inputToNumber(input);
                    fatorial(a);
                    System.out.println("Calculadora :"+ nome);
                    mostrarResultado(ultimoResultado,scanner);
                    break;
                }
                case 9: 
                {
                    System.out.println("Escolheu fibonacci");
                    System.out.println("Entre o número :");
                    String input = scanner.nextLine();
                    a = (T) inputToNumber(input);
                    fib(a);
                    System.out.println("Calculadora :"+ nome);
                    mostrarResultado(ultimoResultado,scanner);
                    break;
                }
                case 10: 
                {
                    System.out.println("Escolheu PA");
                    System.out.println("Entre o primeiro termo:");
                    String input = scanner.nextLine();
                    a = (T) inputToNumber(input);
                    System.out.println("Entre a razão:");
                    input = scanner.nextLine();
                    b = (T) inputToNumber(input);
                    System.out.println("Entre o n-ésimo termo desejado:");
                    input = scanner.nextLine();
                    c = (T) inputToNumber(input);
                    pa(a, b, c);
                    System.out.println("Calculadora :"+ nome);
                    mostrarResultado(ultimoResultado,scanner);
                    break;
                }
                case 11: 
                {
                    System.out.println("Escolheu PG");
                    System.out.println("Entre o primeiro termo:");
                    String input = scanner.nextLine();
                    a = (T) inputToNumber(input);
                    System.out.println("Entre a razão:");
                    input = scanner.nextLine();
                    b = (T) inputToNumber(input);
                    System.out.println("Entre o n-ésimo termo desejado:");
                    input = scanner.nextLine();
                    c = (T) inputToNumber(input);
                    pg(a, b, c);
                    System.out.println("Calculadora :"+ nome);
                    mostrarResultado(ultimoResultado,scanner);
                    break;
                }
                case 12:
                {
                    w=false;
                    break;
                }
            }
        }
    }
    public void mostrarResultado(T ultimoRes, Scanner scanner)
    {
        System.out.println("Mostrar resultado? [1]SIM [0]NAO");
        int x = scanner.nextInt();
        scanner.nextLine();
        if(x>0)
        {
            System.out.println("="+ultimoRes);
        }
    }
}
