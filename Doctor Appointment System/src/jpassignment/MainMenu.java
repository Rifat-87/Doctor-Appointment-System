package jpassignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFrame;

public class MainMenu implements ActionListener {

    private JFrame page;
    private Button DocBtn, PatBtn, ExitBtn;
    private Label title, secondtitle;
    private Panel south, center, north;
    private DoctorLogin Dlogin;
    private PatientLogin Plogin;
    private ViewAndEditConsultation Viewconsult;
    private ArrayList D, P, A, C;

    public MainMenu(ArrayList Doclogin, ArrayList Patlogin, ArrayList Appointment, ArrayList Consultation) {

        D = Doclogin;
        P = Patlogin;
        A = Appointment;
        C = Consultation;

        page = new JFrame();
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        Font font2 = new Font("SansSerif", Font.BOLD, 16);
        DocBtn = new Button("Doctor");
        DocBtn.setFont(font2);
        DocBtn.setPreferredSize(new Dimension(70, 50));
        PatBtn = new Button("Patient");
        PatBtn.setFont(font2);
        PatBtn.setPreferredSize(new Dimension(70, 50));
        ExitBtn = new Button("Exit");
        ExitBtn.setFont(font2);
        ExitBtn.setPreferredSize(new Dimension(70, 50));
        DocBtn.addActionListener(this);
        PatBtn.addActionListener(this);
        ExitBtn.addActionListener(this);
        south = new Panel();
        center = new Panel();
        north = new Panel();
        page.setSize(500, 400);
        page.setLocation(200, 200);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title = new Label("APU Medical Centre");
        title.setFont(font1);
        secondtitle = new Label("Choose your role");
        secondtitle.setFont(font2);
        center.add(secondtitle);
        center.add(DocBtn);
        center.add(PatBtn);
        center.add(ExitBtn);
        north.add(title);
        page.add(south, BorderLayout.SOUTH);
        page.add(center, BorderLayout.CENTER);
        page.add(north, BorderLayout.NORTH);
        page.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == DocBtn) {
            Dlogin.getPage().setVisible(true);
            page.setVisible(false);
        } else if (ae.getSource() == PatBtn) {
            Plogin.getPage().setVisible(true);
            page.setVisible(false);
        } else {
            System.out.println(A.size());
            for(int i=0;i<A.size();i++){
                Appointment newP = (Appointment)A.get(i);
                System.out.println(newP.getDoctorname());
                System.out.println(newP.getPatientname());
                System.out.println(newP.getDay());
                System.out.println(newP.getTime());
            }
            try {
                PrintWriter d = new PrintWriter("Doctor.txt");
                for (int i = 0; i < D.size(); i++) {
                    Doclogin dl = (Doclogin) D.get(i);
                    d.println(dl.getUsername());
                    d.println(dl.getPassword());
                }
                d.close();

            } catch (Exception ex) {
            }

            try {
                PrintWriter p = new PrintWriter("Patient.txt");
                for (int i = 0; i < P.size(); i++) {
                    Patlogin pl = (Patlogin) P.get(i);
                    p.println(pl.getUsername());
                    p.println(pl.getPassword());
                    p.println(pl.getPhone());
                }
                p.close();

            } catch (Exception ex) {
            }

            try {
                PrintWriter a = new PrintWriter("Appointment.txt");
                for (int i = 0; i < A.size(); i++) {
                    Appointment ap = (Appointment) A.get(i);
                    a.println(ap.getDoctorname());
                    a.println(ap.getPatientname());
                    a.println(ap.getDay());
                    a.println(ap.getTime());
                }
                a.close();

            } catch (Exception ex) {
            }

            try {
                PrintWriter c = new PrintWriter("Consultation.txt");
                for(int i=0;i<C.size();i++){
                    Consultation newC = (Consultation)C.get(i);
                    c.println(newC.getDoctorname());
                    c.println(newC.getDay());
                    c.println(newC.getTime());
                }
                c.close();

            } catch (Exception ex) {
            }
            System.exit(0);
        }
    }

    public JFrame getPage() {
        return page;
    }

    public void setPage(DoctorLogin doctorlogin) {
        Dlogin = doctorlogin;
    }

    void setPage(PatientLogin patientlogin) {
        Plogin = patientlogin;
    }

    public ArrayList getDocdata() {
        return D;
    }

    public ArrayList getPatdata() {
        return P;
    }

    public ArrayList getAppointmentdata() {
        return A;
    }

    public ArrayList getConsultationdata() {
        return C;
    }

    void setPage(ViewAndEditConsultation viewconsultation) {
        Viewconsult = viewconsultation;
    }
}
