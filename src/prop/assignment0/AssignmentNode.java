package prop.assignment0;

import java.io.IOException;

public class AssignmentNode implements INode  {
	Lexeme ID;
	Lexeme assignOperand;
	ExpressionNode eNode;
	Lexeme semicolon;
	
	public AssignmentNode(Tokenizer t) throws IOException, TokenizerException, ParserException {
		
		if (t.current().token() == Token.IDENT) {
			ID = t.current();
			t.moveNext();	
		}else {
			throw new ParserException("wrong start symbol");
		}
		
		
		if (t.current().token() == Token.ASSIGN_OP) {
			assignOperand = t.current();
			t.moveNext();	
		}
		else {
			throw new ParserException("Expected '=' but was "+  t.current().value());
		}
		
		eNode = new ExpressionNode(t);
		
		if (t.current().token() == Token.SEMICOLON) {
			semicolon = t.current();
			t.moveNext();
			
		}else {
			throw new ParserException("Expected ';' but was " + t.current().value());
		}
		
		if(t.current().token() != Token.EOF) {
			throw new ParserException("Expected EOF but was "+ t.current().value());
		}
		t.close();
	}
	
	public Lexeme getID() {
		return ID;
	}
	
	@Override
	public Object evaluate(Object[] args) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		// TODO Auto-generated method stub
		
	}
	

	


}
