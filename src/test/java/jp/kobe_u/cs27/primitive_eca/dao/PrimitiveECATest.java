package jp.kobe_u.cs27.primitive_eca.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.kobe_u.cs27.primitive_eca.model.ECAModel;
import jp.kobe_u.cs27.primitive_eca.rule.Rule;
import jp.kobe_u.cs27.primitive_eca.service.Event;

public class PrimitiveECATest {
	@SuppressWarnings("unused")
	private ECAModel eca;
	Event event;
	@Before
	public void setUp() throws Exception {
		Rule rule = new Rule();
		event =new Event(rule, "http://192.168.100.107:8080/test-execution/webapi/myresource/test");
		eca = new ECAModel();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
	}
	@Test
	public void testFindECAWithEvent(){
		
	}

}
