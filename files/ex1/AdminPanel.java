package ru.vadim;

/**
 * Файл AdminPanel отвечает за управлением вакансии, тут можно создавать вакансии, удалять вакансии
 *
 * @author Вадим Дунькин (vadimushka_d)
 * @version 1.0
 */
public class AdminPanel extends Exchange {
    /** Метод создания вакансии
     * После заполения полей, значения которых сохраняются в массив, далее массив отправляет как атрибут вызова метода
     */
    public static void createVacancy(){
        String[] str = new String[5];
        String temp;

        System.out.println("Название вакансии: ");
        nameVacancy = reader.nextLine();
        str[0] = nameVacancy;

        System.out.println("Описание вакансии: ");
        descriptionVacancy = reader.nextLine();
        str[2] = descriptionVacancy;

        System.out.println("Работодатель: ");
        employer = reader.nextLine();
        str[3] = employer;

        System.out.println("Место работы: ");
        placeWork = reader.nextLine();
        str[4] = placeWork;

        do {
            System.out.println("Зарплата: ");
            Pay = reader.nextInt();
        }while (Pay < 0);
        temp = String.valueOf(Pay);
        str[1] = temp;

        DB.WriteDB(str);
        Main.switchMenu();
    }

    /** Метод удаления вакансии
     */
    public static void deleteVacancy(){
        int id;
        DB.ReadDB(true);

        System.out.print("Введите id вакансии, которую требуется удалить: ");
        id = reader.nextInt();

        DB.deleteDB(id);
        Main.switchMenu();
    }
}
