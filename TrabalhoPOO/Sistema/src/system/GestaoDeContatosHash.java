package system;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GestaoDeContatosHash implements Serializable 
{

    private static final long serialVersionUID = 1L;
    private Map<String, Contato> familia = new HashMap<>();
    private Map<String, Contato> amigos = new HashMap<>();
    private Map<String, Contato> profissional = new HashMap<>();

    public void adicionaContato(Contato contato, String categoria) 
    {
        if (categoria.equalsIgnoreCase("familia")) 
        {
            familia.put(contato.getNome(), contato);
        } else if (categoria.equalsIgnoreCase("amigos")) 
        {
            amigos.put(contato.getNome(), contato);
        } else if (categoria.equalsIgnoreCase("profissional")) 
        {
            profissional.put(contato.getNome(), contato);
        } else 
        {
            throw new IllegalArgumentException("Categoria inválida. Escolha entre 'familia', 'amigos' ou 'profissional'.");
        }
    }

    public void eliminaContato(String nome) throws ContatoNaoEncontradoException 
    {
        if (!removerContatoDaLista(nome) &&
                !removerContatoDaLista(nome) &&
                !removerContatoDaLista(nome)) 
        {
            throw new ContatoNaoEncontradoException("Contato não encontrado");
        }
    }

    public String toString() 
    {
        StringBuilder result = new StringBuilder();
        for (Contato c : familia.values()) {
            result.append(c.toString()).append("\n");
        }
        for (Contato c : amigos.values()) {
            result.append(c.toString()).append("\n");
        }
        for (Contato c : profissional.values()) {
            result.append(c.toString()).append("\n");
        }
        return result.toString();
    }

    public Contato maisVelho() {
        Contato maisVelho = null;
        for (Contato c : familia.values()) {
            if (maisVelho == null || c.getIdade() > maisVelho.getIdade()) 
            {
                maisVelho = c;
            }
        }
        for (Contato c : amigos.values()) {
            if (maisVelho == null || c.getIdade() > maisVelho.getIdade()) 
            {
                maisVelho = c;
            }
        }
        for (Contato c : profissional.values()) {
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
        for (Contato c : familia.values()) 
        {
            if (maisNovo == null || c.getIdade() < maisNovo.getIdade()) 
            {
                maisNovo = c;
            }
        }
        for (Contato c : amigos.values()) {
            if (maisNovo == null || c.getIdade() < maisNovo.getIdade()) 
            {
                maisNovo = c;
            }
        }
        for (Contato c : profissional.values()) {
            if (maisNovo == null || c.getIdade() < maisNovo.getIdade()) 
            {
                maisNovo = c;
            }
        }
        return maisNovo;
    }

    private boolean removerContatoDaLista(String nome) 
    {
        if (familia.containsKey(nome)) 
        {
            familia.remove(nome);
            return true;
        } else if (amigos.containsKey(nome)) 
        {
            amigos.remove(nome);
            return true;
        } else if (profissional.containsKey(nome)) 
        {
            profissional.remove(nome);
            return true;
        }
        return false;
    }
}
