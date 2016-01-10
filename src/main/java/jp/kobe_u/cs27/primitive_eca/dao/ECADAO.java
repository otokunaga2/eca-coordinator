package jp.kobe_u.cs27.primitive_eca.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import jp.kobe_u.cs27.primitive_eca.action.Action;
import jp.kobe_u.cs27.primitive_eca.db_helper.MorphiaUtil;
import jp.kobe_u.cs27.primitive_eca.model.ActionModel;
import jp.kobe_u.cs27.primitive_eca.model.ECAModel;
import jp.kobe_u.cs27.primitive_eca.model.EventModel;
import jp.kobe_u.cs27.primitive_eca.rule.Rule;
import jp.kobe_u.cs27.primitive_eca.service.Event;

public class ECADAO {
	private Datastore dataStore;
	private final String KEY = "_id";
	private EventDAO eventDAO = null;
	private List<ECAModel> ecaList = null;
	public ECADAO(){
		eventDAO = new EventDAO();
		dataStore = MorphiaUtil.getInstance();
		ecaList = new ArrayList<ECAModel>();
	}
	
	public ObjectId save(ECAModel eca){
		
		Key<ECAModel> model = dataStore.save(eca);
		return (ObjectId)model.getId();
	}
	public boolean update(ECAModel eca){
		return true;
	}
	public ECAModel findECA(){
		
		return null;
	}
	public List<ECAModel> getAllECA(){
		return null;
	}
	public Action getAction(){
		return null;
		
	}
	
	
	public List<Event> getEvent(Rule rule){
		return eventDAO.getEventAll(rule);
	}
	
	public ECAModel getECAModelWithId(ObjectId id){
		Query<EventModel> udpateQuery = dataStore.createQuery(EventModel.class).field("_id").equal(id);
		//final UpdateOperations<EventModel> ops = dataStore.createUpdateOperations(EventModel.class).set(URL, url);
		ECAModel model = (ECAModel) dataStore.find(ECAModel.class).field(KEY).equal(id);
		System.out.println(model.getEcaId()); 
		return model;
	}
	/**
	 * @param event
	 * @return
	 */
	public boolean deleteECA(ECAModel event){
		try{
			ECAModel model = getECAModelWithId(event.getEcaId());
			
			
		}catch (NullPointerException e){
			e.printStackTrace();
			return false;	
		}
		return false;
	}

	public ECAModel findECA(ECAModel eca) {
		for(ECAModel currECA:this.ecaList){
			if(eca.equals(currECA)){
				return currECA;
			}
		}
		return null;
	}
}
