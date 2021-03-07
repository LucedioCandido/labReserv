package labReserv.api.exception;

public class ErroNaoExisteRegistroNoBD extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErroNaoExisteRegistroNoBD(String msg) {
		super(msg);
	}
}
