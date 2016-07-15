package password.generator.exception;

/**
 * Exceção de validação de comprimento de senha gerada.
 * 
 * @author thiago-amm
 * @version 1.0.0
 * @since v1.0.0
 *
 */
public class LengthValidationException extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    public LengthValidationException() {
        super();
    }
    
    public LengthValidationException(String message) { 
        super(message); 
    }
    
    public LengthValidationException(String message, Throwable cause) { 
        super(message, cause); 
    }
    
    public LengthValidationException(Throwable cause) { 
        super(cause);
    }
    
}
