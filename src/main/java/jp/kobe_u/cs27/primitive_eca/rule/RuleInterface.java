package jp.kobe_u.cs27.primitive_eca.rule;

import java.util.ArrayList;

import jp.kobe_u.cs27.primitive_eca.action.Action;
import jp.kobe_u.cs27.primitive_eca.model.ConditionModel;

public interface RuleInterface {
	public boolean isEnable();
	public boolean isExecute(Action action);
	public ArrayList<ConditionModel> getConditionList(); 
}
