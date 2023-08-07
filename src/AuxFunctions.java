import java.util.HashSet;
import java.util.Set;

public class AuxFunctions {

    public AuxFunctions(){

    }

    public static void printMoves(String[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + " - " + arr[i]);
        }
        System.out.println("0 - exits\n? - help");
        System.out.println("Enter your move: ");
    }

    public static boolean checkIfDublicate(String[] arr){
        Set<String> set = new HashSet<>();
        for(int i = 1; i < arr.length; i++){
            set.add(arr[i-1]);
            if(set.contains(arr[i]))return true;
        }
        return false;
    }
}
