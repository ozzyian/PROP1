package prop.assignment0;

import java.io.IOException;
import java.util.ArrayList;

public class Parser implements IParser {
	
	private Tokenizer tokenizer = new Tokenizer(); 
	
	
	@Override
	public void open(String fileName) throws IOException, TokenizerException {
		
		tokenizer.open(fileName);
		
	}

	@Override
	public INode parse() throws IOException, TokenizerException, ParserException {
		Lexeme lexeme;
		lexeme = tokenizer.current(); 
			
		tokenizer.moveNext(); 
		
		
	}

	@Override
	public void close() throws IOException {
		tokenizer.close();
		
	}
	
	public ArrayList<Lexeme> getList() {
		
		return lexemes; 
	}

}
