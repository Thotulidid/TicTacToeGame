package is.ru.tictactoe;

import static spark.Spark.*;
import spark.*;
 
public class TicTacToeWebUI {
    public static void main(String[] args) {
        final TicTacToeGame game = new TicTacToeGame();
    	get(new Route(":param") {
            @Override
            public Object handle(Request request, Response response) {
            	Move move;
            	try{
            		int position = Integer.parseInt(request.params(":param"));
            		move = new Move(position, game.hasMove());
            	}
            	catch(Exception ex){
            		return "Out of bounds";
            	}
            	if(game.move(move)){
            		return move.getPlayer() + " played " + move.getPosition() + ".";
            	}
            	else{
            		return move.getPlayer() + " on " + move.getPosition() + " is illegal.";	
            	}
            }
        });
    }
}