package account;


public class Conta 
{
    private String nome;
    private float saldo;
    private int idade;
    private String cpf;
    private String telefone;
    private String tipoDeConta;
    public Conta(String nome,float saldo,String cpf, String telefone, int idade,String tipo) 
    {
        if (!tipo.equals("Corrente") && !tipo.equals("Poupanca"))
        {
            throw new IllegalArgumentException("O tipo de conta deve ser Corrente ou Poupanca");
        }
        if (saldo < 0 || idade < 0) 
        {
            throw new IllegalArgumentException("O saldo e a idade devem ser valores não negativos.");
        }
        this.tipoDeConta = tipo;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.saldo = saldo; 
       
    }
    public String getTipo()
    {
        return tipoDeConta;
    }
    public String getCpf()
    {
        return cpf;
    }
    public String getIdade()
    {
        return Integer.toString(idade);
    }
    public String getConta() {
        return "telefone: "+telefone+" nome: "+nome+" saldo: "+saldo+" \n";
    }
    public String getSaldo()
    {
        return Float.toString(saldo);
    }

    
    public int deposito(float valor) 
    {
        if (valor > 0) 
        {
            saldo += valor;
            return 0;
        }
        else
        {
        	throw new IllegalArgumentException("O valor do deposito precisa ser maior que 0.");
        }
    }
    
    public int saque(float valor) throws WithdrawalWarningException
   {
        if (valor <= saldo && valor > 0)
        {
            this.saldo -= valor;
            return 0;
        }
        else if(valor > 0)
        {
        	throw new IllegalArgumentException("O valor do deposito precisa ser maior que 0.");
        }
        else
        {
        	throw new WithdrawalWarningException("O valor do saque é maior que o saldo atual.");
        }
    }
    
    public int transferencia(float valor, Conta recebeTransferencia) {
        boolean verificaTransferenciaPossivel = valor <= saldo+100 && valor > 0 && !recebeTransferencia.nome.equals(nome);
        if (verificaTransferenciaPossivel) {
            saldo -= valor;
            recebeTransferencia.saldo += valor;
            return 0;
        }
        return 1;
    }
    


}

   