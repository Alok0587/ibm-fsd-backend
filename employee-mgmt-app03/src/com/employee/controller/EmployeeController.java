package com.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import com.employee.service.EmployeeService;

@WebServlet("/employeeForm")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    		response.setContentType("text/html");
			int flag=Integer.parseInt(request.getParameter("flag"));
    		if(flag==1)
    		{
    		int id=Integer.parseInt(request.getParameter("id"));
    		String name=request.getParameter("name");
    		int age=Integer.parseInt(request.getParameter("age"));
    		String desg=request.getParameter("desg");
    		String country=request.getParameter("country");
    		PrintWriter out=response.getWriter(); 

    		EmployeeService es=new EmployeeService();
    		int count=es.add(id, name, age, desg, country);
    		out.println(count+"Record Succesfully added");
    		}
    		else if(flag==2)
    		{
    			int id=Integer.parseInt(request.getParameter("id"));
        		String name=request.getParameter("name");
        		int age=Integer.parseInt(request.getParameter("age"));
        		String desg=request.getParameter("desg");
        		String country=request.getParameter("country");
        		PrintWriter out=response.getWriter(); 

        		EmployeeService es=new EmployeeService();
        		int x=es.update(id, name, age, desg, country);
        		out.println(x+"Record Modified succesfully");	
    		}
    		else if(flag==3)
    		{
    			int id=Integer.parseInt(request.getParameter("id"));

        		EmployeeService es=new EmployeeService();
        		String res=es.viewById(id);
        		PrintWriter out=response.getWriter(); 
        		out.println("ID    NAME        AGE   DESG     COUNTRY"  );
        		out.println("----------------------------------------------");
                out.println("<br><br>");
                out.println(res);
    		}
    		else if(flag==4)
    		{
    			int id=Integer.parseInt(request.getParameter("id"));
    			EmployeeService es=new EmployeeService();
    			es.deleteById(id);
    			PrintWriter out=response.getWriter();
    			out.println("Deleted Succesfully");
    		}
    		else if(flag==5)
    		{
    			String rs="";
    			EmployeeService es=new EmployeeService();
    			try {
					rs=es.viewAll();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            PrintWriter out=response.getWriter();
            String res[]=rs.split(",");
            out.println("ID    NAME        AGE   DESG     COUNTRY"  );

            out.println("<br><br>");
    		out.println("----------------------------------------------");
    		out.println("<br>");

            for(int i=0;i<res.length;i++)
            {
            	out.println(res[i]);
            	out.println("<br>");
        		out.println("----------------------------------------------");
        		out.println("<br>");


            }
    		}

	}


}
