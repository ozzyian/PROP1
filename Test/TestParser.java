import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import prop.assignment0.Lexeme;
import prop.assignment0.Token;

class TestParser {

	@Test
	void testParse() {
		ArrayList<Lexeme> testList = new ArrayList<>();
		testList.add(new Lexeme('a', Token.IDENT)); 
		testList.add(new Lexeme('*', Token.MULT_OP));
		
	}

}
