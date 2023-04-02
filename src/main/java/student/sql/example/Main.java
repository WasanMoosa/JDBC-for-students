package student.sql.example;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // ArrayList to save students
        ArrayList<Student> students = new ArrayList<>();


        //make connection
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/institutemanagement", System.getenv("DB_USER"), System.getenv("DB_PASSWORD"));
            Statement statement = connection.createStatement();

            // Read Students
            statement.executeQuery("select * from student");
            ResultSet rs = statement.getResultSet();

            while (rs.next()) {
                Student student = new Student();
                student.id = rs.getInt("id");
                student.name = rs.getString("name");
                student.email = rs.getString("email");
                students.add(student);
            }
            for (Student student : students) {
                System.out.println(" id: " + student.id + " name: " + student.name + " email: " + student.email);
            }


//            // Create Student
//            statement.execute("insert into student (name, email) values('wasan', 'wasan@gmail.com')");
//
//            // Update student
//            statement.executeUpdate("update student " +
//                    "set email ='wasan1999@gmail.com' " +
//                    "where id ='1'");
//
//            // delete student
//            statement.execute("delete from student where id ='1'");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
