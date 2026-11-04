package com.aston.project.ui;

import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BOLD = "\u001B[1m";

    public void printHeader() {
        System.out.println(CYAN + "=".repeat(80) + RESET);
        System.out.println(BOLD + "           СИСТЕМА УПРАВЛЕНИЯ ПОЛЬЗОВАТЕЛЯМИ " + RESET);
        System.out.println(CYAN + "=".repeat(80) + RESET);
    }

    public void printMainMenu() {
        System.out.println("\n" + BOLD + "[ГЛАВНОЕ МЕНЮ]" + RESET);
        System.out.println("1. Ввод данных");
        System.out.println("2. Вывод данных");
        System.out.println("3. Выбор метода сортировки");
        System.out.println("4. Поиск");
        System.out.println("0. Выход");
        System.out.println(CYAN + "-".repeat(80) + RESET);
    }

    public void printInputMenu() {
        System.out.println("\n" + BOLD + "[ВВОД ДАННЫХ]" + RESET);
        System.out.println("1. Из файла");
        System.out.println("2. Вручную");
        System.out.println("3. Рандомные (самогенерация)");
        System.out.println("0. Назад");
    }

    public void printOutputMenu() {
        System.out.println("\n" + BOLD + "[ВЫВОД ДАННЫХ]" + RESET);
        System.out.println("1. Вывести все данные");
        System.out.println("2. Вывести определенную длину");
        System.out.println("3. Запись в файл");
        System.out.println("0. Назад");
    }

    public void printSortMenu() {
        System.out.println("\n" + BOLD + "[МЕТОДЫ СОРТИРОВКИ]" + RESET);
        System.out.println("1. Пузырьковая (Bubble)");
        System.out.println("2. Выбором (Selection)");
        System.out.println("3. Чет-нечет (Специальная)");
        System.out.println("0. Назад");
    }

    public void printSearchMenu() {
        System.out.println("\n" + BOLD + "[ПОИСК]" + RESET);
        System.out.println("1. Найти количество вхождений");
        System.out.println("0. Назад");
    }

    public int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int number = Integer.parseInt(input);
                if (number >= min && number <= max) return number;
                System.out.println(RED + "Ошибка: введите число от " + min + " до " + max + RESET);
            } catch (NumberFormatException e) {
                System.out.println(RED + "Ошибка: '" + input + "' — это не число." + RESET);
            }
        }
    }

    public String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println(RED + "Ошибка: строка не может быть пустой." + RESET);
        }
    }

    public void printSuccess(String msg) {
        System.out.println(GREEN + "[УСПЕХ] " + msg + RESET);
    }

    public void printError(String msg) {
        System.out.println(RED + "[ОШИБКА] " + msg + RESET);
    }

    public void printWarning(String msg) {
        System.out.println(YELLOW + "[ВНИМАНИЕ] " + msg + RESET);
    }

    public void waitForEnter() {
        System.out.print(CYAN + "\nНажмите Enter для продолжения..." + RESET);
        scanner.nextLine();
    }
}