package org.example;

public class Person {
     String name;
     String hairColor;
     String skinColor;
     int height;
     int weight;
     int yearOfBirth;

    public Person(String name) {
        this.name = name;
        this.hairColor = getRandomString(new String[]{"red", "black", "yellow", "brown", "blue"});
        this.skinColor = getRandomString(new String[]{"yellow","white","black"});
        this.height = getRandomNumber(50,190);
        this.weight = getRandomNumber(1,200);
        this.yearOfBirth = getRandomNumber(1970,2023);
    }

    private String getRandomString(String[] strings){
        int index = getRandomNumber(0,strings.length-1);
        return strings[index];
    }
    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void info(){
        System.out.println(this.name);
        System.out.println(this.hairColor);
        System.out.println(this.skinColor);
        System.out.println(this.height + " cm");
        System.out.println(this.weight + " kg");
        System.out.println(this.yearOfBirth);
        System.out.println("---------------------");
    }

    public String getName() {
        return name;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
