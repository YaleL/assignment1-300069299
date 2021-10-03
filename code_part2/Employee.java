import java.util.Arrays;

public class Employee {

   private String name;
   private int hours;
   private double rate;
   Address [] add;
  
   public Employee() {
       // TODO Auto-generated constructor stub
   }
  
   public Employee(String name,int hours, double rate, Address[] a ) {
       // TODO Auto-generated constructor stub
       this.name = name;
       this.hours = hours;
       this.rate = rate;
       this.add = a;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public int getHours() {
       return hours;
   }

   public void setHours(int hours) {
       this.hours = hours;
   }

   public double getRate() {
       return rate;
   }

   public void setRate(double rate) {
       this.rate = rate;
   }

   public Address[] getAdd() {
       return add;
   }

   public void setAdd(Address[] add) {
       this.add = add;
   }

   @Override
   public String toString() {
       return "Employee [name=" + name + ", hours=" + hours + ", rate=" + rate + "\n, add=" + Arrays.toString(add) + "]";
   }
  
  
  
}