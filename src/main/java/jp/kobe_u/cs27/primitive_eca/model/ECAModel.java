package jp.kobe_u.cs27.primitive_eca.model;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Reference;

import jp.kobe_u.cs27.primitive_eca.action.Action;
import jp.kobe_u.cs27.primitive_eca.service.Event;
import jp.kobe_u.cs27.primitive_eca.util.RandomGenerator;


@Entity("eca")
@Indexes(@Index(value = "value", fields = @Field("value") ))
public class ECAModel {
	@Id
	private ObjectId id;
	/*eventと参照関係を結ぶ*/
	@Reference
	private Event event;
	/*condtionと参照関係を結ぶ*/
	@Reference
	private ArrayList<ConditionModel> condList;
	@Reference
	private Action action;
	private String ecaId;
	public ECAModel(){
//		setEcaId(RandomGenerator.getRandomUniqueId());
	}
	public ECAModel(Event event, ArrayList<ConditionModel> cond, Action action){
		this.setEvent(event);
		this.setCondList(cond);
		this.setAction(action);
//		setEcaId(RandomGenerator.getRandomUniqueId());
	}
	
	
	

	public ArrayList<ConditionModel> getCondList() {
		return condList;
	}
	public void setCondList(ArrayList<ConditionModel> condList) {
		this.condList = condList;
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public ObjectId getEcaId() {
		return id;
	}

}
