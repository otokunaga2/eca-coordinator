package jp.kobe_u.cs27.primitive_eca.webapi;

import java.io.IOException;

import org.bson.types.ObjectId;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.Module;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.module.SimpleModule;

public class ObjectIdSerializerModule extends SimpleModule {

	 public ObjectIdSerializerModule() {
	        super("ObjectIdSerializerModule", new Version(0, 1, 0, "alpha"));
	        this.addSerializer(ObjectId.class, new ObjectIdSerializer());
	    }

	    public class ObjectIdSerializer extends JsonSerializer<ObjectId> {


			@Override
			public void serialize(ObjectId arg0, JsonGenerator arg1, SerializerProvider arg2)
					throws IOException, JsonProcessingException {
				arg1.writeString(arg0.toString());
				// TODO Auto-generated method stub
				
			}
	    }
	
	

}
