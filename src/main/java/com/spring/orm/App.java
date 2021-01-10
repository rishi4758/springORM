package com.spring.orm;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Boolean goal=true;
//        System.out.println( "Hello World!" );
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        StudentDao dao= (StudentDao)context.getBean("dao");
    
    
		 System.out.print("********************Welcome to my Application******************************** " ); 
    	while(goal) {
    		 Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
    		 System.out.print("\nPress 1 for insertion \n");  
    		 System.out.print("Press 2 for deletion\n");  
    		 System.out.print("Press 3 for get all item\n");
    		 System.out.print("Press 4 for get one item\n"); 
    		 System.out.print("Press 5 for update\n");    		  
    		 System.out.print("Press 6 for exit \n");
    		 System.out.print("Enter your value.................."); 
    		 int a= sc.nextInt();  
    		 switch(a) {
    		 case 1:
    			 Student obj=new Student();
    			 System.out.print("enter id.... "); 
    			int id=sc.nextInt();
    			obj.setId(id);
    			 System.out.print("enter name.... \n"); 
    			String name=sc.next();
    			obj.setName(name);
    			
    			 System.out.print("enter city.... "); 
     			String city=sc.next();
     			obj.setCity(city);  			
    	        dao.insert(obj);
    	   	 System.out.print("**************************************\n ");
    			
    			 break;
    		 case 2:
    			 System.out.println("enter del id.......");
    			 int myDelId=sc.nextInt();
    			 int delId=dao.delStudent(myDelId);
    			 System.out.print("**************************************\n "); 
    			 break;
    		 case 3:
    			List <Student> allStudents=dao.getAll();
    			 System.out.print(allStudents+"\n "); 
    			 System.out.print("**************************************\n "); 
    			 break;
    		 case 4:
    			 Student s= dao.getStudent(1);
    			 System.out.print(s+"/n" );
    			 System.out.print("**************************************\n "); 
    			 break;
    		 case 5:
    			 System.out.print("you pressed five for insertion\n "); 
    			 System.out.print("**************************************\n "); 
    			 break;
    		 case 6:
    			 goal=false;
    			 break;
    			 
    		default:
    			 System.out.print("please press the valid input \n"); 
    			 System.out.print("**************************************\n "); 
    		 }

    		 
    	}
   	 System.out.print("Thank you for using m Application!\n "); 

        
    }
}
