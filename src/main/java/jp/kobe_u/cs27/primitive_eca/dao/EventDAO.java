package jp.kobe_u.cs27.primitive_eca.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import jp.kobe_u.cs27.primitive_eca.action.Action;
import jp.kobe_u.cs27.primitive_eca.db_helper.MorphiaUtil;
import jp.kobe_u.cs27.primitive_eca.model.ActionModel;
import jp.kobe_u.cs27.primitive_eca.model.EventModel;
import jp.kobe_u.cs27.primitive_eca.rule.Rule;
import jp.kobe_u.cs27.primitive_eca.service.Event;

/**
 * @author otokunaga
 *　開発方針:Modelと実際に実行するクラスは分離する
 * TODO:httpのバリデーション(jsでやるか？
 */
public class EventDAO {

	private Datastore dataStore = null;
	private static final String ID_KEY = "_id"; 
	private static final String URL = "url";
	public EventDAO(){
		dataStore = MorphiaUtil.getInstance();
	}
	public EventModel findAsEventModel(ObjectId id){
		return dataStore.find(EventModel.class).field(ID_KEY).equal(id).get();
	}
	

	public Event findEvent(Rule observer,ObjectId id){
		EventModel event = dataStore.find(EventModel.class).field(ID_KEY).equal(id).get();
		Event lEvent = new Event(observer,event.getUrl());
		return lEvent;
	}
	public boolean updateEvent(ObjectId aid, String url){
		Query<EventModel> udpateQuery = dataStore.createQuery(EventModel.class).field("_id").equal(aid);
		final UpdateOperations<EventModel> ops = dataStore.createUpdateOperations(EventModel.class).set(URL, url);
		final UpdateResults results = dataStore.update(udpateQuery, ops);
		return results.getUpdatedExisting();
		
	}
	public ObjectId save(Event event){
		EventModel em = new EventModel();
		em.setUrl(event.getUrl());
		em.setSeepTime(event.getMontoringInterval());
		Key<EventModel> key = dataStore.save(em);
		System.out.println(key);
		return (ObjectId) key.getId();
	}
	public List<Event> getEventAll(Rule rule){
		List<EventModel> eventList = dataStore.find(EventModel.class).asList();
		List<Event> lEventList = new ArrayList<Event>();
		for(EventModel event: eventList){
			Event e = new Event(rule, event.getUrl());
			if(e.getUrl() != null){
				lEventList.add(e);
			}
			
		}
		return lEventList;
	}
	public List<EventModel> getEventModel(){
		return dataStore.find(EventModel.class).asList();
	}

	
	
}
