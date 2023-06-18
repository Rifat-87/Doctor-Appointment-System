package jpassignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EditPatientProfile implements ActionListener {

    private JFrame page;
    private Button SubBtn, CancelBtn;
    private TextField Username, Password, Phone;
    private Label title, secondtitle, patientname, username, password, phone;
    private Panel south, center, north;
    private PatientProfile Pprofile;
    private MainMenu Mmenu;
    private ArrayList P;

    public EditPatientProfile(MainMenu parent) {

        Mmenu = parent;
        page = new JFrame();
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        Font font2 = new Font("SansSerif", Font.BOLD, 16);
        Username = new TextField(10);
        Password = new TextField(10);
        Phone = new TextField(10);
        patientname = new Label("name");
        username = new Label("Enter new username: ");
        password = new Label("Enter new password: ");
        phone = new Label("Enter new phone: ");
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
        secondtitle = new Label("Edit Patient Profile                                                                                                                               ");
        secondtitle.setFont(font2);
        center.add(secondtitle);
        center.add(patientname);
        center.add(username);
        center.add(Username);
        center.add(password);
        center.add(Password);
        center.add(phone);
        center.add(Phone);
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
        return patientname;
    }

    void setPage(PatientProfile patientprofile) {
        Pprofile = patientprofile;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == SubBtn) {
            String name = patientname.getText();
            String username = Username.getText();
            String password = Password.getText();
            int phone = Integer.parseInt(Phone.getText());
            ArrayList P = Mmenu.getPatdata();
            for (int i = 0; i < P.size(); i++) {
                Patlogin b = (Patlogin) P.get(i);
                if (name.equals(b.getUsername())) {

                    b.setUsername(username);
                    b.setPassword(password);
                    b.setPhone(phone);
                    JOptionPane.showMessageDialog(null, "Edit Succesfully");
                    Pprofile.getPage().setVisible(true);
                    page.setVisible(false);
                } else {
                    Pprofile.getPage().setVisible(true);
                    page.setVisible(false);
                }
            }
        }
    }

}
