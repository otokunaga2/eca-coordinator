package jp.kobe_u.cs27.primitive_eca.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

@Entity("action")
@Indexes(@Index(value = "value", fields = @Field("value") ))
public class ActionModel {
	@Id
	private ObjectId id;

	private String url;
	private String description;
	private String lastInvocation;

	public ActionModel(){
		
	}
	public ActionModel(String url, String desc, String updateTime){
		this.url = url;
		this.description = desc;
		this.lastInvocation = updateTime;
	}
	public ActionModel(String url, String description) {
	
		this.url = url;
		this.description = description;
		update();
	}
	
	
	public ObjectId getId(){
		return this.id;
	}

	/**
	 * DBの更新
	 *
	 * @return
	 */
	public boolean update() {
		return true;
	}

	
	public String getUrl() {
		return url;
	}

	public String getDescription() {
		return description;
	}

	

	public void setUrl(String url) {
		this.url = url;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLastInvocation() {
		return lastInvocation;
	}

	public void setLastInvocation(String lastInvocation) {
		this.lastInvocation = lastInvocation;
	}
}
