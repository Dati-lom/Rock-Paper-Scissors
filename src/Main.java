import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Math.random;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean playing = true;
        if (AuxFunctions.checkIfDublicate(args)) {
            System.out.println("There's duplicate in input");
            playing = false;
        }else if(args.length == 0) {
            System.out.println("No arguments");
            playing = false;
        } else if (args.length == 1){
            System.out.println("Only 1 Argument");
            playing = false;
        }
        else if (args.length%2 == 0) {
            System.out.println("Even number of moves");
            playing = false;
        }
        while (playing) {

            String pcString = args[(int) Math.floor(random() * args.length)];
            Hgenerator encrypted = new Hgenerator(pcString);
            System.out.println("HMAC: "+encrypted.getEncoded());
            AuxFunctions.printMoves(args);
            Scanner inp = new Scanner(System.in);
            String userInp = inp.nextLine();
            if (Objects.equals(userInp, "0")) {
                System.exit(2);
            } else if (Objects.equals(userInp, "?")) {
                Table.printTable(args);
                System.out.println("Enter your move: ");
                userInp = inp.nextLine();
            }
            int user = Integer.parseInt(userInp);
            String userString = args[Integer.parseInt(userInp) - 1];
            if (user <= args.length && user >= 0) {
                GameRules gameRules = new GameRules(args);
                System.out.println("YOUR MOVE: " + userString);
                System.out.println("PC MOVE: " + pcString);
                System.out.println("HMAC KEY:"+encrypted.getKey());
                System.out.println(gameRules.whoWon(userString, pcString));
            } else {
                System.out.println("Error Try again choosing the move");
                continue;
            }
            System.out.println("Continue to next round? Y/N");
            String answ = inp.nextLine();
            if (Objects.equals(answ, "n")) {
                playing = false;
            } else if (!Objects.equals(answ, "y") ) {
                System.out.println("incorrect input");
                playing = false;
            }

        }
    }
}