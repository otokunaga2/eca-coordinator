package jp.kobe_u.cs27.primitive_eca.rule;

import java.util.ArrayList;

import jp.kobe_u.cs27.primitive_eca.dao.PrimitiveCondition;

public interface RuleInterface {
	public boolean isEnable();
	public ArrayList<PrimitiveCondition> getConditionList(); 
}
