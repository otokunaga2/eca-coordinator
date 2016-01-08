package jp.kobe_u.cs27.primitive_eca.dao;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import jp.kobe_u.cs27.primitive_eca.action.Action;
import jp.kobe_u.cs27.primitive_eca.db_helper.MorphiaUtil;
import jp.kobe_u.cs27.primitive_eca.util.ApplicationConf;

public class ActionDAO {
	private Datastore dataStore = null;
	private static final String ID_KEY = "_id"; 
	private static final String LASTINVOCATION ="lastInvocation";
	public ActionDAO(){
		dataStore = MorphiaUtil.getInstance();
	}
	
	public Action findAction(ObjectId id){
		Action action = dataStore.find(Action.class).field(ID_KEY).equal(id).get();
		return action;
	}
	public boolean updateAction(ObjectId aid){
		DateTime dateTime = new DateTime();
		Query<Action> udpateQuery = dataStore.createQuery(Action.class).field("_id").equal(aid);
		final UpdateOperations<Action> ops = dataStore.createUpdateOperations(Action.class).set(LASTINVOCATION, dateTime.now().toString(ApplicationConf.DATEPATTERN));
		final UpdateResults results = dataStore.update(udpateQuery, ops);
		return results.getUpdatedExisting();
		
	}
	public ObjectId save(Action action){
		Key<Action> key = dataStore.save(action);
		return (ObjectId) key.getId();
	}

	public void addActionList(Action action) {
		// TODO Auto-generated method stub
		
	}
	
}
