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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		// TODO Auto-generated method stub
		
	}

}
