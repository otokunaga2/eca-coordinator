package jp.kobe_u.cs27.primitive_eca.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.kobe_u.cs27.primitive_eca.rule.Rule;
import jp.kobe_u.cs27.primitive_eca.service.Event;

public class EventDAOTest {
	private EventDAO eventDAO = null;
	private ObjectId savedId;
	private ObjectId shouldSaveId;
	Event em;
	private Rule observer;
	private static final String urlSample = "http://example.com";
	@Before
	public void setUp() throws Exception {
		eventDAO = new EventDAO();
		em =new Event(observer,urlSample);
		observer = new Rule();
		savedId = eventDAO.save(em);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindEvent() {
		Event em = eventDAO.findEvent(observer,savedId);	
		assertNotNull(em);
	}
	
	@Test
	public void findAllEvent(){
		List<Event> list = eventDAO.getEventAll(observer);
		assertFalse(list.isEmpty());
	}

	@Test
	public void testUpdateEvent() {
		
		
	}

	@Test
	public void testSave() {
		em.setUrl("http://exampl1e.com");
		Event test = new Event(observer,urlSample);
		shouldSaveId = eventDAO.save(test);
		assertNotNull(shouldSaveId);
	}

	@Test
	public void testAddEventIntoList() {
		
	}

}
