package com.fiap.produto.domain;

public class Category {
    private long id;
    private String name;
    private String description;

    public Category (){
    }

    public Category(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public Category(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
    }
    public static class Builder{
        private long id;
        private String name;
        private String description;

        public Builder id(long id){
            this.id = id;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Category build(){
            return new Category(this);
        }
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
