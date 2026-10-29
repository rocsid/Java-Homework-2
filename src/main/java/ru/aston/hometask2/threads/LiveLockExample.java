package ru.aston.hometask2.threads;

public class LiveLockExample {
    static class Person {
        private String name;
        private boolean isMoving = true;

        public Person(String name) {
            this.name = name;
        }

        // Метод, который вызывают потоки
        public void walk(Corridor corridor, Person other) {
            while (isMoving) {
                // Если мы уперлись в другого человека, уступаем дорогу
                if (corridor.getOccupant() == this) {
                    System.out.println(name + ": Ой, " + other.name + ", проходите пожалуйста!");
                    corridor.setOccupant(other);

                    // Пытаемся сменить направление, чтобы обойти
                    isMoving = false;
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                    isMoving = true;
                } else {
                    // Ждем, пока коридор освободится
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                }
            }
        }
    }

    static class Corridor {
        private Person occupant;

        public void setOccupant(Person p) {
            this.occupant = p;
        }

        public Person getOccupant() {
            return occupant;
        }
    }

    public static void main(String[] args) {
        Corridor corridor = new Corridor();
        Person person1 = new Person("Поток-А");
        Person person2 = new Person("Поток-Б");

        // Изначально коридор занят первым человеком
        corridor.setOccupant(person1);

        Thread t1 = new Thread(() -> person1.walk(corridor, person2));
        Thread t2 = new Thread(() -> person2.walk(corridor, person1));

        t1.start();
        t2.start();
    }
}