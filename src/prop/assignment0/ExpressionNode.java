package prop.assignment0;

import java.io.IOException;

public class ExpressionNode implements INode {
	private TermNode tNode;
	private Lexeme operand;
	private ExpressionNode eNode;
	private static Object currentResult = 0.0;
	private Object currentOp;
	
	public ExpressionNode(Tokenizer t) throws IOException, TokenizerException, ParserException {
		tNode = new TermNode(t);
		if (t.current().token() == Token.ADD_OP || t.current().token() == Token.SUB_OP) {
			operand = t.current();
			t.match();
			eNode = new ExpressionNode(t);
			
			
		}
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		
		
		args[1] = currentResult;
		args[2] = currentOp;
		
		if(operand==null) {
			return tNode.evaluate(args);
		}else {
			tNode.evaluate(args);
			currentOp = operand.token();
			eNode.evaluate(args);
			return currentResult;
		}
		
		
	}	
		
		
//		double leftOfOperand,rightOfOperand;
//		
//		if(operand==null) {
//			return tNode.evaluate(args);
//		}else if(operand.token() == Token.ADD_OP) {
//			
//			leftOfOperand = (double)eNode.evaluate(args);
//			rightOfOperand = (double)tNode.evaluate(args);
//			
//			return leftOfOperand+rightOfOperand;
//		}else {
//			leftOfOperand = (double)eNode.evaluate(args);
//			rightOfOperand= (double)tNode.evaluate(args);
//			
//			return leftOfOperand-rightOfOperand;
//		}
//		
//	}

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
