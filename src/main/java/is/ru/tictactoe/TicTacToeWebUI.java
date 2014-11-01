package is.ru.tictactoe;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;
import spark.Request;
import spark.Route;
import spark.Response;
import static spark.Spark.setPort;
import spark.servlet.SparkApplication;
 
public class TicTacToeWebUI implements SparkApplication {
    public static void main(String[] args) {
    	staticFileLocation("/public");
    	SparkApplication TicTacToeWebUI = new TicTacToeWebUI();
        String port = System.getenv("PORT");
        if (port != null){
            setPort(Integer.parseInt(port));
        }
        
        TicTacToeWebUI.init();
    }
    
	private void buildHead(StringBuilder html) {
    	html.append("<html><head><title>TicTacToeWebGame</title></head><body>");
	}
    
	private void buildFoot(StringBuilder html){
    	html.append("<form action=\"/reset/game\" method=\"post\">");
		html.append("<input type=\"submit\" value=\"Reset game\"></form>");
    	html.append("</body></html>");
	}
	
	private void buildBoard(StringBuilder html, TicTacToeGame game){
		Move[] board = game.getBoard();
		String imgur;

		for(int i = 0; i < 9; i++){
    		if(board[i] == null){
    			html.append("<a href=/" + i + " ><div id=" + i + " style=\"border-style: solid; width: 150px; height: 150px; float: left;\">&nbsp;</div></a>");
    		}
    		else{
    			if(board[i].getPlayer() == 'X'){
    				imgur = "http://i.imgur.com/4ylAJMt.png";
    			}
    			else{
    				imgur = "http://i.imgur.com/6aCHJCV.png";
    			}
    			html.append("<div id=" + i + " style=\"background-image: url('" + imgur + "'); border-style: solid; width: 150px; height: 150px; float: left; color: #FFF;\">" + board[i].getPlayer() + "</div>");
    		}
    	}
	}
	
	private void buildMessage(StringBuilder html, TicTacToeGame game){
		if(game.gameOver()){
    		if(game.winner() == 'D'){
    			html.append("<h1>The game finished in a draw.</h1>");
    		}
    		else{            			
    			html.append("<h1>The winner is:" + game.winner() + "</h1>");
    		}
    	}
    	else{
    		html.append("<h1>" + game.hasMove() + "'s turn to move!</h1>");
    	}
	}
	
	@Override
	public void init() {
		final TicTacToeGame game = new TicTacToeGame();
    	get(new Route(":param") {
            @Override
            public Object handle(Request request, Response response) {
            	StringBuilder html = new StringBuilder();
            	buildHead(html);
            	
            	Move move = null;
            	try{
            		int position = Integer.parseInt(request.params(":param"));
            		move = new Move(position, game.hasMove());
            	}
            	catch(Exception ex){
            		html.append("<h1>Out of bounds</h1>");
            	}
            	
            	game.move(move);
            	buildMessage(html, game);
            	buildBoard(html, game);
            	buildFoot(html);
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
            	buildHead(html);
            	buildMessage(html, game);
            	buildBoard(html, game);
            	buildFoot(html);
            	return html.toString();
            }
        });
    	
    	post(new Route("/reset/game") {
            @Override
            public Object handle(Request request, Response response) {
            	game.resetGame();
            	response.redirect("/");
            	return "";
            }
        });
	}
}