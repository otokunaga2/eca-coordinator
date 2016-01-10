package jp.kobe_u.cs27.primitive_eca.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import jp.kobe_u.cs27.primitive_eca.webapi.ObjectIdSerializerModule.ObjectIdSerializer;

@XmlRootElement
@Entity("event")
//@Indexes(@Index(value = "value", fields = @Field("value") ))
public class EventModel {

	@Id
	private ObjectId id;
	private String url;
	private long monitoringInterval;
	public long getSeepTime() {
		return monitoringInterval;
	}
	public void setSeepTime(long seepTime) {
		this.monitoringInterval = seepTime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@JsonSerialize(using=ObjectIdSerializer.class)
	public ObjectId getId() {
		return id;
	}
	@JsonSerialize(using=ObjectIdSerializer.class)
	public void setId(ObjectId id) {
		this.id = id;
	}
}
