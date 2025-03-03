package com.university;

import java.util.Scanner;
/**
 * Главная функция
 * Обеспечивает взаимодействие пользователя с контейнером
 */
public class Main {

    /**
     * Точка входа в программу
     * Предоставляет пользователю меню для взаимодействия с контейнером
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        Container container = new Container();
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        int num, ind, action;

        while (flag) {
            System.out.println("\n1 - добавить элемент\n2 - удалить элемент\n3 - получить значение элемента\n4 - получить размер контейнера\n5 - проверить вхождения элемента\n6 - очистить контейнера\n0 - выход");
            action = in.nextInt();

            switch (action) {
                case 1:
                    System.out.println("Введите число для добавления:");
                    num = in.nextInt();
                    container.add(num);
                    break;
                case 2:
                    System.out.println("Введите индекс:");
                    ind = in.nextInt();
                    int removedElement = container.remove(ind);
                    System.out.println("Удаленный элемент: " + removedElement);
                    break;
                case 3:
                    System.out.println("Введите индекс:");
                    ind = in.nextInt();
                    int element = container.get(ind);
                    System.out.println("Значение элемента по указанному индексу: " + element);
                    break;
                case 4:
                    System.out.println("Размер контейнера: " + container.size());
                    break;
                case 5:
                    System.out.println("Введите элемент:");
                    num = in.nextInt();
                    if(container.contains(num)){
                        System.out.println("Контейнер содержит данный элемент");
                    }else{
                        System.out.println("Контейнер не содержит данный элемент");
                    }
                    break;
                case 6:
                    container.clear();
                    System.out.println("Контейнер очищен");
                    break;
                case 0:
                    System.out.println("Выход из программы...");
                    flag = false;
                    break;
                default:
                    System.out.println("Введено неверное значение");
            }
        }

        in.close();
    }
}