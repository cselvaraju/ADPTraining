package com.selva.todo;

import java.util.HashMap;
import java.util.Map;

public enum TodoDao {
    instance;

    private Map<String, Todo> contentProvider = new HashMap<>();

    private TodoDao() {

        Todo todo = new Todo("1", "Learn REST");
        todo.setDescription("Read Jersey Official Docs");
        contentProvider.put("1", todo);
        todo = new Todo("2", "Buy Milk");
        todo.setDescription("Buy Milk from Nandini outlet");
        contentProvider.put("2", todo);

    }
    public Map<String, Todo> getModel(){
        return contentProvider;
    }

}