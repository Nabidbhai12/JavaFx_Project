package sample;

import java.io.Serializable;

public class Player implements Serializable {
    private String Name;
    private String Country;
    private int Age;
    private double Height;
    private String Clubname;
    private String Position;
    private int Number;
    private double weeklySalary;

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    private double Price;

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Player{" +
                "Name='" + Name + '\'' +
                ", Country='" + Country + '\'' +
                ", Age=" + Age +
                ", Height=" + Height +
                ", Club='" + Clubname + '\'' +
                ", Position='" + Position + '\'' +
                ", Number=" + Number +
                ", weeklySalary=" + weeklySalary +
                '}';
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }


    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(double height) {
        Height = height;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getClubname() {
        return Clubname;
    }

    public void setClubname(String club) {
        Clubname = club;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Player() {
    }

    public Player(String Name,String Country,int Age,double Height,String Club,String Position,int Number,double weeklySalary)
    {
        this.Clubname=Club;
        this.Name=Name;
        this.Country=Country;
        this.Age=Age;
        this.Height=Height;
        this.Position=Position;
        this.Number=Number;
        this.weeklySalary=weeklySalary;

    }
}
