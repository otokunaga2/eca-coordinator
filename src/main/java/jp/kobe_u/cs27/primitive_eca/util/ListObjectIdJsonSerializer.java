package jp.kobe_u.cs27.primitive_eca.util;

import java.io.IOException;
import java.util.List;
 
import org.bson.types.ObjectId;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
 
/**
 * Custom Json serializer for List ObjectId type
 * 
 * @author Deisss (LGPLv3)
 * @version 0.1
 */
public class ListObjectIdJsonSerializer extends JsonSerializer<List<ObjectId>> {
    @Override
    public void serialize(List<ObjectId> list, JsonGenerator j, SerializerProvider s) throws IOException, JsonProcessingException {
        if(list == null) {
            j.writeNull();
        } else {
            j.writeStartArray();
            for(ObjectId o : list)
            {
                j.writeString(o.toString());
            }
            j.writeEndArray();
        }
    }
}