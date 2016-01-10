package jp.kobe_u.cs27.primitive_eca.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

@Entity("event")
//@Indexes(@Index(value = "value", fields = @Field("value") ))
public class EventModel {
	@Id
	private ObjectId id;
	private String url;
	private long seepTime;
	public long getSeepTime() {
		return seepTime;
	}
	public void setSeepTime(long seepTime) {
		this.seepTime = seepTime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
