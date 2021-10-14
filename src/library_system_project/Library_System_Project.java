
package library_system_project;


public class Library_System_Project {


    public static void main(String[] args) {
        Loading load = new Loading();
        load.setVisible(true);
        
        try{
            for (int x=0; x<=100; x++){
            Thread.sleep(50);
            
            Loading.lblload.setText(Integer.toString(x)+ "%");
            Loading.brload.setValue(x); 
            
            Login l = new Login();
                if (x==100){
                    l.setVisible(true);
                    load.setVisible(false);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
    }
    }
    
}
