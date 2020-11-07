package temp;

import java.sql.*;

public class TestJdbc {
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/mybatis_day01";

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
 
    //  Database credentials -- 数据库名和密码自己修改
    static final String USER = "root";
    static final String PASS = "123456";
 
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs=null;
        try{
           //STEP 2: Register JDBC driver
           Class.forName(JDBC_DRIVER);
     
           //STEP 3: Open a connection

           conn = DriverManager.getConnection(DB_URL,USER,PASS);
     
           //STEP 4: Execute a query

           stmt = conn.createStatement();
           String sql;
           sql = "SELECT * FROM user";
           rs = stmt.executeQuery(sql);
     
           //STEP 5: Extract data from result set
           while(rs.next()){
              //Retrieve by column name
              int id  = rs.getInt("id");

              String username = rs.getString("username");
              Time birthday = rs.getTime("birthday");
     
              //Display values

              System.out.print("ID: " + id);

              System.out.print(", username: " + username);
              System.out.println(", birthday: " + birthday);
           }
           //STEP 6: Clean-up environment

           stmt.close();
           conn.close();
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
            if(rs!=null)rs.close();
            if(stmt!=null)stmt.close();
            if(conn!=null)conn.close();

        }//end try

     }
 }
