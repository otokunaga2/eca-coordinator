package jp.kobe_u.cs27.primitive_eca.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.kobe_u.cs27.primitive_eca.action.Action;
import jp.kobe_u.cs27.primitive_eca.dao.ActionDAO;
import jp.kobe_u.cs27.primitive_eca.model.ActionModel;

public class ActionDAOTest {
	ActionDAO actiondao;
	@Before
	public void setUp() throws Exception {
		actiondao = new ActionDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		Action action = new Action("http://example.com");
		ObjectId isSave = actiondao.save(action);
		assertNotNull(isSave);
	}
	
	@Test
	public void testFindAll(){
		List<Action> actionList = actiondao.getAllActin();
		assertFalse(actionList.isEmpty());	
	}

}
