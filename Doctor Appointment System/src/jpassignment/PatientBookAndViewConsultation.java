package jpassignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PatientBookAndViewConsultation implements ActionListener {

    private JFrame page;
    private Button SaveBtn, CancelBtn;
    private Label topic, nameD, day, time, pNameL, patientname;
    private TextField Day, Time;
    private Panel south, center, north;
    private MainMenu Mmenu;
    private JComboBox doctorName;
    private PatientProfile Pprofile;
    private ArrayList cal,aal;

    public PatientBookAndViewConsultation(ArrayList c, ArrayList a) {
        String[] dName = {"Sam", "Elijah", "Alex"};
        cal = c;
        aal = a;
        page = new JFrame();
        SaveBtn = new Button("Book");
        SaveBtn.addActionListener(this);
        CancelBtn = new Button("Cancel");
        CancelBtn.addActionListener(this);
        north = new Panel();
        south = new Panel();
        center = new Panel();
        Day = new TextField(15);
        Time = new TextField(15);
        patientname = new Label("Name:");
        pNameL = new Label("Patient Name:");
        nameD = new Label("Doctor Name:");
        day = new Label("Day:");
        time = new Label("Time:");
        doctorName = new JComboBox(dName);
        topic = new Label("Book Consultation");
        north.add(topic);
        center.add(pNameL);
        center.add(patientname);
        center.add(nameD);
        center.add(doctorName);
        center.add(day);
        center.add(Day);
        center.add(time);
        center.add(Time);
        south.add(SaveBtn);
        south.add(CancelBtn);
        page.add(south, BorderLayout.SOUTH);
        page.add(north, BorderLayout.NORTH);
        center.setLayout(new GridLayout(0, 2));
        page.add(center, BorderLayout.CENTER);
        page.setSize(250, 300);
        page.setLocation(400, 200);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //page.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == SaveBtn) {
            
            if (Day.getText().equals("") || Time.getText().equals("") || Integer.parseInt(Time.getText()) < 0 || Integer.parseInt(Time.getText()) > 23) {
                JOptionPane.showMessageDialog(null, "Please insert the correct data");

            } else {
                
                String TdoctorName = doctorName.getSelectedItem().toString();
                String day = Day.getText();
                String time = Time.getText();
                boolean flag1 = false;
                boolean flag2 = true;
                Consultation cancelConsultation = null;
                System.out.println(cal.size());
                for (int i = 0; i < cal.size(); i++) {
                    
                    Consultation c = (Consultation) cal.get(i);
                    System.out.println(c.getDoctorname());
                    System.out.println(c.getDay());
                    System.out.println(c.getTime());
                    if (day.equals(c.getDay()) && time.equals(c.getTime())&& TdoctorName.equals(c.getDoctorname())) {
                        flag1 = true;
                        cancelConsultation = c;
                    }
                }
                for (int i = 0; i < aal.size(); i++) {

                    Appointment a = (Appointment) aal.get(i);
                    if (day.equals(a.getDay()) && time.equals(a.getTime()) && TdoctorName.equals(a.getDoctorname())) {
                        flag2 = false;
                    }
                }
                if (flag1 && flag2) {
                    Appointment a = new Appointment(TdoctorName, patientname.getText(), day, time);
                    aal.add(a);
                    System.out.println("app size"+aal.size());
                    cal.remove(cancelConsultation);
                    JOptionPane.showMessageDialog(null, "Booked Succesfully");
                    Pprofile.getPage().setVisible(true);
                    page.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Consultation session not found or had been booked!");
                }
            }

        } else {
            Pprofile.getPage().setVisible(true);
            page.setVisible(false);

        }
    }

    public JFrame getPage() {
        return page;
    }
    public Label getLabel(){
        return patientname;
    }

    void setPage(PatientProfile patientprofile) {
        Pprofile = patientprofile;
    }
}
