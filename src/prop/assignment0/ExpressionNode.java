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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		// TODO Auto-generated method stub
		
	}

}
