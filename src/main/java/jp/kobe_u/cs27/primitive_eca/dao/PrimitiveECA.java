package jp.kobe_u.cs27.primitive_eca.dao;

import java.rmi.server.UID;
import java.security.SecureRandom;
import java.util.ArrayList;

import jp.kobe_u.cs27.primitive_eca.action.Action;
import jp.kobe_u.cs27.primitive_eca.util.RandomGenerator;

public class PrimitiveECA {
	private PrimitiveEvent event;
	private ArrayList<PrimitiveCondition> condList;
	private Action action;
	private String ecaId;
	public PrimitiveECA(){
		setEcaId(RandomGenerator.getRandomUniqueId());
	}
	public PrimitiveECA(PrimitiveEvent event, ArrayList<PrimitiveCondition> cond, Action action){
		this.setEvent(event);
		this.setCondList(cond);
		this.setAction(action);
		setEcaId(RandomGenerator.getRandomUniqueId());
	}
	
	
	public PrimitiveECA findECAWithEvent(PrimitiveEvent eventObject) {
		//eventIdから参照する
		if(eventObject.equals(this.getEvent())){
			return this;
		}
		return null;
	}
	/**
	 * @param event
	 * @return
	 */
	public boolean deleteECA(PrimitiveEvent event){
		try{
			if(this.getEvent().equals(event)){
				this.setEvent(null);
				return true;
			}
		}catch (NullPointerException e){
			e.printStackTrace();
			return false;	
		}
		return false;
	}
	public ArrayList<PrimitiveCondition> getCondList() {
		return condList;
	}
	public void setCondList(ArrayList<PrimitiveCondition> condList) {
		this.condList = condList;
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	public PrimitiveEvent getEvent() {
		return event;
	}
	public void setEvent(PrimitiveEvent event) {
		this.event = event;
	}
	public String getEcaId() {
		return ecaId;
	}
	public void setEcaId(String ecaId) {
		this.ecaId = ecaId;
	}

}
