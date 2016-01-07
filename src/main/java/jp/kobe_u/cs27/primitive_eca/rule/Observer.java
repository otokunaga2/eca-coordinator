package jp.kobe_u.cs27.primitive_eca.rule;

import jp.kobe_u.cs27.primitive_eca.event.PrimitiveEvent;

public interface Observer {
	public abstract void update();

	public abstract void update(PrimitiveEvent primitiveContext);
}
