package com.selva.todo;

import java.util.HashMap;
import java.util.Map;

public enum TodoDao {
    instance;

    private Map<String, Book> contentProvider = new HashMap<>();

    private TodoDao() {

        Book todo = new Book("1", "Learn REST");
        todo.setDescription("Read Jersey Official Docs");
        contentProvider.put("1", todo);
        todo = new Book("2", "Buy Milk");
        todo.setDescription("Buy Milk from Nandini outlet");
        contentProvider.put("2", todo);

    }
    public Map<String, Book> getModel(){
        return contentProvider;
    }

}