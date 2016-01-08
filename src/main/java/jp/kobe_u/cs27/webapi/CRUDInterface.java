package jp.kobe_u.cs27.webapi;

public interface CRUDInterface {
	public String save();
	public Object find(Object id);
	public boolean delete(String id);
	public boolean edit(String id);
}
