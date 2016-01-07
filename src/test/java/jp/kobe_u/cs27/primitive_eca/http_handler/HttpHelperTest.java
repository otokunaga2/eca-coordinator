package jp.kobe_u.cs27.primitive_eca.http_handler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HttpHelperTest {
	HttpHelper helper;
	@Before
	public void setUp() throws Exception {
		helper = new HttpHelper();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParseHttpEndpoint() {
		boolean expectedTrue = helper.parseHttpEndpoint("http://192.168.100.107:8080/test-execution/webapi/myresource/test");
		assertTrue(expectedTrue);
	}

}
