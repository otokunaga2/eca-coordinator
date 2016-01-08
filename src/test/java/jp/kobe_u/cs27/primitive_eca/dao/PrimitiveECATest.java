package jp.kobe_u.cs27.primitive_eca.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.kobe_u.cs27.primitive_eca.event.PrimitiveEvent;
import jp.kobe_u.cs27.primitive_eca.rule.Rule;

public class PrimitiveECATest {
	private PrimitiveECA eca;
	PrimitiveEvent event;
	@Before
	public void setUp() throws Exception {
		Rule rule = new Rule();
		event =new PrimitiveEvent(rule, "http://192.168.100.107:8080/test-execution/webapi/myresource/test");
		eca = new PrimitiveECA(event, null, null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
	}
	@Test
	public void testFindECAWithEvent(){
		PrimitiveECA eca2 = eca.findECAWithEvent(event);
		assertNotNull(eca2);
	}

}
