package jp.kobe_u.cs27.primitive_eca.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.kobe_u.cs27.primitive_eca.action.Action;
import jp.kobe_u.cs27.primitive_eca.model.ConditionModel;
import jp.kobe_u.cs27.primitive_eca.model.ECAModel;
import jp.kobe_u.cs27.primitive_eca.rule.Rule;
import jp.kobe_u.cs27.primitive_eca.service.Event;

public class ECADAOTest {
	private ECADAO ecaDAO;
	private Event event;
	private ConditionModel cond;
	private Rule observer;
	private Action action;
	private ArrayList<ConditionModel> conditonList;
	@Before
	public void setUp() throws Exception {
		observer = new Rule();
		ecaDAO = new ECADAO();
		event = new Event(observer,"http://example.com");
		cond = new ConditionModel("http://example.com");
		action = new Action();
		conditonList = new ArrayList<ConditionModel>();
		conditonList.add(cond);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		ECAModel eca = new ECAModel();
		eca.setAction(action);
		eca.setCondList(conditonList);
		eca.setEvent(event);
		ObjectId id = ecaDAO.save(eca);
		System.out.println(id);
		assertNotNull(id);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindECA() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllECA() {
		fail("Not yet implemented");
	}

}
