package student.sql.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {


        //make connection
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/institutemanagement", System.getenv("DB_USER"), System.getenv("DB_PASSWORD"));
            Statement statement = connection.createStatement();

            // Read Students
            statement.executeQuery("select * from student");
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println(" id: " + id + " name: " + name + " email: " + email );

            }


            // Create Student
//            statement.execute("insert into student (name, email) values('wasan', 'wasan@gmail.com')");

            // Update student
//            statement.executeUpdate("update student " +
//                                        "set email ='wasan1999@gmail.com' " +
//                                        "where id ='1'");

            // delete student
//            statement.execute("delete from student where id ='1'");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
