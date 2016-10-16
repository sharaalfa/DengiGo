package com.ushara.dengigo.service.rest;

@Controller
@Path("hello/{name}")
public class HelloService {
    @GET
    @Produces("text/plain")
    public String sayHello(@PathParam("name") String name){
        StringBuilder stringBuilder = new StringBuilder("Hello, ");
        stringBuilder.append(name).append("!");
        return stringBuilder.toString();
    }
}
