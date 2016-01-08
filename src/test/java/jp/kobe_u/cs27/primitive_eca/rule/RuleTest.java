package jp.kobe_u.cs27.primitive_eca.rule;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.kobe_u.cs27.primitive_eca.action.Action;
import jp.kobe_u.cs27.primitive_eca.dao.PrimitiveEvent;

public class RuleTest {
	private Rule rule;
	private Action action;
	@Before
	public void setUp() throws Exception {
		rule = new Rule();
		action = new Action();
		PrimitiveEvent event = new PrimitiveEvent(rule, "http://192.168.100.107:8080/test-execution/webapi/myresource/test");
		
		rule.createRule(event, null, action);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUpdatePrimitiveEvent() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindActionWithEventId() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateRule() {
		rule.startMonitoring();
	}
	@Test
	public void testGetActionWithId(){
		rule.getActionWithId("a");
		assertNull(action);
	}
	

}
