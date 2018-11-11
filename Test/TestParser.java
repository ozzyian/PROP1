import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import prop.assignment0.INode;
import prop.assignment0.IParser;
import prop.assignment0.Lexeme;
import prop.assignment0.Parser;
import prop.assignment0.ParserException;
import prop.assignment0.Token;
import prop.assignment0.TokenizerException;

class TestParser {

	@Test
	void testParser() throws IOException, TokenizerException, ParserException {
		IParser parser = new Parser();
		parser.open("program1.txt");
		INode n = parser.parse();
		assertNull(n);
	}

}
