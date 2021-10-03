public class Address {

   String street;
   int number;
   String postal;
  
   public Address() {
       // TODO Auto-generated method stub

   }
  
   public Address(String streetname, int number, String pos) {
   this.street = streetname;
   this.number = number;
   this.postal = pos;


   }

   public String getStreet() {
       return street;
   }

   public void setStreet(String street) {
       this.street = street;
   }

   public int getNumber() {
       return number;
   }

   public void setNumber(int number) {
       this.number = number;
   }

   public String getPostal() {
       return postal;
   }

   public void setPostal(String postal) {
       this.postal = postal;
   }

   @Override
   public String toString() {
       return "Address [street=" + street + ", number=" + number + ", postal=" + postal + "]";
   }
  
}