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
			t.match();	
		}else {
			throw new ParserException("wrong start symbol");
		}
		
		
		if (t.current().token() == Token.ASSIGN_OP) {
			assignOperand = t.current();
			t.match();	
		}
		else {
			throw new ParserException("Expected '=' but was "+  t.current().value());
		}
		
		eNode = new ExpressionNode(t);
		
		if (t.current().token() == Token.SEMICOLON) {
			semicolon = t.current();
			t.match();
			
		}else {
			throw new ParserException("Expected ';' but was " + t.current().value());
		}
		

	}
	
	public Lexeme getID() {
		return ID;
	}
	
	@Override
	public Object evaluate(Object[] args) throws Exception {
		
		
		return ""+ ID.value() + " = " +eNode.evaluate(args);
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		String tab = ""; 
		for(int i = 0; i<tabs; i++) {
			tab+= "\t";
		}
		builder.append(tab +"AssignmentNode" + "\n");
		builder.append(tab +"\t" + ID + "\n"); 
		builder.append(tab+"\t" + assignOperand + "\n"); 
		eNode.buildString(builder, (tabs+1) );
		builder.append(tab+"\t" + semicolon + "\n");
		
	}
	


	


}
