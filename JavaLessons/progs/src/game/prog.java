package game;
import java.util.Scanner;

class prog{
    private static final Scanner globalScanner = new Scanner(System.in);
    public static void main(String[] args) {
        prog.StartProgram();
        System.out.println("\n\nНажмите Enter для продолжения!");
        globalScanner.nextLine();
        globalScanner.close();
    }
    private static void StartProgram(){
        System.out.print("Введите имя питомца - ");
        Pet dog = new Pet(globalScanner.nextLine(), 5, 5, 5);
        int input;
        while (true){
            System.out.println("\n\n\n\n\n===================================");
            System.out.println("Выберите пункт:");
            System.out.println("0 - Выход");
            System.out.println("1 - Узнать статус питомца");
            System.out.println("2 - Покормить");
            System.out.println("3 - Поиграть");
            System.out.println("4 - Уложить спать");
            System.out.print("Вводите - ");
            input = globalScanner.nextInt();
            globalScanner.nextLine();
            switch (input){
                case 0:
                    return;
                case 1:
                    System.out.println("\n\n====================");
                    System.out.println("Статус питомца:");
                    dog.CheckStatus();
                    globalScanner.nextLine();
                    break;
                case 2:
                    System.out.println("\n\n====================");
                    System.out.println("Вы покормили " + dog.getName() + "! Нажмите Enter для продолжения!");
                    dog.feed();
                    globalScanner.nextLine();
                    break;
                case 3:
                    System.out.println("\n\n====================");
                    System.out.println("Вы поиграли с " + dog.getName() + "! Нажмите Enter для продолжения!");
                    dog.play();
                    globalScanner.nextLine();
                    break;
                case 4:
                    System.out.println("\n\n====================");
                    System.out.println("Вы уложили " + dog.getName() + " спать! Нажмите Enter для продолжения!");
                    dog.sleep();
                    globalScanner.nextLine();
                    break;
                default:
                    System.out.println("\n\n====================");
                    System.out.println("Ошибка ввода! Нажмите Enter для продолжения!");
                    globalScanner.nextLine();
                    break;
            }
        }
    }
}

class Pet{
    private final String name;
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
            System.out.println(this.name + " устал, дайте ему поспать!");
        }
        else if(this.energy - 1 < 0){
            System.out.println("Вы не можете это сделать, иначе " + this.name + " сильно устанет!");
        }
        else if(this.hunger >= 10) {
            System.out.println(this.name + " не может есть! Он наелся");
        }
        else {
            this.hunger += 3;
            this.energy -= 1;
        }
    }
    public void play(){
        if(this.energy <= 0 || this.hunger <= 0){
            System.out.println(this.name + " устал, дайте ему поспать или поесть!");
        }
        else if(this.energy - 2 < 0 || this.hunger - 2 < 0){
            System.out.println("Вы не можете это сделать, иначе " + this.name + " изголодает или сильно устанет!");
        }
        else if (this.happiness >= 10) {
            System.out.println(this.name + " не может играть! Он наигрался!");
        }
        else {
            this.hunger -= 2;
            this.energy -= 2;
            this.happiness += 3;
        }
    }
    public void sleep(){
        if(this.hunger <= 0){
            System.out.println(this.name + " голоден, дайте ему поесть!");
        }
        else if(this.hunger - 1 < 0){
            System.out.println("Вы не можете это сделать, иначе " + this.name + " изголодает!");
        }
        else if (this.energy >= 10) {
            System.out.println(this.name + " не может играть! Он наигрался");
        }
        else {
            this.hunger -= 1;
            this.energy += 5;
        }
    }

    //Другое
    public void CheckStatus(){
        System.out.println("Имя - " + getName());
        System.out.println("Сытость - " + getHunger());
        System.out.println("Энергия - " + getEnergy());
        System.out.println("Счастье - " + getHappiness());
    }
}
