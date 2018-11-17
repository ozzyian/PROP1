package prop.assignment0;

import java.io.IOException;

public class ExpressionNode implements INode {
	private TermNode tNode;
	private Lexeme operand;
	private ExpressionNode eNode;
	private static Object currentResult;
	
	
	public ExpressionNode(Tokenizer t) throws IOException, TokenizerException, ParserException {
		System.out.println("exp node created");
		tNode = new TermNode(t);
		if (t.current().token() == Token.ADD_OP || t.current().token() == Token.SUB_OP) {
			operand = t.current();
			t.match();
			eNode = new ExpressionNode(t);
			
			
		}
	}
	
	

	@Override
	public Object evaluate(Object[] args) throws Exception {
		ExpressionNode temp = eNode;
		double left; 
		Lexeme tempOP = temp.getOP(); 
		
		left = (double) tNode.evaluate(args);
		if(operand!=null) {
			if(operand.token()==Token.ADD_OP) {
				left = left + (double)temp.getTerm().evaluate(args);
			}else {
				left = left - (double)temp.getTerm().evaluate(args);
			}
			
			while(true) {
				if(tempOP==null) {
					
					return left;
				}
				
				temp = temp.eNode;
				
				
				if(tempOP.token() == Token.ADD_OP) {
					left = left + (double)temp.getTerm().evaluate(args);
				}else {
					left = left - (double)temp.getTerm().evaluate(args);
				}
				
				tempOP = temp.getOP();
				
			}
		
		}else {
			return left;
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
	public Lexeme getOP() {
		return operand;
	}
	public TermNode getTerm() {
		return tNode;
	}

}
