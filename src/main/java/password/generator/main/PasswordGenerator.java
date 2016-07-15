package password.generator.main;

import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Attribute.INTENSITY_BOLD;
import static org.fusesource.jansi.Ansi.Color.BLACK;
import static org.fusesource.jansi.Ansi.Color.RED;

import java.util.Random;

import org.fusesource.jansi.AnsiConsole;

import password.generator.exception.AmountValidationException;
import password.generator.exception.ArgumentValidationException;
import password.generator.exception.CommandNotFoundException;
import password.generator.exception.LengthValidationException;

/**
 * CLI - COMMAND-LINE INTERFACE do gerador de senhas.
 * 
 * @author thiago-amm
 * @version 1.0.0
 * @since v1.0.0
 */
public class PasswordGenerator {
    
    public static void validateLength(int length) throws LengthValidationException {
        String message = "Comprimento de senha inválido!\nComprimentos válidos vão de 1 até 50 caracteres.";
        if (length < 1 || length > 100) {
            throw new LengthValidationException(message);
        }
    }
    
    public static void validateAmount(int amount) throws AmountValidationException {
        if (amount < 1 || amount > 1000) {
            String message = "A quantidade de senhas a serem geradas é inválida!\nQuantidade válida vai de 1 até 1000.";
            throw new AmountValidationException(message);
        }
    }
    
    public static void help() {
        ansi().eraseScreen();
        System.out.println(ansi().render("@|green,bold \nNOME|@@|blue : password-generator - gera senhas simples e imprime na saida padrao.|@"));
        System.out.println(ansi().render("@|green,bold \nSINOPSE|@@|blue : |@@|blue,bold password-generator [OPTION] … [NUMBER] …|@"));
        System.out.println(ansi().render("@|green,bold \nDESCRIÇÃO|@@|blue : Gera senhas simples e imprime na saida padrao.|@"));
        System.out.println(ansi().render("@|blue,bold \t-a, --amount|@@|blue \n\t\tDefine a quantidade de senhas a serem geradas.|@"));
        System.out.println(ansi().render("@|blue,bold \t-h, --help|@@|blue \n\t\tApresenta a tela de ajuda do sistema.|@"));
        System.out.println(ansi().render("@|blue,bold \t-l, --length|@@|blue \n\t\tDefine o comprimento (quantidade de caracteres) da senha.|@"));
        System.out.println(ansi().render("@|blue,bold \t-v, --version|@@|blue \n\t\tApresenta o numero de versao do programa.|@"));
        System.out.println(ansi().render("@|green,bold \nEXEMPLOS:|@"));
        System.out.println(ansi().render("@|blue,bold \tpassword-generator -a 5|@@|blue \n\t\tGera 5 senhas de 8 caracteres.|@"));
        System.out.println(ansi().render("@|blue,bold \tpassword-generator -l 20|@@|blue \n\t\tGera uma senha de 20 caracteres.|@"));
        System.out.println(ansi().render("@|blue,bold \tpassword-generator -al 3 5|@@|blue \n\t\tGera 3 senhas de 5 caracteres.|@"));
        System.out.println(ansi().render("@|blue,bold \tpassword-generator -la 3 5|@@|blue \n\t\tGera 5 senhas de 3 caracteres.|@"));
        System.out.println(ansi().render("@|green,bold \nAUTOR:|@"));
        System.out.println(ansi().render("@|red,bold \t7h14g0|@ (Thiago Alexandre Martins Monteiro)\n"));
    }
    
    public static void version() {
        System.out.println(ansi().render("@|magenta,bold \tpassword-generator v1.0.0|@"));
        System.out.println(ansi().render("@|blue \n\tCopyright (C) 2009 Free Software Foundation, Inc.|@"));
        System.out.println(ansi().render("@|blue \tLicense GPLv3+: GNU GPL version 3 or later <http://gnu.org/licenses/gpl.html>.|@"));
        System.out.println(ansi().render("@|blue \tThis is free software: you are free to change and redistribute it.|@"));
        System.out.println(ansi().render("@|blue \tThere is NO WARRANTY, to the extent permitted by law.|@"));
    }
    
    public static void commandNotFound() {
        String message = "@|red,bold \n\t\tDigite|@: @|blue,bold password-generator|@ @|green,bold -h |@";
        message += "@|green,bold ou --help|@ @|blue,bold para obter ajuda.\n\n|@";
        System.out.println(ansi().render(message));
    }
    
    public static void generatingMessage() throws InterruptedException {
        System.out.println(ansi().render("@|blue,bold \nGerando senhas...\n|@"));
        Thread.sleep(2000);
    }
    
    public static void header() {
        String line = "\n@|green,bold ================================================> [|@@|magenta,bold PASSWORD-GENERATOR|@@|green,bold ] ";
        line += "<================================================\n|@";
        System.out.println(ansi().render(line));
    }
    
    public static void footer() {
        String line = "\n@|green,bold ========================================================================================================================\n|@";
        System.out.println(ansi().render(line));
    }
    
    public static void generatePassword(int amount, int length) throws AmountValidationException, LengthValidationException {
        validateAmount(amount);
        validateLength(length);
        final char[] ALFABETO = {
            '0', '1', '2', '3', '4', '5', '6', '7', 
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 
            'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 
            'W', 'X', 'Y', 'X', 'a', 'b', 'c', 'd', 
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
            'u', 'v', 'w', 'x', 'y', 'z', '*', '#'
        };
        for (int i = 0; i < amount; i++) {
            String password = "";
            Random random = new Random(System.nanoTime());
            for (int j = 0; j < length; j++) {
                password += ALFABETO[random.nextInt(ALFABETO.length)];
            }
            System.out.println(ansi().render(String.format("@|blue,bold Senha %04d|@@|magenta,bold  => |@@|green,bold %s|@", i + 1, password)));
        }
    }
    
    public static void generatePassword(int length) throws AmountValidationException, LengthValidationException {
        generatePassword(1, length);
    }
    
    public static void main(String[] args) {
        System.setProperty("jansi.passthrough", "true");
        AnsiConsole.systemInstall();
        ansi().bg(BLACK).eraseScreen();
        header();
        final int DEFAULT_LENGTH = 8;
        int amount = 0;
        int length = 0;
        try {
            switch (args.length) {
                case 1:
                    if (args[0].equals("-h") || args[0].equals("--help")) {
                        help();
                    } else if (args[0].equals("-v") || args[0].equals("--version")) {
                        version();
                    } else if (args[0].equals("-a") || args[0].equals("--amount") || 
                               args[0].equals("-l") || args[0].equals("--length")) {
                        String message = String.format("O parâmetro %s espera um número inteiro como argumento!\n", args[0]);
                        message += "Digite password-generator -h ou --help para obter ajuda!";
                        throw new ArgumentValidationException(message);
                    } else {
                        throw new CommandNotFoundException();
                    }
                    break;
                case 2:
                    if (!args[1].matches("\\d+")) {
                        throw new ArgumentValidationException();
                    } else {
                        if (args[0].equals("-l") || args[0].equals("--length")) {
                            generatePassword(Integer.parseInt(args[1]));
                        } else if (args[0].equals("-a") || args[0].equals("--amount")) {
                            amount = Integer.parseInt(args[1]);
                            generatePassword(amount, DEFAULT_LENGTH);
                        } else {
                            throw new CommandNotFoundException();
                        }
                    }
                    break;
                case 3:
                    if (!args[1].matches("\\d+") || !args[2].matches("\\d+")) {
                        throw new ArgumentValidationException();
                    }
                    if (args[0].equals("-al")) {
                        amount = Integer.parseInt(args[1]);
                        length = Integer.parseInt(args[2]);
                    } else if (args[0].equals("-la")) {
                        length = Integer.parseInt(args[1]);
                        amount = Integer.parseInt(args[2]);
                    } else {
                        throw new CommandNotFoundException();
                    }
                    generatePassword(amount, length);
                    break;
                case 4:
                    if (!args[1].matches("\\d+") || !args[3].matches("\\d+")) {
                        throw new ArgumentValidationException();
                    }
                    if (args[0].equals("-l") || args[0].equals("--length")) {
                        length = Integer.parseInt(args[1]);
                    } else if (args[0].equals("-a") || args[0].equals("--amount")) {
                        amount = Integer.parseInt(args[1]);
                    } else {
                        throw new CommandNotFoundException();
                    }
                    if (args[2].equals("-l") || args[2].equals("--length")) {
                        length = Integer.parseInt(args[3]);
                    } else if (args[2].equals("-a") || args[2].equals("--amount")) {
                        amount = Integer.parseInt(args[3]);
                    } else {
                        throw new CommandNotFoundException();
                    }
                    generatePassword(amount, length);
                    break;
                default:
                    throw new CommandNotFoundException();
            }
        } catch (AmountValidationException | ArgumentValidationException | CommandNotFoundException | LengthValidationException e) {
            System.out.println(ansi().fg(RED).a(INTENSITY_BOLD).render(e.getMessage()).reset());
        } finally {
            footer();
            AnsiConsole.systemUninstall();
            System.exit(0);
        }
    }
}
