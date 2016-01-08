package jp.kobe_u.cs27.primitive_eca.action;

import java.util.ArrayList;

public class ActionDAO {
	private ArrayList<Action> actionList = null;
	
	public ActionDAO() {
		actionList = new ArrayList<Action>();
	}
	public boolean update(){
		
		
		return false;
	}
	
	
	
	public void addActionList(Action action){
		actionList.add(action);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<Action> findWithEventId(String id){
		/**
		 * todo 
		 *  DBとの連携
		 *  idから特定のアクションをさがすように修正
		 */
		ArrayList<Action> result = new ArrayList<Action>();
		for(Action action: this.actionList){
			if(id.equals(action.getActionId())){
				result.add(action);
			}
		}
		return result;
	}
}
