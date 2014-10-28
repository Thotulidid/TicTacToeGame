package is.ru.tictactoe;

import static spark.Spark.get;
import spark.Request;
import spark.Route;
import spark.Response;
import static spark.Spark.setPort;
 
public class TicTacToeWebUI {
    public static void main(String[] args) {
        //SparkApplication TicTacToeWebUI = new TicTacToeWebUI();
        String port = System.getenv("PORT");
        if (port != null){
            setPort(Integer.valueOf(port));
        }
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
            		String color = "#FFF";
            		if(i % 2 == 0){
            			color = "#DDD";
            		}
            		if(board[i] == null){
            			html.append("<a href=/" + i + " ><div id=" + i + " style=\"background-color: " + color + "; width: 33%; height: 25%; float: left; font-size: 200%;\">&nbsp;</div></a>");
            		}
            		else{
            			html.append("<div id=" + i + " style=\"background-color: " + color + "; width: 33%; height: 25%; float: left; font-size: 200%;\">" + board[i].getPlayer() + "</div>");
            		}
            	}
            	html.append("<a href=/reset/game >Reset game</a>");
            	html.append("</body></html>");
            	if(game.gameOver()){
            		game.resetGame();
            	}
            	return html.toString();
            }
        });
    	
    	get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
            	
            	StringBuilder html = new StringBuilder();
            	html.append("<html><head><title>TicTacToeWebGame</title></head><body>");
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
            		String color = "#FFF";
            		if(i % 2 == 0){
            			color = "#DDD";
            		}
            		if(board[i] == null){
            			html.append("<a href=/" + i + " ><div id=" + i + " style=\"background-color: " + color + "; width: 33%; height: 25%; float: left; font-size: 200%;\">&nbsp;</div></a>");
            		}
            		else{
            			html.append("<div id=" + i + " style=\"background-color: " + color + "; width: 33%; height: 25%; float: left; font-size: 200%;\">" + board[i].getPlayer() + "</div>");
            		}
            	}
            	html.append("<a href=/reset/game >Reset game</a>");
            	html.append("</body></html>");
            	if(game.gameOver()){
            		game.resetGame();
            	}
            	return html.toString();
            }
        });
    	
    	get(new Route("/reset/game") {
            @Override
            public Object handle(Request request, Response response) {
            	game.resetGame();
            	StringBuilder html = new StringBuilder();
            	html.append("<html><head><title>TicTacToeWebGame</title></head><body>");
            	Move[] board = game.getBoard(); 
        		html.append("<p style=\"font-size: 350%; font-weight: bold;\">" + game.hasMove() + "'s turn to move!</p>");
            	for(int i = 0; i < 9; i++){
            		String color = "#FFF";
            		if(i % 2 == 0){
            			color = "#DDD";
            		}
            		if(board[i] == null){
            			html.append("<a href=/" + i + " ><div id=" + i + " style=\"background-color: " + color + "; width: 33%; height: 25%; float: left; font-size: 200%;\">&nbsp;</div></a>");
            		}
            		else{
            			html.append("<div id=" + i + " style=\"background-color: " + color + "; width: 33%; height: 25%; float: left; font-size: 200%;\">" + board[i].getPlayer() + "</div>");
            		}
            	}
            	html.append("<a href=/reset/game >Reset game</a>");
            	html.append("</body></html>");
            	return html.toString();
            }
        });
    }
}