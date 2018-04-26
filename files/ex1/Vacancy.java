package ru.vadim;

/**
 * Файл Vacancy позволяет просмотривать вакансии и предоставляет поиск вакансии в базе данных
 *
 * @author Вадим Дунькин (vadimushka_d)
 * @version 1.0
 */
public class Vacancy extends Exchange {
    /** Метод выводит все записи в базе данных
     */
    public static void viewVacancy(){
        DB.ReadDB(false);

        Main.switchMenu();
    }

    /** Метод поиска вакансии в базе данных
     *
     */
    public static void searchVacancy(){
        System.out.println("Название специальности: ");
        nameVacancy = reader.nextLine();

        DB.ReadDB(nameVacancy);

        Main.switchMenu();
    }
}
