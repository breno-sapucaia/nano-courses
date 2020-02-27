package com.fiap.produto.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@SequenceGenerator(allocationSize = 50, initialValue = 1, name = "prod_seq", sequenceName = "prod_seq")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "prod_seq")
    private long id;
    @NotNull
    private String name;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Category category;


    public Product() {
    }
    public Product(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.category = builder.category;
    }
    public static class Builder{
        private long id;
        private String name;
        private String description;
        private Category category;

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder description(String description){
            this.description = description;
            return this;
        }
        public Builder id(long id){
            this.id = id;
            return this;
        }
        public Builder category(Category category){
            this.category = category;
            return this;
        }
        public Product build(){
            return new Product(this);
        }


    }
    public Product(long id, String name, String description, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
