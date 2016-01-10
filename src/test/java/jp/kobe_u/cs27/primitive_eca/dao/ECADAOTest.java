package jp.kobe_u.cs27.primitive_eca.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.kobe_u.cs27.primitive_eca.action.Action;
import jp.kobe_u.cs27.primitive_eca.dao.ActionDAO;
import jp.kobe_u.cs27.primitive_eca.dao.ConditionDAO;
import jp.kobe_u.cs27.primitive_eca.dao.ECADAO;
import jp.kobe_u.cs27.primitive_eca.dao.EventDAO;
import jp.kobe_u.cs27.primitive_eca.model.ActionModel;
import jp.kobe_u.cs27.primitive_eca.model.ConditionModel;
import jp.kobe_u.cs27.primitive_eca.model.ECAModel;
import jp.kobe_u.cs27.primitive_eca.model.EventModel;
import jp.kobe_u.cs27.primitive_eca.rule.Rule;
import jp.kobe_u.cs27.primitive_eca.service.Event;

public class ECADAOTest {
	private ECADAO ecaDAO;
	private Event event;
	private ConditionModel cond;
	private Rule observer;
	private Action action;
	
	private List<ConditionModel> conditonList;
	
	/*dao*/
	private EventDAO eventDAO;
	private ActionDAO actionDAO;
	private ConditionDAO conditionDAO;
	
	EventModel eventModel;
	ActionModel actionModel;
	ConditionModel conditionModel;
	
	EventModel savedEvent;
	ActionModel savedAction;
	ConditionModel savedCondtion;
	
	@Before
	public void setUp() throws Exception {
		observer = new Rule();
		ecaDAO = new ECADAO();
		event = new Event(observer,"http://example.com");
		cond = new ConditionModel("http://example.com");
		action = new Action();
		conditonList = new ArrayList<ConditionModel>();
		conditonList.add(cond);
		actionDAO = new ActionDAO();
		conditionDAO = new ConditionDAO();
		eventDAO = new EventDAO();
//		
		String id = eventDAO.save(event);
		savedEvent =eventDAO.findAsEventModel(id);
		
		ObjectId aid = actionDAO.save(action);
		savedAction = actionDAO.findActionAsModel(aid);
		
		ObjectId cid = conditionDAO.save(cond);
		savedCondtion = conditionDAO.find(cid);
		conditonList.add(savedCondtion);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		ECAModel eca = new ECAModel();
		eca.setAction(savedAction);
		eca.setCondList(conditonList);
		eca.setEvent(savedEvent);
		
		ObjectId savedId = ecaDAO.save(eca);
		assertNotNull(savedId);
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
