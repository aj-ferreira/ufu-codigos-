package system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GestaoDeContatos implements Serializable
{

	private static final long serialVersionUID = 1L;
	private ArrayList<Contato> familia = new ArrayList<>();
    private ArrayList<Contato> amigos = new ArrayList<>();
    private ArrayList<Contato> profissional = new ArrayList<>();

    public void adicionaContato(Contato contato, String categoria) 
    {
        if (categoria.equalsIgnoreCase("familia")) 
        {
            familia.add(contato);
        } else if (categoria.equalsIgnoreCase("amigos")) 
        {
            amigos.add(contato);
        } else if (categoria.equalsIgnoreCase("profissional")) 
        {
            profissional.add(contato);
        } else {
            throw new IllegalArgumentException("Categoria inválida. Escolha entre 'familia', 'amigos' ou 'profissional'.");
        }
    }

    public void eliminaContato(String nome) throws ContatoNaoEncontradoException
    {
        if (!removerContatoDaLista(nome, familia) &&
            !removerContatoDaLista(nome, amigos) &&
            !removerContatoDaLista(nome, profissional)) 
        {
            throw new ContatoNaoEncontradoException("Contato não encontrado");
        }
    }

    public String toString() 
    {
    	StringBuilder result = new StringBuilder();
    	for (Contato c : familia) 
    	{
            result.append(c.toString());result.append("\n");;
        }
        for (Contato c : amigos) 
        {
        	result.append(c.toString());result.append("\n");;
        }
        for (Contato c : profissional) 
        {
        	result.append(c.toString());result.append("\n");;
        }
        return result.toString();
    }

    public Contato maisVelho() 
    {
        Contato maisVelho = null;
        for (Contato c : familia) 
        {
            if (maisVelho == null || c.getIdade() > maisVelho.getIdade()) 
            {
                maisVelho = c;
            }
        }
        for (Contato c : amigos) 
        {
            if (maisVelho == null || c.getIdade() > maisVelho.getIdade()) 
            {
                maisVelho = c;
            }
        }
        for (Contato c : profissional) 
        {
            if (maisVelho == null || c.getIdade() > maisVelho.getIdade()) 
            {
                maisVelho = c;
            }
        }
        return maisVelho;
    }

    public Contato maisNovo() 
    {
        Contato maisNovo = null;
        for (Contato c : familia) 
        {
            if (maisNovo == null || c.getIdade() < maisNovo.getIdade()) 
            {
                maisNovo = c;
            }
        }
        for (Contato c : amigos) 
        {
            if (maisNovo == null || c.getIdade() < maisNovo.getIdade()) 
            {
                maisNovo = c;
            }
        }
        for (Contato c : profissional) 
        {
            if (maisNovo == null || c.getIdade() < maisNovo.getIdade()) 
            {
                maisNovo = c;
            }
        }
        return maisNovo;
    }

    private boolean removerContatoDaLista(String nome, List<Contato> lista) 
    {
    	for (Contato c : familia) 
        {
    		if (c.getNome().equals(nome)) 
            {
                familia.remove(c);
                return true;
            }
        }
        for (Contato c : amigos) 
        {
            if (c.getNome().equals(nome)) 
            {
                amigos.remove(c);
                return true;
            }
        }
        for (Contato c : profissional) 
        {
        	if (c.getNome().equals(nome)) 
            {
                profissional.remove(c);
                return true;
            }
        }
        return false;
    }

}