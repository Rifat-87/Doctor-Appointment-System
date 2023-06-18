package jpassignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class DoctorProfile implements ActionListener {

    private JFrame page;
    private Button EditBtn, CancelBtn, AddConBtn, ViewConBtn, ViewAppBtn, CancelAppBtn;
    private TextField Username, Password;
    private Label title, secondtitle;
    private Panel south, center, north;
    private DoctorLogin Dlogin;
    private EditDoctorProfile EDprofile;
    private AddConsult Adconsult;
    private ViewAndEditConsultation Viewconsult;
    private ViewAppointment Viewapp;
    private DoctorCancelBooking DCbooking;

    public DoctorProfile() {

        page = new JFrame();
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        Font font2 = new Font("SansSerif", Font.BOLD, 16);
        Username = new TextField(10);
        Password = new TextField(10);
        EditBtn = new Button("Edit");
        EditBtn.setFont(font2);
        CancelBtn = new Button("Cancel");
        CancelBtn.setFont(font2);
        AddConBtn = new Button("Add Consultation Hour");
        AddConBtn.setFont(font2);
        ViewConBtn = new Button("View Consultation");
        ViewConBtn.setFont(font2);
        ViewAppBtn = new Button("View Appointment");
        ViewAppBtn.setFont(font2);
        CancelAppBtn = new Button("Cancel Appointment");
        CancelAppBtn.setFont(font2);
        EditBtn.addActionListener(this);
        CancelBtn.addActionListener(this);
        AddConBtn.addActionListener(this);
        ViewConBtn.addActionListener(this);
        ViewAppBtn.addActionListener(this);
        CancelAppBtn.addActionListener(this);
        south = new Panel();
        center = new Panel();
        north = new Panel();
        page.setSize(260, 350);
        page.setLocation(200, 200);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title = new Label("APU Medical Centre");
        title.setFont(font1);
        secondtitle = new Label("Name");
        secondtitle.setFont(font2);
        center.add(secondtitle);
        south.add(EditBtn);
        south.add(CancelBtn);
        center.add(AddConBtn);
        center.add(ViewConBtn);
        center.add(ViewAppBtn);
        center.add(CancelAppBtn);
        north.add(title);
        page.add(south, BorderLayout.SOUTH);
        page.add(center, BorderLayout.CENTER);
        page.add(north, BorderLayout.NORTH);
        //page.setVisible(true);
    }

    public JFrame getPage() {
        return page;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == EditBtn) {
            EDprofile.getLabel().setText(secondtitle.getText());
            EDprofile.getPage().setVisible(true);
            page.setVisible(false);
        } else if (ae.getSource() == AddConBtn) {
            Adconsult.getLabel().setText(secondtitle.getText());
            Adconsult.getPage().setVisible(true);
            page.setVisible(false);
        } else if (ae.getSource() == ViewConBtn) {
            Viewconsult.getLabel().setText(secondtitle.getText());
            Viewconsult.getPage().setVisible(true);
            page.setVisible(false);
        } else if (ae.getSource() == ViewAppBtn) {
            Viewapp.getLabel().setText(secondtitle.getText());
            Viewapp.getPage().setVisible(true);
            page.setVisible(false);
        } else if (ae.getSource() == CancelAppBtn) {
            DCbooking.getLabel().setText(secondtitle.getText());
            DCbooking.getPage().setVisible(true);
            page.setVisible(false);
        } else {
            Dlogin.getPage().setVisible(true);
            page.setVisible(false);
        }
    }

    void setPage(EditDoctorProfile editdoctorprofile) {
        EDprofile = editdoctorprofile;
    }

    void setPage(DoctorLogin doctorlogin) {
        Dlogin = doctorlogin;
    }

    void setPage(AddConsult addconsult) {
        Adconsult = addconsult;
    }

    void setPage(ViewAndEditConsultation viewconsultation) {
        Viewconsult = viewconsultation;
    }

    public Label getLabel() {
        return secondtitle;
    }

    void setPage(ViewAppointment viewappointment) {
        Viewapp = viewappointment;
    }

    void setPage(DoctorCancelBooking doctorcancelbooking) {
        DCbooking = doctorcancelbooking;
    }
}
