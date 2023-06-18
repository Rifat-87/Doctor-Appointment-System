package jpassignment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class PatientProfile implements ActionListener{

    private JFrame page;
    private Button EditBtn, CancelBtn, BookingBtn;
    private TextField Username, Phone;
    private Label title, patientname;
    private Panel south, center, north;
    private PatientLogin Plogin;
    private EditPatientProfile EPprofile;
    private PatientBookAndViewConsultation Pbooking;
    private ArrayList aal;
    
    public PatientProfile(ArrayList a){
        aal = a;
        page = new JFrame();
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        Font font2 = new Font("SansSerif", Font.BOLD, 16);
        Username = new TextField(10);
        Phone = new TextField(10);
        EditBtn = new Button("Edit");
        EditBtn.setFont(font2);
        CancelBtn = new Button("Cancel");
        CancelBtn.setFont(font2);
        BookingBtn = new Button("Book Appointment");
        BookingBtn.setFont(font2);
        BookingBtn.setPreferredSize(new Dimension(160,28));
        EditBtn.addActionListener(this);
        CancelBtn.addActionListener(this);
        BookingBtn.addActionListener(this);
        south = new Panel();
        center = new Panel();
        north = new Panel();
        page.setSize(800, 400);
        page.setLocation(200, 200);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title = new Label("APU Medical Centre");
        title.setFont(font1);
        patientname = new Label();
        patientname.setFont(font2);
        center.add(patientname);
        south.add(EditBtn);
        south.add(CancelBtn);
        south.add(BookingBtn);
        north.add(title);
        page.add(south, BorderLayout.SOUTH);
        page.add(center, BorderLayout.CENTER);
        page.add(north, BorderLayout.NORTH);
        //page.setVisible(true);
}
    public JFrame getPage(){
        return page;
    }

    void setPage(PatientLogin patientlogin) {
        Plogin = patientlogin;
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==EditBtn){
            EPprofile.getLabel().setText(patientname.getText());
            EPprofile.getPage().setVisible(true);
            page.setVisible(false);
        }else if(ae.getSource()==BookingBtn){
            Pbooking.getLabel().setText(patientname.getText());
            Pbooking.getPage().setVisible(true);
            page.setVisible(false);
        }else{
            System.out.println(aal.size());
            Plogin.getPage().setVisible(true);
            page.setVisible(false);
        }
    }

    void setPage(EditPatientProfile editpatientprofile) {
        EPprofile = editpatientprofile;
    }

    void setPage(PatientBookAndViewConsultation bookconsultation) {
        Pbooking = bookconsultation;
    }
    
     public Label getLabel(){
        return patientname;
    }
    
}