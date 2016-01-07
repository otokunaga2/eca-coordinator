package jp.kobe_u.cs27.primitive_eca.rule;

import java.util.ArrayList;

import jp.kobe_u.cs27.primitive_eca.dao.PrimitiveCondition;

public class Rule implements RuleInterface {

	/* 
	 * event && conditionの条件が一致した時にアクションを実行する
	 */
	@Override
	public boolean isEnable() {
		
		return false;
	}

	@Override
	public ArrayList<PrimitiveCondition> getConditionList() {
		
		
		return null;
	}

}
