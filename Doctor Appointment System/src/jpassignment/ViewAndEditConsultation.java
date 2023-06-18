package jpassignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ViewAndEditConsultation implements ActionListener {

    private JFrame page;
    private Button SelectBtn, CancelBtn;
    private Label title, secondtitle, doctorname;
    private TextArea consultationlist;
    private Panel south, center, north;
    private DoctorProfile Dprofile;
    private MainMenu Mmenu;

    public ViewAndEditConsultation(MainMenu parent) {

        Mmenu = parent;
        page = new JFrame();
        consultationlist = new TextArea();
        //consultationlist.setEditable(false);
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        Font font2 = new Font("SansSerif", Font.BOLD, 16);
        SelectBtn = new Button("Select");
        SelectBtn.setFont(font2);
        SelectBtn.setPreferredSize(new Dimension(110, 50));
        CancelBtn = new Button("Cancel");
        CancelBtn.setFont(font2);
        SelectBtn.addActionListener(this);
        CancelBtn.addActionListener(this);
        CancelBtn.setPreferredSize(new Dimension(100, 50));
        south = new Panel();
        center = new Panel();
        north = new Panel();
        page.setSize(800, 400);
        page.setLocation(200, 200);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title = new Label("APU Medical Centre");
        title.setFont(font1);
        secondtitle = new Label("Consultations");
        secondtitle.setFont(font2);
        doctorname = new Label("name");
        center.add(secondtitle);
        center.add(consultationlist);
        south.add(SelectBtn);
        south.add(CancelBtn);
        north.add(title);
        north.add(doctorname);
        page.add(south, BorderLayout.SOUTH);
        page.add(center, BorderLayout.CENTER);
        page.add(north, BorderLayout.NORTH);
        //page.setVisible(true);
    }

    public JFrame getPage() {
        return page;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == SelectBtn) {
            ArrayList data = Mmenu.getConsultationdata();
            boolean flag = false;
            for (int i = 0; i < data.size(); i++) {
                Consultation c = (Consultation) data.get(i);
                if (c.getDoctorname().equals(doctorname.getText())) {
                    consultationlist.appendText("Your Name: " + c.getDoctorname() + "\n");
                    consultationlist.appendText("Day: " + c.getDay() + "\n");
                    consultationlist.appendText("Time: " + c.getTime() + "\n\n");
                    flag = true;
                }
            }
            if (flag) {
                JOptionPane.showMessageDialog(null, "Done Listing!");
            } else {
                JOptionPane.showMessageDialog(null, "No Consultation available!");
            }
        } else {
            Dprofile.getPage().setVisible(true);
            page.setVisible(false);
        }
    }

    void setPage(DoctorProfile doctorprofile) {
        Dprofile = doctorprofile;
    }

    public Label getLabel() {
        return doctorname;
    }

    void setPage(MainMenu mainmenu) {
        Mmenu = mainmenu;
    }
}
