/**
 * 
 */
package password.generator.exception;

/**
 * Exceção de commando não encontrado pela CLI (command-line interface) ou
 * shell do gerador de senhas.
 * 
 * @author thiago-amm
 * @version 1.0.0
 * @since v1.0.0
 */
public class CommandNotFoundException extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    public CommandNotFoundException() {
        super("Commando não encontrado!\n\nDigite password-generator -h ou --help para obter ajuda!");
    }
    
    public CommandNotFoundException(String message) {
        super(message);
    }
    
    public CommandNotFoundException(Throwable cause) {
        super(cause);
    }
    
    public CommandNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
