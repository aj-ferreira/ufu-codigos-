package system;

public class ContatoNaoEncontradoException  extends Exception 
{
	private static final long serialVersionUID = 1L;

	public ContatoNaoEncontradoException(String message) 
    {
        super(message);
    }
}
