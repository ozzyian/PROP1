package prop.assignment0;


import java.io.IOException;

public class Tokenizer implements ITokenizer {
	private Scanner scanner = new Scanner(); 
	private Lexeme lexemeCurrent;
	
	@Override
	public void open(String fileName) throws IOException, TokenizerException {

		scanner.open(fileName);
	}
	
	@Override
	public Lexeme current() {
		return lexemeCurrent;
	}
	
	@Override
	public void moveNext() throws IOException, TokenizerException {
		scanner.moveNext();
		char current = scanner.current();
		match(current);
	}
	
	@Override
	public void close() throws IOException {
		
		scanner.close();
	}
	
	
	public void match(char current) {
		if((current >= 'a' && current <= 'z') || (current >= 'A' && current <= 'Z')) {
			lexemeCurrent = new Lexeme(current, Token.IDENT);
		}else if(0<=current && current<=9) {
			lexemeCurrent = new Lexeme(current, Token.INT_LIT);
		}else {
		
		switch(current) {
		case Scanner.EOF:
			lexemeCurrent = new Lexeme(current, Token.EOF);
			break;
		case Scanner.NULL: 
			lexemeCurrent = new Lexeme(current, Token.NULL);
			break;
		case '*': 
			lexemeCurrent = new Lexeme(current, Token.MULT_OP);
			break;
		case '+': 
			lexemeCurrent = new Lexeme(current, Token.ADD_OP);
			break; 
		case '-': 
			lexemeCurrent = new Lexeme(current, Token.SUB_OP);
			break;
		case '/': 
			lexemeCurrent = new Lexeme(current, Token.DIV_OP);
			break;
		case ';': 
			lexemeCurrent = new Lexeme(current, Token.SEMICOLON);
			break; 
		case '=': 
			lexemeCurrent = new Lexeme(current, Token.ASSIGN_OP);
			break; 
		case '(': 
			lexemeCurrent = new Lexeme(current, Token.LEFT_PAREN);
			break; 
		case ')': 
			lexemeCurrent = new Lexeme(current, Token.RIGHT_PAREN);
			break; 
		case '{': 
			lexemeCurrent = new Lexeme(current, Token.LEFT_CURLY);
			break; 
		case '}': 
			lexemeCurrent = new Lexeme(current, Token.RIGHT_CURLY);
			break; 
		};
		
		}
		
		
	}
}
