package jp.kobe_u.cs27.primitive_eca.webapi;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class MyApplication extends Application {
	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<Class<?>>();
        resources.add(JacksonObjectMapperProvider.class);
        resources.add(MyResource.class);
        return resources;
    }
}
