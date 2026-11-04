package com.aston.project.ui;

public class Menu {
    private final ConsoleUI ui = new ConsoleUI();

    public void start() {
        ui.printHeader();
        boolean isRunning = true;

        while (isRunning) {
            ui.printMainMenu();
            int choice = ui.readInt("Выберите действие: ", 0, 4);

            switch (choice) {
                case 1: handleInput(); break;
                case 2: handleOutput(); break;
                case 3: handleSort(); break;
                case 4: handleSearch(); break;
                case 0:
                    isRunning = false;
                    System.out.println("Завершение работы программы.");
                    break;
            }
        }
    }

    private void handleInput() {
        ui.printInputMenu();
        int choice = ui.readInt("Выберите способ ввода: ", 0, 3);

        switch (choice) {
            case 1:
                ui.printSuccess("Выбран ввод из файла.");
                break;
            case 2:
                ui.printSuccess("Выбран ручной ввод.");
                break;
            case 3:
                ui.printSuccess("Выбрана самогенерация.");
                break;
            case 0: return;
        }
        ui.waitForEnter();
    }

    private void handleOutput() {
        ui.printOutputMenu();
        int choice = ui.readInt("Выберите способ вывода: ", 0, 3);

        switch (choice) {
            case 1:
                ui.printSuccess("Вывод всех данных.");
                break;
            case 2:
                int length = ui.readInt("Введите длину для вывода: ", 1, 1000);
                ui.printSuccess("Вывод первых " + length + " элементов.");
                break;
            case 3:
                ui.printSuccess("Запись в файл.");
                break;
            case 0: return;
        }
        ui.waitForEnter();
    }

    private void handleSort() {
        ui.printSortMenu();
        int choice = ui.readInt("Выберите алгоритм: ", 0, 3);

        switch (choice) {
            case 1:
                ui.printSuccess("Сортировка Пузырьком.");
                break;
            case 2:
                ui.printSuccess("Сортировка Выбором.");
                break;
            case 3:
                ui.printSuccess("Сортировка Чет-нечет.");
                break;
            case 0: return;
        }
        ui.waitForEnter();
    }

    private void handleSearch() {
        ui.printSearchMenu();
        int choice = ui.readInt("Выберите действие: ", 0, 1);

        if (choice == 1) {
            String target = ui.readString("Введите элемент для поиска: ");
            ui.printSuccess("Поиск элемента: " + target);
        }
        ui.waitForEnter();
    }
}