package ru.vadim;

import java.sql.*;

/**
 * В файле DB хранятся методы чтения, записи данных с базой даннных.
 *
 * @author Vadim Dunkin groups 13OIT18k (vadimushka_d)
 * @version 1.0
 */
public class DB {
    static Connection connection = null;
    static Statement statement;
    static ResultSet rs;

    /** Конструктор по умолчанию
     *  В этом констукторе происходит подключение в базе данных.
     */
    public DB(){
               try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("Отсутвует драйвер подключения к базе данных: " + e.getMessage());
        }

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:data.db");
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS vacancy (\n" +
                    "id INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                    "nameVacancy TEXT  NOT NULL,\n" +
                    "Pay INTEGER  NOT NULL,\n" +
                    "descriptionVacancy TEXT  NOT NULL,\n" +
                    "employer TEXT  NOT NULL,\n" +
                    "placeWork TEXT  NOT NULL\n" +
                    ");");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** Метод записи данных в базу данных
     *
     * @param s String[] получаемый массив содержит поля которые заносятся в таблицу базы данных
     */
    public static void WriteDB(String[] s){

        try {
            PreparedStatement prepared = connection.prepareStatement("INSERT INTO vacancy " +
                    "(nameVacancy,Pay,descriptionVacancy,employer,placeWork) VALUES (?,?,?,?,?)");
            prepared.setString(1, s[0]);
            prepared.setInt(2,  Integer.valueOf(s[1]));
            prepared.setString(3, s[2]);
            prepared.setString(4, s[3]);
            prepared.setString(5, s[4]);
            prepared.addBatch();
            prepared.executeBatch();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /** Перегруженный метод чтения записей в таблице данных для поиска вакансии
     *
     * @param s String принимаемый атрибут передает название вакансии
     */
    public static void ReadDB(String s){
        try {
            rs = statement.executeQuery("SELECT * FROM vacancy WHERE nameVacancy = " + s);

            if (!rs.next()) {
                System.out.println("Запрашиваемых вакансии нет!");
            } else {

                System.out.println("-----");
                while (rs.next()) {
                    System.out.println("Название вакансии: " + rs.getString("nameVacancy"));
                    System.out.println("Зарплата: " + rs.getString("Pay") + " руб.");
                    System.out.println("Описание вакансии: " + rs.getString("descriptionVacancy"));
                    System.out.println("Работодатель: " + rs.getString("employer"));
                    System.out.println("Место работы: " + rs.getString("placeWork"));
                    if (rs.next())
                        System.out.println("-----");
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /** Перегруженный метод чтения записей в таблице данных
     *
     * @param viewID Boolean показывает ид записи, помогает при удалении записей
     */
    public static void ReadDB(Boolean viewID){
        try {
            rs = statement.executeQuery("SELECT * FROM vacancy");

            if (!rs.next()){
                System.out.println("Вакансии нет!");
            } else {

                System.out.println("-----");
                while (rs.next()) {
                    if (viewID)
                        System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Название вакансии: " + rs.getString("nameVacancy"));
                    System.out.println("Зарплата: " + rs.getString("Pay") + " руб.");
                    System.out.println("Описание вакансии: " + rs.getString("descriptionVacancy"));
                    System.out.println("Работодатель: " + rs.getString("employer"));
                    System.out.println("Место работы: " + rs.getString("placeWork"));
                    if (rs.next())
                        System.out.println("-----");

                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /** Метод удаления записей в базе данных
     * @param id int поле которое передает id вакансии, которую требуется удалитью
     */
    public static void deleteDB(int id) {
        try {
            statement.executeUpdate("DELETE FROM vacancy WHERE id = " + id);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
