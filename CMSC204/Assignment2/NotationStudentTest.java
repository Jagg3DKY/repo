import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotationStudentTest {
	
	public String easyI = "((2+5)*4)";
	public String intermediateI = "((2+(3*(4/6)))-2)";
	public String complexI = "((7*(((3-((4+5)/6))+(5/6))+(8-7)))*6)";
	public String easyP = "25+4*";
	public String intermediateP = "2346/*+2-";
	public String complexP = "7345+6/-56/+87-+*6*";
	
	public double  easyPEval = 28.0;
	public double intermediatePEval = 2.0;
	public double complexPEval = 140.0;
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConvertInfixToPostfix() throws InvalidNotationFormatException {
		String easyResult = Notation.convertInfixToPostfix(easyI);
		String intermediateResult = Notation.convertInfixToPostfix(intermediateI);
		String complexResult = Notation.convertInfixToPostfix(complexI);
		assertEquals(easyP, easyResult);
		assertEquals(intermediateP, intermediateResult);
		assertEquals(complexP, complexResult);
	}

	@Test
	void testConvertPostfixToInfix​() throws InvalidNotationFormatException {
		String easyResult = Notation.convertPostfixToInfix​(easyP);
		String intermediateResult = Notation.convertPostfixToInfix​(intermediateP);
		String complexResult = Notation.convertPostfixToInfix​(complexP);
		assertEquals(easyI, easyResult);
		assertEquals(intermediateI, intermediateResult);
		assertEquals(complexI, complexResult);
	}

	@Test
	void testEvaluatePostfixExpression​() throws InvalidNotationFormatException {
		double easyResult = Notation.evaluatePostfixExpression​(easyP);
		double intermediateResult = Notation.evaluatePostfixExpression​(intermediateP);
		double complexResult = Notation.evaluatePostfixExpression​(complexP);
		assertEquals(easyPEval, easyResult, .001);
		assertEquals(intermediatePEval, intermediateResult, .001);
		assertEquals(complexPEval, complexResult, .001);
	}

}
