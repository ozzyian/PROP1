package prop.assignment0;

import java.io.IOException;

public class FactorNode implements INode {
	private Lexeme intValue;
	private Lexeme leftParen;
	private ExpressionNode eNode;
	private Lexeme rightParen;
	
	
	public FactorNode(Tokenizer t) throws IOException, TokenizerException, ParserException {
		if (t.current().token() == Token.INT_LIT) {
			intValue = t.current();
			t.moveNext();
		}else if(t.current().token() == Token.LEFT_PAREN) {
			leftParen = t.current();
			t.moveNext();
			eNode = new ExpressionNode(t);
			if (t.current().token() == Token.RIGHT_PAREN) {
				rightParen = t.current();
				t.moveNext();
			}else {
				throw new ParserException("expected ')' but was " + t.current().value());
			}
		}else {
			throw new ParserException("Unknown symbol");
		}
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		
		return intValue;
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
			
		}else{
			builder.append("\t" + tab + leftParen + "\n"); 
			eNode.buildString(builder, (tabs+1));
			builder.append("\t" + tab + rightParen + "\n");
		}
		

		
	}

}
