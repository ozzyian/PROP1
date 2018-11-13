package prop.assignment0;

import java.io.IOException;

public class ExpressionNode implements INode {
	private TermNode tNode;
	private Lexeme operand;
	private ExpressionNode eNode;
	
	public ExpressionNode(Tokenizer t) throws IOException, TokenizerException, ParserException {
		tNode = new TermNode(t);
		while (t.current().token() == Token.ADD_OP || t.current().token() == Token.SUB_OP) {
			operand = t.current();
			t.moveNext();
			eNode = new ExpressionNode(t);
			
			
		}
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		if(operand==null) {
			tNode.evaluate(null);
		}else if((char)operand.value()=='+') {
			
		}
		
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		String tab = ""; 
		for(int i = 0; i<tabs; i++) {
			tab+= "\t";
		}
		
		builder.append(tab + "ExpressionNode" + "\n");
		tNode.buildString(builder, (tabs+1));
		
		if(operand!=null) {
			builder.append("\t" + tab + operand + "\n"); 
			eNode.buildString(builder, (tabs+1));
		}
		
	}

}
