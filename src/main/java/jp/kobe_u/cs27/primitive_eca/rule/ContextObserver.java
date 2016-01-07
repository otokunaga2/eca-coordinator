package jp.kobe_u.cs27.primitive_eca.rule;

import java.util.ArrayList;

import jp.kobe_u.cs27.primitive_eca.action.Action;
import jp.kobe_u.cs27.primitive_eca.action.ActionDAO;
import jp.kobe_u.cs27.primitive_eca.dao.PrimitiveCondition;
import jp.kobe_u.cs27.primitive_eca.event.PrimitiveEvent;
import jp.kobe_u.cs27.primitive_eca.http_handler.HttpHelper;

public class ContextObserver implements Observer {

	private HttpHelper httpHelper; 
	private PrimitiveEvent context = null;
	private PrimitiveCondition conditon = null;
	private ActionDAO actionDAO;
	public ContextObserver() {
		httpHelper = new HttpHelper();
		actionDAO = new ActionDAO();
	}
	
	
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * updateがあった時点でfalse->trueは確定
	 * なので、以降はしゅくしゅくとhttpの実行を行う
	 */
	@Override
	public void update(PrimitiveEvent primitiveEvent) {
		// TODO Auto-generated method stub
		System.out.println("confirm");
		ArrayList<PrimitiveCondition> conditionList = primitiveEvent.getConditionList();
		for(PrimitiveCondition condition: conditionList){
			System.out.println(condition.getId());
			boolean isCondition = httpHelper.parseHttpEndpoint(condition.getUrl());
			if(isCondition){
				
			}
		}
	}
	
	public Action findActionWithEventId(String id){
		
		return null;
	}
	
	public String createRule(PrimitiveEvent event, PrimitiveCondition cond, Action action){
		return null;
	}
	
	
	
	
	
	
}
