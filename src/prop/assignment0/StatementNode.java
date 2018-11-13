package prop.assignment0;

import java.io.IOException;

public class StatementNode implements INode {
	
	private AssignmentNode aNode;
	private StatementNode sNode;

	public StatementNode(Tokenizer t) throws IOException, TokenizerException, ParserException {
		
			aNode = new AssignmentNode(t);
			if(t.current().token() == Token.IDENT) {
				sNode = new StatementNode(t);
			}
			
		
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		String tab = ""; 
		for(int i = 0; i<tabs; i++) {
			tab+= "\t";
		}
		builder.append(tab +"StatementsNode" + "\n");
		aNode.buildString(builder, (tabs+1));
		if (sNode != null) {
			sNode.buildString(builder, (tabs+1));
		}
	}

}
