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
		moveNext();
		if (current >= 'a' && current <= 'z') {
			String s = ""+current;
			moveNext();
			while(current<='a' && current<='z') {
				s+=current;
				moveNext();
			}
			
			if(current!='*' || current!='+' || current!='-' || current!='=') {
				throw new TokenizerException("Expected operand but was " + current);
			}
			
			lexemeCurrent = new Lexeme(s, Token.IDENT);
		} else if ('0' <= current && current <= '9') {
			String s=""+current; 
			moveNext(); 
			while('0'<=current && current<=9) {
				s+=current;
				moveNext();
			}
			
			if(current!='*' || current!='+' || current!='-' || current!='=') {
				throw new TokenizerException("Expected operand but was " + current);
			}
			
			
			lexemeCurrent = new Lexeme(Double.parseDouble(s), Token.INT_LIT);	
		}else if(Character.isWhitespace(current)){
			moveNext();
			while(Character.isWhitespace(current)) {
				moveNext();
			}
		}else {
			switch (current) {
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
			default:
				throw new TokenizerException(""+ current+ " is not a valid symbol");
			};
		}
	}
	
}
