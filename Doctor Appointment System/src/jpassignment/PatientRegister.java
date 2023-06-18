package jpassignment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PatientRegister implements ActionListener{

    private JFrame page;
    private Button SubBtn, CancelBtn;
    private TextField Username, Password, Phone;
    private Label title, secondtitle, username, password, phone;
    private Panel south, center, north;
    private PatientLogin Plogin;
    private MainMenu Mmenu;
    
    public PatientRegister(MainMenu a){
        Mmenu = a;

        page = new JFrame();
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        Font font2 = new Font("SansSerif", Font.BOLD, 16);
        Username = new TextField(10);
        Password = new TextField(10);
        Phone = new TextField(10);
        username = new Label("Enter a username: ");
        password = new Label("Enter a password: ");
        phone = new Label("Enter a phone number: ");
        Password.setEchoChar('*');
        SubBtn = new Button("Submit");
        SubBtn.setFont(font2);
        CancelBtn = new Button("Cancel");
        CancelBtn.setFont(font2);
        SubBtn.addActionListener(this);
        CancelBtn.addActionListener(this);
        south = new Panel();
        center = new Panel();
        north = new Panel();
        page.setSize(800, 400);
        page.setLocation(200, 200);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title = new Label("APU Medical Centre");
        title.setFont(font1);
        secondtitle = new Label("Register Profile                                                                                                                                                   ");
        secondtitle.setFont(font2);
        center.add(secondtitle);
        center.add(username); center.add(Username);
        center.add(password); center.add(Password);
        center.add(phone); center.add(Phone);
        south.add(SubBtn);
        south.add(CancelBtn);
        north.add(title);
        page.add(south, BorderLayout.SOUTH);
        page.add(center, BorderLayout.CENTER);
        page.add(north, BorderLayout.NORTH);
        //page.setVisible(true);
}
      public JFrame getPage(){
        return page;
    }

    void setPage(PatientLogin patientlogin) {
        Plogin = patientlogin;
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==SubBtn){
            
                Boolean flag = true;
                ArrayList patientd = Mmenu.getPatdata();
                
            for (int i = 0; i < Mmenu.getPatdata().size();i++){
                Patlogin p1 = (Patlogin) Mmenu.getPatdata().get(i);
                if(Username.getText().equals(p1.getUsername())){
                    flag = false;
                }
            }
            if(flag){
                Patlogin newPatient = new Patlogin(Username.getText(),Password.getText(),Integer.parseInt(Phone.getText()));
                Mmenu.getPatdata().add(newPatient);
                JOptionPane.showMessageDialog(null, "Registration Successful!");
                Plogin.getPage().setVisible(true);
                page.setVisible(false);
            }else {
                JOptionPane.showMessageDialog(null, "username already exists");
            }
            

        }else{
           Plogin.getPage().setVisible(true);
           page.setVisible(false);
        }
    }
}