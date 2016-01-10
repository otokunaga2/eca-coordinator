package jp.kobe_u.cs27.primitive_eca.webapi;

import java.util.List;

import jp.kobe_u.cs27.primitive_eca.dao.EventDAO;
import jp.kobe_u.cs27.primitive_eca.model.EventModel;

public class EventController {
	private EventDAO dao = null;
	public EventController(){
		dao = new EventDAO();
	}
	
	public List<EventModel> getAllEvent(){
		return dao.getEventModel();
	}
	public EventModel getOneEvent(){
		return dao.getEventModel().get(0);
	}
}
