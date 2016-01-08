package jp.kobe_u.cs27.primitive_eca.event;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.kobe_u.cs27.primitive_eca.rule.Rule;
import jp.kobe_u.cs27.primitive_eca.rule.Observer;

public class PrimitiveContextTest {
	private PrimitiveEvent context;
	private Rule observer;
	private final String url ="http://192.168.100.107:8080/test-execution/webapi/myresource/test";
	@Before
	public void setUp() throws Exception {
		Observer observer = new Rule();
		
		context = new PrimitiveEvent(observer,url);
		observer = new Rule();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddObserver() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyObservers() {
		context.setTimer(1000);
	}

	@Test
	public void testSetTimer() {
		fail("Not yet implemented");
	}

	@Test
	public void testTimerTaskStop() {
		fail("Not yet implemented");
	}

}
