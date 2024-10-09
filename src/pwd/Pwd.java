
package pwd;


import java.util.Scanner;
public class Pwd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String resp;
        do{

            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();
            Pwd test = new Pwd();
            switch(action){
                case 1:
                    test.addPWD();
                break;
                case 2:
                    test.viewPWD();
                break;
                case 3:
                    test.viewPWD();
                    test.updatePWD();
                break;
                case 4:
                    test.viewPWD();
                    test.deletePWD();
                    test.viewPWD();
                break;
            }
            
            System.out.print("Continue? ");
            resp = sc.next();

        }while(resp.equalsIgnoreCase("yes"));
            System.out.println("Thank You!");

    }
    
    public void addPWD(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print(" First Name: ");
        String fname = sc.nextLine();
        System.out.print(" Last Name: ");
        String lname = sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("PWD Status: ");
        String status = sc.nextLine();

        String sql = "INSERT INTO pwd (s_fname, s_lname, s_address, s_status) VALUES (?, ?, ?, ?)";


        conf.addRecord(sql, fname, lname, address, status);
    }
    
    public void viewPWD() {
        
        String qry = "SELECT * FROM pwd ";
        String[] hdrs = {"ID", "First Name", "Last Name", "Address", "Status"};
        String[] clms = {"s_id", "s_fname", "s_lname", "s_address", "s_status"};

        config conf = new config();
        conf.viewRecords(qry, hdrs, clms);
    }
    
    public void updatePWD(){
    
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Update: ");
        int id = sc.nextInt();
        System.out.print("Enter new First Name: ");
        String nfname = sc.next();
        System.out.print("Enter new Last Name: ");
        String nlname = sc.next();
        System.out.print("Enter new Status: ");
        String nstatus = sc.next();
        
        String qry = "UPDATE pwd SET s_fname = ?, s_lname = ?, s_status = ? WHERE s_id = ?";
        
        config conf = new config();
        conf.updateRecord(qry, nfname, nlname,  nstatus, id);
        
    }
    
    public void deletePWD(){
        
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM pwd WHERE s_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
    
    }  
}