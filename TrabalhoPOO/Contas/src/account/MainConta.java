package account;

import java.util.Scanner;

public class MainConta {
	public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        Conta contas[] = new Conta[10];
        int contasC = 0;
        
        int escolha = 0;
        do {
            
            System.out.println("---- Menu ----");
            System.out.println("1. Criar conta");
            System.out.println("2. Realizar depósito");
            System.out.println("3. Realizar saque");
            System.out.println("4. Realizar transferência");
            System.out.println("5. Relatório de contas");
            System.out.println("6. Relatório de contas negativas");
            System.out.println("7. Relatório de contas por faixa etária");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opcão: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                {
                	System.out.print("Nome: ");
                    String nome = scanner.next();
                    System.out.print("Saldo: ");
                    float saldo = scanner.nextFloat();
                    System.out.print("CPF: ");
                    String cpf = scanner.next();
                    System.out.print("Telefone: ");
                    String telefone = scanner.next();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    System.out.print("Tipo de conta (Corrente/Poupanca): ");
                    String tipo = scanner.next();
                    try 
                    {
                        Conta novaConta = new Conta(nome, saldo, cpf, telefone, idade, tipo);
                        contas[contasC] = novaConta;
                        contasC++;  // Incrementa o contador de contas
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro ao criar conta: " + e.getMessage());
                    }
                break;
                }
                case 2:
                {
                    System.out.print("Conta: ");
                    int contaAAlterar = scanner.nextInt();
                    if(contaAAlterar > contasC|| contaAAlterar <= 0)
                    {
                        System.out.println("Erro a conta nao existe");
                        break;
                    }
                    contaAAlterar--;
                    System.out.print("Digite o valor do deposito: ");
                    float deposito = scanner.nextFloat();
                    contas[contaAAlterar].deposito(deposito);

                    // Código para realizar depósito em uma conta
                    break;
                }
                case 3:
                {
                    System.out.print("Conta: ");
                    int contaAAlterar = scanner.nextInt();
                    if(contaAAlterar > contasC || contaAAlterar <= 0)
                    {
                        System.out.println("Erro a conta nao existe");
                        break;
                    }
                    contaAAlterar--;
                    System.out.print("Digite o valor do saque: ");
                    float saque = scanner.nextFloat();
                    try 
                    {
						contas[contaAAlterar].saque(saque);
					} catch (WithdrawalWarningException e) 
                    {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    // Código para realizar saque de uma conta
                    break;
                }
                case 4:
                   { 
                    System.out.print("De conta: ");
                    int contaAAlterar = scanner.nextInt();
                    System.out.print("Para conta: ");
                    int contaAAlterar2 = scanner.nextInt();
                    if(contaAAlterar > contasC || contaAAlterar2 > contasC || contaAAlterar <= 0)
                    {
                        System.out.println("Erro a(s) conta(s) nao existe(m)");
                        break;
                    }
                    contaAAlterar--;
                    contaAAlterar2--;
                    System.out.print("Digite o valor da tranferencia:");
                    float valor = scanner.nextFloat();
                    contas[contaAAlterar].transferencia(valor, contas[contaAAlterar2]);
                    break;
                }
                    case 5:
                    {System.out.println("---- Relatório de Todas as Contas ----");
                    for (int i = 0; i< contasC+1;i++) {
                        if (contas[i] != null) {
                            System.out.println(contas[i].getConta());
                        }
                    }
                    break;
                    }
                
                case 6:
                   { System.out.println("---- Relatório de Contas Negativas ----");
                    for (int i = 0; i< contasC;i++) {
                        if (contas[i] != null && Float.parseFloat(contas[i].getSaldo()) < 0) {
                            System.out.println(contas[i].getConta()+" saldo:"+contas[i].getSaldo());
                        }
                    }
                    break;
                }
                case 7:
                   { System.out.print("Digite a idade mínima: ");
                    int idadeMinima = scanner.nextInt();
                    System.out.print("Digite a idade máxima: ");
                    int idadeMaxima = scanner.nextInt();
                
                    System.out.println("---- Relatório de Contas por Faixa Etária ----");
                    for (int i = 0; i< contasC;i++) {
                        if (contas[i] != null && Integer.parseInt(contas[i].getIdade()) >= idadeMinima && Integer.parseInt(contas[i].getIdade()) <= idadeMaxima) {
                            System.out.println(contas[i].getConta());
                        }
                    }
                    break;
                }
                case 10:
                    {System.out.println("Saindo");
                    scanner.close();
                    System.exit(0);
                }
                default:
                    System.out.println("Opcão inválida. Escolha novamente.");
            }
        } while (escolha != 10);

        scanner.close();
    }
}
