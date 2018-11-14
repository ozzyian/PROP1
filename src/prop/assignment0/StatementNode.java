package prop.assignment0;

import java.io.IOException;

public class StatementNode implements INode {
	
	private AssignmentNode aNode;
	private StatementNode sNode;
	private static int count=0; 

	public StatementNode(Tokenizer t) throws IOException, TokenizerException, ParserException {
		System.out.println("Statement node");
		if(t.current().token()== Token.IDENT) {
			aNode = new AssignmentNode(t); 
			count++;
			sNode = new StatementNode(t); 
		}
			
		
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		Object[] values = new Object[count*2];
		String s = "";
		for(int i=0; i<args.length;i++) {
			s+= aNode.evaluate(values) + "\n";
		}
		return s;
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
