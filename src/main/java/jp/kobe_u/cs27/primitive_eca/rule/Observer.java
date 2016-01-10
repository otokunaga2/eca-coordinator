package jp.kobe_u.cs27.primitive_eca.rule;

import jp.kobe_u.cs27.primitive_eca.service.Event;

/**
 * @author otokunaga
 *
 */
public interface Observer {
	public abstract void update();

	public abstract void update(Event primitiveContext);
}
