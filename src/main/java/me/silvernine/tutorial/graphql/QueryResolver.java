package me.silvernine.tutorial.graphql;


import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class QueryResolver implements GraphQLQueryResolver {
    public String hello() {
        return "¡Hola, mundo!";
    }
}