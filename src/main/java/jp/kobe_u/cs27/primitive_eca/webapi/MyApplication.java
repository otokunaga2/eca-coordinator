package jp.kobe_u.cs27.primitive_eca.webapi;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;

import jp.kobe_u.cs27.primitive_eca.endpoint.MyResource;
import jp.kobe_u.cs27.primitive_eca.util.ListObjectIdJsonSerializer;

public class MyApplication extends Application {
	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<Class<?>>();
        resources.add(JacksonFeature.class);
        resources.add(JacksonObjectMapperProvider.class);
        resources.add(ListObjectIdJsonSerializer.class);
        resources.add(MyResource.class);
        return resources;
    }
}
