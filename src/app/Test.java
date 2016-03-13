package app;



import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import app.dataProviders.DataProviderFromDb;
import app.model.Employer;

public class Test {
	
	public static void main(String[] args) {
		
	
	try{  
		DataProviderFromDb dp= new DataProviderFromDb();
		
		 
        Employer e = dp.getEmployerByNames("hh", "jkk");
		System.out.println(e.getSalaire()+"");
		  
		}catch(Exception e){ System.out.println(e);}  
	}
	
}
