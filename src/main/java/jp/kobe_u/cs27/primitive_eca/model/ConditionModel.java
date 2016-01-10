package jp.kobe_u.cs27.primitive_eca.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

/**
 * @author otokunaga
 *
 */
@Entity("condition")
public class ConditionModel {
	@Id
	private ObjectId id;
	private String url;
	
	public ConditionModel(){
		
	}
	public ConditionModel(String url) {
		this.url = url;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
