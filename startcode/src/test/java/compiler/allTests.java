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

	@Test
	public void testLevel1() throws IOException {
		String output = this.getCSSOutput("level1.icss");
		String expected = this.readFile("level1.css");
		assertEquals(expected, output);
	}

	@Test
	public void testLevel2() throws IOException {
		String output = this.getCSSOutput("level2.icss");
		String expected = this.readFile("level2.css");
		assertEquals(expected, output);
	}

	@Test
	public void testLevel3() throws IOException {
		String output = this.getCSSOutput("level3.icss");
		String expected = this.readFile("level3.css");
		assertEquals(expected, output);
	}

	@Test
	public void testPA01T3() throws IOException {
		String output = this.getCSSOutput("PA01-T3.icss");
		String expected = this.readFile("PA01-T3.css");
		assertEquals(expected, output);
	}

	@Test
	public void testCH01T2() throws IOException {
		Pipeline pipeline = new Pipeline();
		pipeline.parseString(this.readFile("CH01-T2.icss"));
		boolean success = pipeline.check();
		assertFalse(success, "Checker should detect any errors");
	}

	@Test
	public void testCH02T1() throws IOException {
		String output = this.getCSSOutput("CH02-T1.icss");
		String expected = this.readFile("CH02-T1.css");
		assertEquals(expected, output);
	}

	@Test
	public void testCH02T2() throws IOException {
		String output = this.getCSSOutput("CH02-T2.icss");
		String expected = readFile("CH02-T2.css");
		assertEquals(expected, output);
	}

	@Test
	public void testCH03T1() throws IOException {
		Pipeline pipeline = new Pipeline();
		pipeline.parseString(this.readFile("CH03-T1.icss"));
		assertFalse(pipeline.isParsed());
	}

	@Test
	public void testTR01T1() throws IOException {
		String output = this.getCSSOutput("TR01-T1.icss");
		String expected = this.readFile("TR01-T1.css");
		assertEquals(expected, output);
	}

	@Test
	public void testTR01T3() throws IOException {
		String output = this.getCSSOutput("TR01-T3.icss");
		String expected = this.readFile("TR01-T3.css");
		assertEquals(expected, output);
	}
}
