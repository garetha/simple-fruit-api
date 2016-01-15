package com.simplefruit.api.fruit;

import org.apache.commons.lang.StringUtils;

public enum Fruit {

    APPLE("1","1299","apple.jpg"),
    BANANA("2","399","banana.jpg"),
    DRAGON("3","1000","dragon.jpeg"),
    KIWI("4","199","kiwi.jpeg"),
    ORANGE("5","101","orange.jpg"),
    PINEAPPLE("6","291","pineapple.jpeg");

    public String id;
    public String name;
    public String price;
    public String image;

    Fruit(String id, String price, String image) {
        this.id = id;
        this.price = price;
        this.image = image;
        this.name = StringUtils.capitalize(name().toLowerCase());
    }

    public String getImage() {
        return image;
    }

    public String toJSON() {
        return "{" +
                "\"name\":\""+ name +"\"," +
                "\"price\":\"" + price + "\"," +
                "\"id\":\"" + id +
                "\"}";
    }

    public static Fruit getForId(String id) {
        for (Fruit fruit : values()) {
            if(StringUtils.equals(fruit.id, id)) {
                return fruit;
            }
        }
        return null;
    }
}
