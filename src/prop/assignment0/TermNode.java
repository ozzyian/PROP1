package prop.assignment0;

import java.io.IOException;

public class TermNode implements INode {
	private FactorNode fNode;
	private Lexeme operand;
	private TermNode tNode;

	
	public TermNode(Tokenizer t) throws IOException, TokenizerException, ParserException {
		fNode = new FactorNode(t);
		while (t.current().token() == Token.MULT_OP || t.current().token() == Token.DIV_OP) {
			operand = t.current();
			t.moveNext();
			tNode = new TermNode(t);
		}
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		double leftOfOperand,rightOfOperand;
		if(operand == null) {
			return fNode.evaluate(null);
		}else if(operand.token() == Token.MULT_OP) {
			leftOfOperand = (double) fNode.evaluate(null);
			rightOfOperand = (double) tNode.evaluate(null);
			return leftOfOperand*rightOfOperand;
		}else {
			leftOfOperand = (double) fNode.evaluate(null);
			rightOfOperand = (double) tNode.evaluate(null);
			return leftOfOperand/rightOfOperand;
		}
		
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		String tab = ""; 
		for(int i = 0; i<tabs; i++) {
			tab+= "\t";
		}
		
		builder.append(tab + "TermNode" + "\n");
		fNode.buildString(builder, (tabs+1));
		
		if(operand!=null) {
			builder.append("\t" + tab + operand + "\n"); 
			tNode.buildString(builder, (tabs+1));
			
		}
		
	}

}
