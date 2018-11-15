package prop.assignment0;

import java.io.IOException;
import java.util.HashMap;

public class StatementNode implements INode {
	
	private AssignmentNode aNode;
	private StatementNode sNode;
	private String evaluation = "";
	
	public StatementNode(Tokenizer t) throws IOException, TokenizerException, ParserException {
		System.out.println("Statement node");
		if(t.current().token()== Token.IDENT) {
			aNode = new AssignmentNode(t); 
			
			sNode = new StatementNode(t); 
		}
			
		
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		
		
		if (aNode != null) {
			evaluation += (aNode.evaluate(args));
			evaluation += (sNode.evaluate(args));
		}
		
		
		return evaluation;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		String tab = ""; 
		for(int i = 0; i<tabs; i++) {
			tab+= "\t";
		}
		builder.append(tab +"StatementsNode" + "\n");
		if(aNode!=null) {
			aNode.buildString(builder, (tabs+1));
			sNode.buildString(builder, (tabs+1));
		}
	}

}
