package jpassignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddConsult implements ActionListener {

    private JFrame page;
    private Button SubBtn, CancelBtn;
    private TextField Day, Time;
    private Label title, secondtitle, thirdtitle, day, time;
    private Panel south, center, north;
    private MainMenu Mmenu;
    private DoctorProfile Dprofile;
    private ArrayList cal;
    private ArrayList aal;

    public AddConsult(MainMenu parent) {
        Mmenu = parent;
        page = new JFrame();
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        Font font2 = new Font("SansSerif", Font.BOLD, 16);
        Day = new TextField(10);
        Time = new TextField(10);
        day = new Label("Enter Day:    ");
        time = new Label("Enter Time: ");
        SubBtn = new Button("Submit");
        SubBtn.setFont(font2);
        CancelBtn = new Button("Cancel");
        CancelBtn.setFont(font2);
        SubBtn.addActionListener(this);
        CancelBtn.addActionListener(this);
        south = new Panel();
        center = new Panel();
        north = new Panel();
        page.setSize(250, 300);
        page.setLocation(200, 200);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title = new Label("APU Medical Centre");
        title.setFont(font1);
        secondtitle = new Label("Add Consultation: ");
        secondtitle.setFont(font2);
        thirdtitle = new Label("Name");
        thirdtitle.setFont(font2);
        center.add(secondtitle);
        south.add(thirdtitle);
        center.add(day);
        center.add(Day);
        center.add(time);
        center.add(Time);
        south.add(SubBtn);
        south.add(CancelBtn);
        north.add(title);
        page.add(south, BorderLayout.SOUTH);
        page.add(center, BorderLayout.CENTER);
        page.add(north, BorderLayout.NORTH);
        //page.setVisible(true);
    }

    public Label getLabel() {
        return thirdtitle;
    }

    public JFrame getPage() {
        return page;
    }

    void setPage(DoctorProfile doctorprofile) {
        Dprofile = doctorprofile;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == SubBtn) {

            if (Day.getText().equals("") || Time.getText().equals("") || Integer.parseInt(Time.getText()) < 0 || Integer.parseInt(Time.getText()) > 23) {
                JOptionPane.showMessageDialog(null, "Please insert the correct data");

            } else {
                String doctorName = thirdtitle.getText();
                String day = Day.getText();
                String time = Time.getText();
                boolean flag1 = true;
                boolean flag2 = true;
                for (int i = 0; i < Mmenu.getConsultationdata().size(); i++) {

                    Consultation c = (Consultation) Mmenu.getConsultationdata().get(i);
                    if (Day.getText().equals(c.getDay()) && Time.getText().equals(c.getTime()) && thirdtitle.getText().equals(c.getDoctorname())) {
                        flag1 = false;
                    }
                }
                for (int i = 0; i < Mmenu.getAppointmentdata().size(); i++) {

                    Appointment a = (Appointment) Mmenu.getAppointmentdata().get(i);
                    if (Day.getText().equals(a.getDay()) && Time.getText().equals(a.getTime()) && thirdtitle.getText().equals(a.getDoctorname())) {
                        flag2 = false;
                    }
                }
                if (flag1 && flag2) {
                    Consultation c = new Consultation(doctorName, day, time);
                    Mmenu.getConsultationdata().add(c);
                    for (int i = 0; i < Mmenu.getConsultationdata().size(); i++) {
                        Consultation newC = (Consultation) Mmenu.getConsultationdata().get(i);
                        System.out.println(newC.getDoctorname());
                        System.out.println(newC.getDay());
                        System.out.println(newC.getTime());
                    }
                    JOptionPane.showMessageDialog(null, "Added Succesfully");
                    Dprofile.getPage().setVisible(true);
                    page.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot be booked!");
                }
            }
        } else {
            Dprofile.getPage().setVisible(true);
            page.setVisible(false);
        }
    }
}
