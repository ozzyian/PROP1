package prop.assignment0;

import java.io.IOException;


public class Parser implements IParser {
	
	private Tokenizer tokenizer = new Tokenizer(); 
	private Lexeme lookahead;
	
	@Override
	public void open(String fileName) throws IOException, TokenizerException {
		
		tokenizer.open(fileName);
		
	}

	@Override
	public INode parse() throws IOException, TokenizerException, ParserException {
		assign();
		close();	
		 
	return null;
		
	}
	
	public void assign() throws ParserException, IOException, TokenizerException {
		tokenizer.moveNext();
		lookahead = tokenizer.current();
		if (lookahead.token() == Token.IDENT) {
			tokenizer.moveNext();
			lookahead = tokenizer.current();
		}else {
			throw new ParserException("wrong start symbol");
		}
		if (lookahead.token() == Token.ASSIGN_OP) {
			tokenizer.moveNext();
			lookahead = tokenizer.current();
		}
		else {
			throw new ParserException("Expected '=' but was "+  lookahead.value());
		}
		
		expression();
		
		if (lookahead.token() == Token.SEMICOLON) {
			tokenizer.moveNext();
			lookahead = tokenizer.current();
		}else {
			throw new ParserException("Expected ';' but was " + lookahead.value());
		}
		
		if(lookahead.token() != Token.EOF) {
			throw new ParserException("Expected EOF but was "+ lookahead.value());
		}
	}
	public void expression() throws IOException, TokenizerException, ParserException {
		term();
		while (lookahead.token() == Token.ADD_OP || lookahead.token() == Token.SUB_OP) {
			tokenizer.moveNext();
			lookahead = tokenizer.current();
			expression();
		}
	}
	public void term() throws IOException, TokenizerException, ParserException {
		factor();
		while (lookahead.token() == Token.MULT_OP || lookahead.token() == Token.DIV_OP) {
			tokenizer.moveNext();
			lookahead = tokenizer.current();
			term();
		}
	}
	public void factor() throws IOException, TokenizerException, ParserException {
		if (lookahead.token() == Token.INT_LIT) {
			tokenizer.moveNext();
			lookahead = tokenizer.current();
		}else {
			if(lookahead.token() == Token.LEFT_PAREN) {
				tokenizer.moveNext();
				lookahead = tokenizer.current();
				expression();
				if(lookahead.token() == Token.RIGHT_PAREN) {
					tokenizer.moveNext();
					lookahead = tokenizer.current();
				}else {
					throw new ParserException("expected ')' but was " + lookahead.value());
				}
			}else {
				throw new ParserException("Unknown symbol");
			}
		}
		
	}

	@Override
	public void close() throws IOException {
		tokenizer.close();
		
	}
	


}
