package lang;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lang.ast.ErrorMessage;
import lang.ast.Program;

/**
 * This is a parameterized test: one test case is generated for each input
 * file found in TEST_DIRECTORY. Input files should have the ".in" extension.
 */
@RunWith(Parameterized.class)
public class TestInterpreter extends AbstractParameterizedTest{

	private static final String TEST_DIR = "testfiles/interpreter";

	/** Directory where the test input files are stored. */
	private static final File TEST_DIRECTORY = new File("testfiles/interpreter");

	//private final String filename;

	public TestInterpreter(String filename) {
		//filename = testFile;
        super(TEST_DIR, filename);
	}

    @Test
    public void runTest() throws Exception {
        PrintStream out = System.out;
        try {
            Program program = (Program) parse(inFile);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));
            program.eval();
            compareOutput(baos.toString(), outFile, expectedFile);
        } finally {
            System.setOut(out); 
        }
    }

	@Parameters(name = "{0}")
	public static Iterable<Object[]> getTests() {
		return Util.getTestParameters(TEST_DIRECTORY, ".in");
	}
}

