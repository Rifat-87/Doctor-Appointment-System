package jpassignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EditDoctorProfile implements ActionListener {

    private JFrame page;
    private Button SubBtn, CancelBtn;
    private TextField Username, Password;
    private Label title, secondtitle, doctorname, username, password;
    private Panel south, center, north;
    private DoctorProfile Dprofile;
    private MainMenu Mmenu;
    private ArrayList D;

    public EditDoctorProfile(MainMenu parent) {

        Mmenu = parent;
        page = new JFrame();
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        Font font2 = new Font("SansSerif", Font.BOLD, 16);
        Username = new TextField(10);
        Password = new TextField(10);
        doctorname = new Label("Name");
        username = new Label("Enter new username: ");
        password = new Label("Enter new password: ");
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
        page.setSize(257, 350);
        page.setLocation(200, 200);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title = new Label("APU Medical Centre");
        title.setFont(font1);
        secondtitle = new Label("Edit Profile");
        secondtitle.setFont(font2);
        doctorname.setFont(font2);
        center.add(secondtitle);
        center.add(username);
        center.add(Username);
        center.add(password);
        center.add(Password);
        north.add(doctorname);
        south.add(SubBtn);
        south.add(CancelBtn);
        north.add(title);
        page.add(south, BorderLayout.SOUTH);
        page.add(center, BorderLayout.CENTER);
        page.add(north, BorderLayout.NORTH);
        //page.setVisible(true);
    }

    public JFrame getPage() {
        return page;
    }

    public Label getLabel() {
        return doctorname;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == SubBtn) {
            String name = doctorname.getText();
            String username = Username.getText();
            String password = Password.getText();
            ArrayList D = Mmenu.getDocdata();
            for (int i = 0; i < D.size(); i++) {
                Doclogin b = (Doclogin) D.get(i);
                if (name.equals(b.getUsername())) {

                    b.setUsername(username);
                    b.setPassword(password);
                    JOptionPane.showMessageDialog(null, "Edit Succesfully");
                    Dprofile.getPage().setVisible(true);
                    page.setVisible(false);
                } else {
                    Dprofile.getPage().setVisible(true);
                    page.setVisible(false);
                }
            }
        }
    }

    void setPage(DoctorProfile doctorprofile) {
        Dprofile = doctorprofile;
    }
}
