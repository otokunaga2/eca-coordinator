package jp.kobe_u.cs27.primitive_eca.http_handler;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import jp.kobe_u.cs27.primitive_eca.http_handler.HttpHelper;
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
		boolean expectedTrue = helper.fakeGetHttpResponse();
		
		assertTrue(expectedTrue);
	}

}
