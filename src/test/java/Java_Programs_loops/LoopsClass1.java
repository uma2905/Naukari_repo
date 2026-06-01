package Java_Programs_loops;


import java.util.Scanner;

public class LoopsClass1 {

	public static void main(String[] args) {
		 
		
//		for(int i=0; i<=10; i++) {
//		System.out.println("forLoop"+ i);
//		}
//	int i= 0;
//		while(i<10) {
//			i++;
//			System.out.println("whileLoop"+i);
//				
//	}
//	
//		
//	 int a=0; 
//	 do {  
//		 System.out.println(a); 
//	a++;  }while(a<10);
		
		
		// Print sum of first n natural number
int sum =0; 

Scanner sc= new Scanner(System.in);
int n= sc.nextInt();
System.out.println("Enter the n value"+n);
for(int i =1; i<=n; i++) {
	sum =sum+i; 
	
	
}
	}
	
}
