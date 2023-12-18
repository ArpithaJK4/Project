
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;


public class CreateDatabase {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mava","root","root");
		System.out.println("connection established ");
		
		Statement statement=connection.createStatement();
		
		
//		Create table 
//		 statement.execute("create table EmpData (Emp_id int primary key,emp_name varchar(30),emp_sal int not null, emp_email varchar(30) unique)");
		
		
//		Insert Table
//		 statement.execute("insert into EmpData values(1, 'harsha', 12000, 'arp@gmail.com')");
//		 statement.execute("insert into EmpData values(2, 'harshith', 124, 'arpitha@gmail.com')");
//		 statement.execute("insert into EmpData values(3, 'harshaaa', 1206700, 'arip@gmail.com')");

		
		
//		update
//		 statement.execute("update EmpData  set emp_name='Suhas' where  Emp_id=1");

		
//		fetch
		ResultSet resultset =statement.executeQuery(" select *from EmpData ");
	while(	resultset.next()){
		System.out.println("Emp_id :" +resultset.getInt(1) + "emp_name: "+  resultset.getString(2)+ " emp_sal:"+ resultset.getInt(3) +  " emp_sal:" +resultset.getString(4)) ;
		
	}
		 connection.close();
		
		
		
		
//		add Column
//		statement.executeUpdate("Alter table EmpData add column emp_role varchar(20) not null");
		
		
//		set single value to the table
//		statement.executeUpdate("update   EmpData  set emp_role ='Devloper' where Emp_id=1");

		System.out.println("done");
	}
		
	
	}


