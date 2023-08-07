import java.util.*;

public class GameRules {

    public Map<String,String[]> moves;

    public GameRules(String[] moves){
        this.moves = new HashMap<>();
        for(int j = 0; j < moves.length;j++){
            String[] beats = new String[moves.length/2];

            for(int i = 0; i < beats.length; i++){
                beats[i] = moves[(i+(j+1))%moves.length];

            }

            this.moves.put(moves[j],beats);

        }

    }
    public String whoWon(String player, String pc){
        String res = "Draw";
        if(Arrays.asList(moves.get(player)).contains(pc)){
            res = "PC won";
        }
        if(Arrays.asList(moves.get(pc)).contains(player)){
            res = "Player won";

        }
        return res;
    }

}