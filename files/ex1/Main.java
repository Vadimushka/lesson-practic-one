package ru.vadim;

import java.util.Scanner;

/**
 * Проект Hierarchy_Console
 *
 * @author Вадим Дунькин (vadimushka_d)
 * @version 1.0
 */
public class Main {
    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        new DB();

        switchMenu();
    }

    /** Навигация по методам программы
     *
     */
    public static void switchMenu(){
        System.out.print("1 - Просмотр всех вакансий | ");
        System.out.println("2 - Поиск вакансии");
        System.out.println("----------");
        System.out.print("3 - Создание вакансий | ");
        System.out.println("4 - Удаление вакансий");

        int numMenu;

        System.out.println("Введите пункт: ");
        numMenu = reader.nextInt();

        switch (numMenu){
            case 1:
                Vacancy.viewVacancy();
                break;
            case 2:
                Vacancy.searchVacancy();
                break;
            case 3:
                AdminPanel.createVacancy();
                break;
            case 4:
                AdminPanel.deleteVacancy();
                break;
        }
    }
}