import java.util.Scanner;
class EmployeeDB
{

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
        EmployeeService e=new EmployeeService();
		while(true)
		{
			System.out.println("Select option:\n1. Add Employee\n2. View Employee\n3. Update Employee\n4. Delete Employee\n5. View All Employee\n6. Exit");
			int n=s.nextInt();
			switch (n)
			{
			    
				case 1:
				{
				
			      e.addEmp();
			      break;
			      
				}
				case 2:
				{
					System.out.println("Enter the id you want to see:");
					int x=s.nextInt();
					e.viewEmp(x);
					break;
				}//end of case 2
				case 3:
				{
					System.out.println("Enter the Id you want to Update:");
					int id=s.nextInt();
					e.updateEmp(id);
					break;   	
				}//end of case 3
				case 4:
				{
					System.out.println("Enter the id you want to delete:");
					int id=s.nextInt();
					e.deleteEmp(id);
					break;
					
				}//end of case 4;
				case 5:
				{
					e.viewAll();
					   break; 
				}			
				case 6:
				{
					System.exit(0);
					break;
				}
				default:
				{
					System.out.println("Invalid option selected");
					break;
				}
			}
		}

	}

	

}
