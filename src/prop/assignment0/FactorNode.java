package prop.assignment0;

import java.io.IOException;
import java.util.HashMap;

public class FactorNode implements INode {
	private Lexeme intValue;
	private Lexeme ID;
	private Lexeme leftParen;
	private ExpressionNode eNode;
	private Lexeme rightParen;
	
	
	public FactorNode(Tokenizer t) throws IOException, TokenizerException, ParserException {
		if (t.current().token() == Token.INT_LIT) {
			intValue = t.current();
			t.match();
		}else if(t.current().token() == Token.IDENT) {
			ID = t.current();
			t.match();
			
		}else if(t.current().token() == Token.LEFT_PAREN) {
			leftParen = t.current();
			t.match();
			eNode = new ExpressionNode(t);
			if (t.current().token() == Token.RIGHT_PAREN) {
				rightParen = t.current();
				t.match();
			}else {
				throw new ParserException("expected ')' but was " + t.current().value());
			}
		}else {
			throw new ParserException("must be INT_LITERAL or IDENTIFIER");
		}
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		if(intValue!=null) { //om det finns en intvalör
			if(args[2]!=null) { //om det finns en operator
				if(args[2]==Token.ADD_OP) {
					double a = (double) args[1];
					args[1] =  a + (double)intValue.value();
					return null;
				}else {
					double a = (double) args[1]; 
					args[1] =  a - (double)intValue.value();
					return null;
				}
				
			}else {
				args[1] = intValue.value();
				return null;
			}
			
		}else if (ID != null){
			return ((HashMap<Object, Double>) args[0]).get(ID.value());
		}else {
			return eNode.evaluate(args);
		}
	}
		
	

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		String tab = ""; 
		for(int i = 0; i<tabs; i++) {
			tab+= "\t";
		}
		
		builder.append(tab + "FactorNode" + "\n");
		if(intValue!=null) {
			builder.append("\t" + tab + intValue + "\n");
			
		}else if(ID!=null){
			builder.append("\t" + tab + ID + "\n");
		}else {
			builder.append("\t" + tab + leftParen + "\n"); 
			eNode.buildString(builder, (tabs+1));
			builder.append("\t" + tab + rightParen + "\n");
		}
		

		
	}

}
