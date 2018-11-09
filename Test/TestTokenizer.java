import static org.junit.jupiter.api.Assertions.*;
import prop.assignment0.*;
import org.junit.jupiter.api.Test;

class TestTokenizer {

	@Test
	void testMatch() {
		Tokenizer tokenizer = new Tokenizer();
		Lexeme lexeme = new Lexeme(' ', Token.INT_LIT); 
		tokenizer.match(' ');
		assertEquals(lexeme.token(), tokenizer.current().token());
	}

}
