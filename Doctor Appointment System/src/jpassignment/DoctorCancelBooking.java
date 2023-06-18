package jpassignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DoctorCancelBooking implements ActionListener {

    private JFrame page;
    private Button SubBtn, CancelBtn;
    private TextField Patientname, Day, Time;
    private Label title, secondtitle, patientname, day, time, doctorname;
    private Panel south, center, north;
    private DoctorProfile Dprofile;
    private MainMenu Mmenu;
    private ArrayList cal,aal;

    public DoctorCancelBooking(ArrayList c, ArrayList a) {
        
        cal = c;
        aal = a;

        page = new JFrame();
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        Font font2 = new Font("SansSerif", Font.BOLD, 16);
        Patientname = new TextField(10);
        Day = new TextField(10);
        Time = new TextField(10);
        doctorname = new Label("Name");
        patientname = new Label("Enter patient name: ");
        day = new Label("Enter day: ");
        time = new Label("Enter time: ");
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
        secondtitle = new Label("Edit Patient Profile                                                                                                                                      ");
        secondtitle.setFont(font2);
        center.add(secondtitle);
        center.add(patientname);
        center.add(Patientname);
        center.add(day);
        center.add(Day);
        center.add(time);
        center.add(Time);
        north.add(doctorname);
        south.add(SubBtn);
        south.add(CancelBtn);
        north.add(title);
        page.add(south, BorderLayout.SOUTH);
        page.add(center, BorderLayout.CENTER);
        page.add(north, BorderLayout.NORTH);
        // page.setVisible(true);
    }

    public JFrame getPage() {
        return page;
    }

    public Label getLabel() {
        return doctorname;
    }


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == SubBtn) {
            String TdoctorName = doctorname.getText();
            String patientname = Patientname.getText();
            String day = Day.getText();
            String time = Time.getText();
            boolean flag = false;
            Appointment b = null;
            for(int i=0; i<aal.size(); i++){
                Appointment a = (Appointment)aal.get(i);
                    if (day.equals(a.getDay()) && time.equals(a.getTime()) && TdoctorName.equals(a.getDoctorname()) && patientname.equals(a.getPatientname())){
                        b = a;
                        flag = true;
                    }
            }
            if(flag){
                Consultation c = new Consultation(TdoctorName, day, time);
                cal.add(c);
                aal.remove(b);
                JOptionPane.showMessageDialog(null,"Cancel Succesfully!");
                Dprofile.getPage().setVisible(true);
                page.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null,"Appointment doesn't exist!");
            }
        }else{
            Dprofile.getPage().setVisible(true);
            page.setVisible(false);
        }
        
    }

    void setPage(DoctorProfile doctorprofile) {
       Dprofile = doctorprofile;
    }
        }