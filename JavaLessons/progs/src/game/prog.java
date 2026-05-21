package game;

import javax.swing.*;
import java.awt.*;

class prog {
    // Делаем эти переменные статическими полями класса,
    // чтобы к ним был доступ из кнопок
    private static Pet dog;
    private static JLabel statusLabel;
    private static JLabel messageLabel;

    public static void main(String[] args) {
        // 1. Инициализация логики (наш "Повар")
        dog = new Pet("Бобик", 5, 5, 5);

        // 2. Создаем главное окно (наш новый "Официант")
        JFrame frame = new JFrame("Тамагочи: " + dog.getName());
        frame.setSize(400, 300); // Размеры окна (Ширина x Высота)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Программа завершится при закрытии окна на крестик
        frame.setLayout(new BorderLayout()); // Менеджер компоновки (располагает элементы по краям и центру)

        // 3. Создаем текст со статусом и ставим его НАВЕРХ (NORTH)
        statusLabel = new JLabel(getStatusText(), SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Делаем шрифт побольше
        frame.add(statusLabel, BorderLayout.NORTH);

        // 4. Создаем текст для сообщений ("Вы покормили...") и ставим в ЦЕНТР (CENTER)
        messageLabel = new JLabel("Добро пожаловать в игру!", SwingConstants.CENTER);
        frame.add(messageLabel, BorderLayout.CENTER);

        // 5. Создаем панель для кнопок
        JPanel buttonPanel = new JPanel();
        JButton feedButton = new JButton("Покормить");
        JButton playButton = new JButton("Поиграть");
        JButton sleepButton = new JButton("Спать");

        // Кладем кнопки на панель
        buttonPanel.add(feedButton);
        buttonPanel.add(playButton);
        buttonPanel.add(sleepButton);

        // Ставим панель с кнопками ВНИЗ окна (SOUTH)
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // 6. ОЖИВЛЯЕМ КНОПКИ (Событийно-ориентированное программирование)
        feedButton.addActionListener(e -> {
            String result = dog.feed(); // Вызываем метод
            updateScreen(result);       // Обновляем экран
        });

        playButton.addActionListener(e -> {
            String result = dog.play();
            updateScreen(result);
        });

        sleepButton.addActionListener(e -> {
            String result = dog.sleep();
            updateScreen(result);
        });

        // 7. Финальные настройки окна
        frame.setLocationRelativeTo(null); // Окно появится ровно по центру экрана
        frame.setVisible(true); // Включаем видимость окна (всегда делается в самом конце!)
    }

    // --- Вспомогательные методы ---

    // Метод, который обновляет текст на экране после каждого нажатия кнопки
    private static void updateScreen(String message) {
        messageLabel.setText(message); // Выводим ответ от питомца
        statusLabel.setText(getStatusText()); // Обновляем цифры характеристик
    }

    // Метод для склеивания статуса (Используем HTML-тег, чтобы текст не сливался)
    private static String getStatusText() {
        return "<html>Сытость: " + dog.getHunger() +
                " | Энергия: " + dog.getEnergy() +
                " | Счастье: " + dog.getHappiness() + "</html>";
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
    public String feed(){
        if(this.energy <= 0){
            return this.name + " устал, дайте ему поспать!";
        }
        else if(this.energy - 1 < 0){
            return "Вы не можете это сделать, иначе " + this.name + " сильно устанет!";
        }
        else if(this.hunger >= 10) {
            return this.name + " не может есть! Он наелся";
        }
        else {
            this.hunger += 3;
            this.energy -= 1;
            return this.name + " вкусно поел!!! Ом-ном-ном!!!";
        }
    }
    public String play(){
        if(this.energy <= 0 || this.hunger <= 0){
            return this.name + " устал, дайте ему поспать или поесть!";
        }
        else if(this.energy - 2 < 0 || this.hunger - 2 < 0){
            return "Вы не можете это сделать, иначе " + this.name + " изголодает или сильно устанет!";
        }
        else if (this.happiness >= 10) {
            return this.name + " не может играть! Он наигрался!";
        }
        else {
            this.hunger -= 2;
            this.energy -= 2;
            this.happiness += 3;
            return this.name + " поигрался! Уииии!";
        }
    }
    public String sleep(){
        if(this.hunger <= 0){
            return this.name + " голоден, дайте ему поесть!";
        }
        else if(this.hunger - 1 < 0){
            return "Вы не можете это сделать, иначе " + this.name + " изголодает!";
        }
        else if (this.energy >= 10) {
            return this.name + " не может играть! Он наигрался";
        }
        else {
            this.hunger -= 1;
            this.energy += 5;
            return this.name + " идёт баиньки!!! уаааах!";
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
