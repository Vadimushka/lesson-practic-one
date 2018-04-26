package ru.vadim;

import java.util.Scanner;

/**
 * Exchange объявляет поля
 *
 * @author Вадим Дунькин (vadimushka_d)
 * @version 1.0
 */
public abstract class Exchange {
    /** Переменная, которая позволяет вводить данных с клавиатуры
     */
    static Scanner reader = new Scanner(System.in);

    /** Поле для имени вакансии
     */
    protected static String nameVacancy;

    /** Поле для зарплаты
     */
    protected static int Pay;

    /** Поле для описания вакансии
     */
    protected static String descriptionVacancy;

    /** Поле для названания работодателя
     */
    protected static String employer;

    /** Поле для места работы
     */
    protected static String placeWork;
}
