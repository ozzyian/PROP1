package prop.assignment0;

import java.io.IOException;
import java.util.HashMap;

import java.util.Map;


public class BlockNode implements INode {
	private Map<Object, Double> variableValues;
	private Lexeme curlLeft;
	private StatementNode sNode;
	private Lexeme curlRight;
	
	public BlockNode(Tokenizer t) throws ParserException, IOException, TokenizerException {
		if(t.current().token() == Token.LEFT_CURLY) {
			curlLeft = t.current();
			t.match();	
		}else {
			throw new ParserException("wrong start symbol");
		}
		
		sNode = new StatementNode(t);
		
		if(t.current().token() == Token.RIGHT_CURLY) {
			curlRight = t.current();
			t.match();	
		}else {
			throw new ParserException("Expected '}' but was " + t.current().value());
		}
		
		if(t.current().token() != Token.EOF) {
			throw new ParserException("Expected EOF but was "+ t.current().value());
		}
		t.close();
	}
	
	@Override
	public Object evaluate(Object[] args) throws Exception {
		Object[] arr = new Object[2];
		arr[0]  = (new HashMap<Object, Double>());
		
		return sNode.evaluate(arr);
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		builder.append("BlockNode" + "\n");
		builder.append(curlLeft+ "\n");
		sNode.buildString(builder, (tabs+1));
		builder.append(curlRight+ "\n");
	}

}
