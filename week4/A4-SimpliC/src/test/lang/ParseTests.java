package lang;

import java.io.File;

import org.junit.Test;

public class ParseTests {
	/** Directory where the test input files are stored. */
	private static final File TEST_DIRECTORY = new File("testfiles/parser");

	@Test public void example() {
		Util.testValidSyntax(TEST_DIRECTORY, "example.in");
	}

	@Test
	public void error() {
		Util.testSyntaxError(TEST_DIRECTORY, "error.in");
	}
	
	@Test public void emptyfunction() {
	    Util.testValidSyntax(TEST_DIRECTORY, "emptyfunction.in");
	}
	
	
	@Test public void emptyfunctions() {
	    Util.testValidSyntax(TEST_DIRECTORY, "emtpyfunctions.in");
	}
	
	
	@Test public void functionwithvariabledeclaration() {
	    Util.testValidSyntax(TEST_DIRECTORY, "functionwithvariabledeclaration.in");
	}
	
	
	@Test public void functionwithvariabledeclarations() {
	    Util.testValidSyntax(TEST_DIRECTORY, "functionwithvariabledeclarations.in");
	}
	
	
	@Test public void functionwithvariabledeclarationandassignments() {
	    Util.testValidSyntax(TEST_DIRECTORY, "functionwithvariabledeclarationandassignments.in");
	}
	
	@Test public void simpleexpressions() {
	    Util.testValidSyntax(TEST_DIRECTORY, "simpleexpressions.in");
	}
}
