package jpassignment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PatientLogin implements ActionListener {

    private JFrame page;
    private Button SubBtn, CancelBtn, NewuserBtn;
    private TextField Username, Password;
    private Label title, secondtitle, username, password;
    private Panel south, center, north;
    private MainMenu Mmenu;
    private PatientProfile Pprofile;
    private PatientRegister Pregister;
    private ArrayList dal;
    
    public PatientLogin(ArrayList a){
        
        dal = a;
        page = new JFrame();
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        Font font2 = new Font("SansSerif", Font.BOLD, 16);
        Username = new TextField(10);
        Password = new TextField(10);
        username = new Label("Enter Username: ");
        password = new Label("Enter Password: ");
        Password.setEchoChar('*');
        SubBtn = new Button("Submit");
        SubBtn.setFont(font2);
        CancelBtn = new Button("Cancel");
        CancelBtn.setFont(font2);
        NewuserBtn = new Button("New Member!");
        NewuserBtn.setFont(font2);
        SubBtn.addActionListener(this);
        CancelBtn.addActionListener(this);
        NewuserBtn.addActionListener(this);
        NewuserBtn.setPreferredSize(new Dimension(160,28));
        south = new Panel();
        center = new Panel();
        north = new Panel();
        page.setSize(800, 400);
        page.setLocation(200, 200);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title = new Label("APU Medical Centre");
        title.setFont(font1);
        secondtitle = new Label("Patient Login: ");
        secondtitle.setFont(font2);
        center.add(secondtitle);
        center.add(username); center.add(Username);
        center.add(password); center.add(Password);
        south.add(SubBtn);
        south.add(CancelBtn);
        center.add(NewuserBtn);
        north.add(title);
        page.add(south, BorderLayout.SOUTH);
        page.add(center, BorderLayout.CENTER);
        page.add(north, BorderLayout.NORTH);
        //page.setVisible(true);
      
    }
    

    
      public JFrame getPage(){
        return page;
    }
      
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == SubBtn) {
            boolean flag = false;
            Patlogin empty = null;
            for (int i = 0; i < dal.size(); i++) {
                Patlogin newP = (Patlogin) dal.get(i);
                if (Username.getText().equals(newP.getUsername()) && Password.getText().equals(newP.getPassword())) {
                    flag = true;
                    empty = newP;
                }
            }
            if (flag) {
                Pprofile.getLabel().setText(empty.getUsername());
                Pprofile.getPage().setVisible(true);
                page.setVisible(false);
            } else {
                    JOptionPane.showMessageDialog(null, "Wrong username or password!");
            }
        }else if(ae.getSource()==NewuserBtn){
            Pregister.getPage().setVisible(true);
            page.setVisible(false);
        }else{
            Mmenu.getPage().setVisible(true);
            page.setVisible(false);
        }

    }

    void setpage(MainMenu mainmenu) {
        Mmenu = mainmenu;
    }

    void setPage(PatientProfile patientprofile) {
        Pprofile = patientprofile;
    }

    void setPage(PatientRegister patientregister) {
        Pregister = patientregister;
    }
}