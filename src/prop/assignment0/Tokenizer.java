package prop.assignment0;


import java.io.IOException;

public class Tokenizer implements ITokenizer {
	private Scanner scanner = new Scanner(); 
	private Lexeme lexemeCurrent;
	private char current;
	
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
		current = scanner.current();
		
	}
	
	@Override
	public void close() throws IOException {
		
		scanner.close();
	}
	
	public void match() throws IOException, TokenizerException {
		if(lexemeCurrent == null) {
			moveNext();
		}
		if (current >= 'a' && current <= 'z') {
			String s = ""+current;
			moveNext();
			while(current>='a' && current<='z') {
				s+=current;
				moveNext();
			}
			
			
			lexemeCurrent = new Lexeme(s, Token.IDENT);
		
		} else if ('0' <= current && current <= '9') {
			String s=""+current; 
			moveNext(); 
			while('0'<=current && current<='9') {
				s+=current;
				moveNext();
			}
				lexemeCurrent = new Lexeme(Double.parseDouble(s), Token.INT_LIT);	
		
		}else if(Character.isWhitespace(current)){
			moveNext();
			match();
			
		}else {
			switch (current) {
			case Scanner.EOF:
				lexemeCurrent = new Lexeme(current, Token.EOF);
				break;
			case Scanner.NULL:
				lexemeCurrent = new Lexeme(current, Token.NULL);
				moveNext();
				break;
			case '*':
				lexemeCurrent = new Lexeme(current, Token.MULT_OP);
				moveNext();
				break;
			case '+':
				lexemeCurrent = new Lexeme(current, Token.ADD_OP);
				moveNext();
				break;
			case '-':
				lexemeCurrent = new Lexeme(current, Token.SUB_OP);
				moveNext();
				break;
			case '/':
				lexemeCurrent = new Lexeme(current, Token.DIV_OP);
				moveNext();
				break;
			case ';':
				lexemeCurrent = new Lexeme(current, Token.SEMICOLON);
				moveNext();
				break;
			case '=':
				lexemeCurrent = new Lexeme(current, Token.ASSIGN_OP);
				moveNext();
				break;
			case '(':
				lexemeCurrent = new Lexeme(current, Token.LEFT_PAREN);
				moveNext();
				break;
			case ')':
				lexemeCurrent = new Lexeme(current, Token.RIGHT_PAREN);
				moveNext();
				break;
			case '{':
				lexemeCurrent = new Lexeme(current, Token.LEFT_CURLY);
				moveNext();
				break;
			case '}':
				lexemeCurrent = new Lexeme(current, Token.RIGHT_CURLY);
				moveNext();
				break;
			default:
				throw new TokenizerException(""+ current+ " is not a valid symbol");
			};
		}
	}
	
}
