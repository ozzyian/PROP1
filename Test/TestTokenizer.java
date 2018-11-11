import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import prop.assignment0.*;
import org.junit.jupiter.api.Test;

class TestTokenizer {

	@Test
	void testMatch() throws IOException, TokenizerException {
		Lexeme expected = new Lexeme('a', Token.IDENT);
		Tokenizer tokenizer = new Tokenizer();
		tokenizer.open("program1.txt");
		tokenizer.moveNext();
		assertEquals(expected.token(), tokenizer.current().token());
		expected = new Lexeme('=', Token.ASSIGN_OP);
		tokenizer.moveNext();
		assertEquals(expected.token(), tokenizer.current().token());
		expected = new Lexeme('1', Token.INT_LIT);
		tokenizer.moveNext();
		assertEquals(expected.token(), tokenizer.current().token());
		expected = new Lexeme(';', Token.SEMICOLON);
		tokenizer.moveNext();
		assertEquals(expected.token(), tokenizer.current().token());
		expected = new Lexeme('?', Token.EOF);
		tokenizer.moveNext();
		assertEquals(expected.token(), tokenizer.current().token());
	}

}
