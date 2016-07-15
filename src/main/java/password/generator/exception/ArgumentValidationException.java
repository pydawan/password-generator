package password.generator.exception;

public class ArgumentValidationException extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    public ArgumentValidationException() {
        super("Argumento inválido!\nO argumento deve ser um número inteiro.\n\nDigite password-generator -h ou --help para obter ajuda!");
    }
    
    public ArgumentValidationException(String message) {
        super(message);
    }
    
    public ArgumentValidationException(Throwable cause) {
        super(cause);
    }
    
    public ArgumentValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
