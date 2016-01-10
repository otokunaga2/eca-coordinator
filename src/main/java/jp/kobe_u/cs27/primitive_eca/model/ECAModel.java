package jp.kobe_u.cs27.primitive_eca.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;


@Entity("eca")
public class ECAModel {
	@Id
	private ObjectId id;
	/*eventと参照関係を結ぶ*/
	@Reference
	private EventModel event;
	/*condtionと参照関係を結ぶ*/
	
	@Reference
	private List<ConditionModel> condList;
	
	@Reference
	private ActionModel action;
	private String ecaId;
	
	
	public ECAModel(){
//		setEcaId(RandomGenerator.getRandomUniqueId());
		
	}
	public ECAModel(EventModel event, ArrayList<ConditionModel> cond, ActionModel action){
		this.setEvent(event);
		this.setCondList(cond);
		this.setAction(action);
		
//		setEcaId(RandomGenerator.getRandomUniqueId());
	}



	public List<ConditionModel> getCondList() {
		return condList;
	}
	public void setCondList(List<ConditionModel> conditonList) {
		this.condList = conditonList;
	}
	public ActionModel getAction() {
		return action;
	}
	public void setAction(ActionModel action) {
		this.action = action;
	}
	public EventModel getEvent() {
		return event;
	}
	public void setEvent(EventModel event) {
		this.event = event;
	}
	public ObjectId getEcaId() {
		return id;
	}

}
