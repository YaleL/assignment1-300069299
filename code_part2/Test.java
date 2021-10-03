public class Test {

   public static void main(String[] args) {
       // TODO Auto-generated method stub
      
       Address addy = new Address("Queen", 48, "KINPIN2");
       Address adddy = new Address("KINGEDWARD", 800, "KIN6N5");
       Address [] addys = new Address[5];
       addys[0] = addy;
       addys[1] = adddy;
      
       Employee e1 = new Employee("Falcao", 40, 15.50, addys);//name, hours, rate, address
      
       System.out.println(e1.toString());

   }

}