
import java.sql.*;
import java.util.*;

public class pro{
    
        public static void main(String[] args) {

            int choice=0;
            while(choice!=20){
                System.out.println("===============================================");
                System.out.println("welcome to school management system");
                System.out.println("================================================");
                System.out.println("Enter choice : \n 1: Add student \n 2: show all student \n 3:show teacher \n 4: Exite");
                int menu=0;
                Scanner sc =new Scanner(System.in);
                menu =sc.nextInt();
                switch(menu){
                    case 1:
                    add();
                    break;
                    case 2:
                    show();
                    break;
                    case 3:
                    teacher();
                    break;
                    case 4:
                    choice=20;
                    break;
                    default :
                    System.out.println("Please enter the currect number");
                }
            }
        }


   //-----------------------------------------------------------------------------

            static void add(){
            try{
              Class.forName("com.mysql.jdbc.Driver");
              String url=("jdbc:mysql://localhost:3306/saket");
              String username="root";
              String password="vikas";
    
              Connection con=DriverManager.getConnection(url, username, password);
              String q="insert into student3 (  rollno, Firstname, lastname,Result, Mobileno, addresh) values(?,?,?,?,?,?)";
              PreparedStatement pstmt=con.prepareStatement(q);
    
              Scanner sc= new Scanner(System.in);
              System.out.println("Enter Students Rollno :");
              int rollno =sc.nextInt();
    
              System.out.println("Enter First name :");
              String firstname =sc.next();
    
              System.out.println("Enter Lastname :");
              String lastname =sc.next();
    
              System.out.println("Enter result :");
              String result =sc.next();

              System.out.println("Enter mobile no :");
              int number =sc.nextInt();

              System.out.println("Enter adress:");
              String adress =sc.next();

            pstmt.setInt(1, rollno);
            pstmt.setString(2,firstname );
            pstmt.setString(3, lastname);
            pstmt.setString(4, result);
            pstmt.setInt(5, number);
            pstmt.setString(6, adress);
    
            pstmt.executeUpdate();
            System.out.println("done");
            con.close();
            
    
    
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
//----------------------------------------------------------------------------------

static void show(){
    try{
    Class.forName("com.mysql.jdbc.Driver");
              String url=("jdbc:mysql://localhost:3306/saket");
              String username="root";
              String password="vikas";
    
              Connection con =DriverManager.getConnection(url, username, password);
              String q="select * from student3";

              java.sql.Statement pstmt= con.createStatement();
              ResultSet set = ((java.sql.Statement) pstmt).executeQuery(q);
              while(set.next()){
                int Sno =set.getInt(1);
                int rollno =set.getInt(2);
                String Firstname =set.getString(3);
                String lastname =set.getString(4);
                String result =set.getString(5);
                int Mobileno =set.getInt(6);
                String addresh=set.getString(7);

                System.out.println(Sno+" ! "+rollno+" ! "+Firstname+" ! "+lastname+" ! "+result+" ! "+Mobileno+" ! "+addresh);

              }
              con.close();
              System.out.println("ho gya");
              }
              
    catch(Exception e){
        System.out.println(e);
    }
}

//---------------------------------------------------------------------------------------------------


   static void teacher() {
    try{
        Class.forName("com.mysql.jdbc.Driver");
                  String url=("jdbc:mysql://localhost:3306/saket");
                  String username="root";
                  String password="vikas";
        
                  Connection con =DriverManager.getConnection(url, username, password);
                  String q=" select * from teacher";

                  java.sql.Statement pstmt= con.createStatement();
              ResultSet set = ((java.sql.Statement) pstmt).executeQuery(q);
                  
              while(set.next()){
                int ID =set.getInt(1);
                
                String Tname=set.getString(2);
                String Tsubject =set.getString(3);
                double salary =set.getDouble(4);

                System.out.println(ID +" "+Tname +" "+Tsubject+" "+salary);
                
              }
                  
   }
    catch(Exception e){
        System.out.println(e);
    }
        }
    }
    
    
