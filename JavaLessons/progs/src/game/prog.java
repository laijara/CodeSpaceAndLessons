package game;
import java.util.Scanner;

class prog{
    private static final Scanner globalScanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hello world");
        globalScanner.nextLine();
        globalScanner.close();
    }
}

class Pet{
    private String name;
    private int hunger;
    private int energy;
    private int happiness;

    //Конструктор
    public Pet(String name, int hunger, int energy, int happiness){
        this.name = name;
        this.hunger = hunger;
        this.energy = energy;
        this.happiness = happiness;
    }

    //Геттеры
    public String getName(){
        return name;
    }
    public int getHunger(){
        return hunger;
    }
    public int getEnergy(){
        return energy;
    }
    public int getHappiness(){
        return happiness;
    }

    //Поведение
    public void feed(){
        if(this.energy <= 0){
            System.out.println("Питомец устал, дайте ему поспать!");
        }
        else if(this.energy - 1 < 0){
            System.out.println("Вы не можете это сделать, иначе питомец сильно устанет!");
        }
        else {
            this.hunger += 3;
            this.energy -= 1;
        }
    }
    public void play(){
        if(this.energy <= 0 || this.hunger <= 0){
            System.out.println("Питомец устал, дайте ему поспать или поесть!");
        }
        else if(this.energy - 2 < 0 || this.hunger - 2 < 0){
            System.out.println("Вы не можете это сделать, иначе питомец изголодает или сильно устанет!");
        }
        else {
            this.hunger -= 2;
            this.energy -= 2;
            this.happiness += 3;
        }
    }
    public void sleep(){
        if(this.hunger <= 0){
            System.out.println("Питомец устал, дайте ему поесть!");
        }
        else if(this.hunger - 1 < 0){
            System.out.println("Вы не можете это сделать, иначе питомец изголодает!");
        }
        else {
            this.hunger -= 1;
            this.energy += 5;
        }
    }

    //Другое
    public void CheckStatus(){
        System.out.println(getName());
        System.out.println(getHunger());
        System.out.println(getEnergy());
        System.out.println(getHappiness());
    }
}
