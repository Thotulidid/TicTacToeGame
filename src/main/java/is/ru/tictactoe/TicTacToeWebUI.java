package is.ru.tictactoe;

import static spark.Spark.*;
import spark.*;
 
public class TicTacToeWebUI {
    public static void main(String[] args) {
        final TicTacToeGame game = new TicTacToeGame();
    	get(new Route(":param") {
            @Override
            public Object handle(Request request, Response response) {
            	
            	StringBuilder html = new StringBuilder();
            	
            	Move move;
            	try{
            		int position = Integer.parseInt(request.params(":param"));
            		move = new Move(position, game.hasMove());
            	}
            	catch(Exception ex){
            		return "Out of bounds";
            	}
            	game.move(move);
            	Move[] board = game.getBoard(); 
            	if(game.gameOver()){
            		if(game.winner() == 'D'){
            			html.append("<p style=\"font-size: 350%; font-weight: bold;\">The game finished in a draw.</p>");
            		}
            		else{            			
            			html.append("<p style=\"font-size: 350%; font-weight: bold;\">The winner is:" + game.winner() + "</p>");
            		}
            	}
            	for(int i = 0; i < 9; i++){
            		if(board[i] == null){
            			html.append("<div style=\"width: 33%; height: 25%; float: left; font-size: 200%;\">&nbsp;</div>");
            		}
            		else{
            			html.append("<div style=\"width: 33%; height: 25%; float: left; font-size: 200%;\">" + board[i].getPlayer() + "</div>");
            		}
            	}
            	return html.toString();
            	/*if(game.move(move)){
            		return move.getPlayer() + " played " + move.getPosition() + ".";
            	}
            	else{
            		return move.getPlayer() + " on " + move.getPosition() + " is illegal.";	
            	}*/
            }
        });
    }
}