package jp.kobe_u.cs27.primitive_eca.action;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ActionDAOTest {
	private ActionDAO actionDAO = null;
	@Before
	public void setUp() throws Exception {
		actionDAO = new ActionDAO();
		Action action = new Action("1", "http://example.com");
		actionDAO.addActionList(action);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test(){
		ArrayList<Action> actual = actionDAO.findWithEventId("1");
		assertFalse(actual.isEmpty());
	}

}
