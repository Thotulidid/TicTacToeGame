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
            	html.append("<html><head><title>TicTacToeWebGame</title></head><body>");
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
            	else{
            		html.append("<p style=\"font-size: 350%; font-weight: bold;\">" + game.hasMove() + "'s turn to move!</p>");
            	}
            	for(int i = 0; i < 9; i++){
            		if(board[i] == null){
            			html.append("<div id=" + i + " style=\"width: 33%; height: 25%; float: left; font-size: 200%;\">&nbsp;</div>");
            		}
            		else{
            			html.append("<div id=" + i + " style=\"width: 33%; height: 25%; float: left; font-size: 200%;\">" + board[i].getPlayer() + "</div>");
            		}
            	}
            	html.append("</body></html>");
            	if(game.gameOver()){
            		game.resetGame();
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