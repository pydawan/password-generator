package password.generator.exception;

/**
 * Exceção de validação de quantidade de senhas geradas.
 * 
 * @author thiago-amm
 * @version 1.0.0
 * @since v1.0.0
 */
public class AmountValidationException extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    public AmountValidationException() {
        super();
    }
    
    public AmountValidationException(String message) {
        super(message);
    }
    
    public AmountValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public AmountValidationException(Throwable cause) {
        super(cause);
    }
    
}
