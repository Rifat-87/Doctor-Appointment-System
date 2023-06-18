package jpassignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DoctorLogin implements ActionListener {

    private JFrame page;
    private Button SubBtn, CancelBtn;
    private TextField Username, Password;
    private Label title, secondtitle, username, password;
    private Panel south, center, north;
    private MainMenu Mmenu;
    private DoctorProfile Dprofile;
    private ArrayList dal;

    public DoctorLogin(ArrayList a) {
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
        secondtitle = new Label("Doctor Login: ");
        secondtitle.setFont(font2);
        center.add(secondtitle);
        center.add(username);
        center.add(Username);
        center.add(password);
        center.add(Password);
        south.add(SubBtn);
        south.add(CancelBtn);
        north.add(title);
        page.add(south, BorderLayout.SOUTH);
        page.add(center, BorderLayout.CENTER);
        page.add(north, BorderLayout.NORTH);
        //page.setVisible(true);
    }

    void setPage(MainMenu mainmenu) {
        Mmenu = mainmenu;
    }

    public JFrame getPage() {
        return page;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == SubBtn) {
            boolean flag = false;
            Doclogin empty = null;
            for (int i = 0; i < dal.size(); i++) {
                Doclogin newD = (Doclogin) dal.get(i);
                if (Username.getText().equals(newD.getUsername()) && Password.getText().equals(newD.getPassword())) {
                    flag = true;
                    empty = newD;
                }
            }
            if (flag) {
                Dprofile.getLabel().setText(empty.getUsername());
                Dprofile.getPage().setVisible(true);
                page.setVisible(false);
            } else {
                    JOptionPane.showMessageDialog(null, "Wrong username or password!");
            }

        } else {
            Mmenu.getPage().setVisible(true);
            page.setVisible(false);
        }

    }

    void setPage(DoctorProfile doctorprofile) {
        Dprofile = doctorprofile;
    }

    
}
