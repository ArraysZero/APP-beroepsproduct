package compiler;

import nl.han.ica.icss.Pipeline;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class allTests {
	private String readFile(String resource) throws IOException {
		File file = new File(String.format("./src/test/resources/%s", resource));

		InputStream inputStream = new FileInputStream(file);
		CharStream charStream = CharStreams.fromStream(inputStream);
		return charStream.toString().replaceAll("\r\n", "\n");
	}

	private String getCSSOutput(String filename) throws IOException {
		Pipeline pipeline = new Pipeline();
		pipeline.parseString(this.readFile(filename));
		boolean success = pipeline.check();
		assertTrue(success, String.format("Checker should not detect any errors, detected: %s", pipeline.getErrors()));
		pipeline.transform();
		return pipeline.generate();
	}

	@Test
	public void testLevel0() throws IOException {
		String output = this.getCSSOutput("level0.icss");
		String expected = this.readFile("level0.css");
		assertEquals(expected, output);
	}
}
