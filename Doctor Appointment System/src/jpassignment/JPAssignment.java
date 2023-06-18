package jpassignment;
import javax.swing.JFrame;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class JPAssignment extends JFrame{
    public static ArrayList doctorarray, patientarray, appointmentarray, consultationarray;

    public static void main(String[] args) throws Exception {
    
        doctorarray = new ArrayList();
        patientarray = new ArrayList();
        appointmentarray = new ArrayList();
        consultationarray = new ArrayList();
        
        
        
        //array doctor
        
        Scanner ds = new Scanner(new File("Doctor.txt"));
        while(ds.hasNext()){
            String username = ds.nextLine();
            String password = ds.nextLine();
            Doclogin d = new Doclogin(username, password);
            doctorarray.add(d);
        }
        //array patient
        
        Scanner ps = new Scanner(new File("Patient.txt"));
        while(ps.hasNext()){
            String username = ps.nextLine();
            String password = ps.nextLine();
            int phone = Integer.parseInt(ps.nextLine());
            Patlogin p = new Patlogin(username, password, phone);
            patientarray.add(p);
        }
        //array consultation
        
        Scanner cs = new Scanner(new File("Consultation.txt"));
        while(cs.hasNext()){
            String doctorname = cs.nextLine();
            String day = cs.nextLine();
            String time = cs.nextLine();
            Consultation c = new Consultation(doctorname, day, time);
            consultationarray.add(c);
        }
        for(int i=0;i<consultationarray.size();i++){
            Consultation newC = (Consultation)consultationarray.get(i);
            System.out.println(newC.getDoctorname());
            System.out.println(newC.getDay());
            System.out.println(newC.getTime());
        }
        System.out.println(consultationarray.size());
        //array appointment
        
        Scanner as = new Scanner(new File("Appointment.txt"));
        while(as.hasNext()){
            String doctorname = as.nextLine();
            String patientname = as.nextLine();
            String day = as.nextLine();
            String time = as.nextLine();
            Appointment a = new Appointment(doctorname, patientname, day, time);
            appointmentarray.add(a);
        }
        
        MainMenu mainmenu = new MainMenu(doctorarray, patientarray,  appointmentarray,consultationarray);
        DoctorLogin doctorlogin = new DoctorLogin(doctorarray);
        PatientLogin patientlogin = new PatientLogin(patientarray);
        DoctorProfile doctorprofile = new DoctorProfile();
        EditDoctorProfile editdoctorprofile = new EditDoctorProfile(mainmenu);
        ViewAndEditConsultation viewconsultation = new ViewAndEditConsultation(mainmenu);
        PatientRegister patientregister = new PatientRegister(mainmenu);
        PatientProfile patientprofile = new PatientProfile(appointmentarray);
        EditPatientProfile editpatientprofile = new EditPatientProfile(mainmenu);
        PatientBookAndViewConsultation bookconsultation = new PatientBookAndViewConsultation(consultationarray,appointmentarray);
        AddConsult addconsult = new AddConsult(mainmenu);
        ViewAppointment viewappointment = new ViewAppointment(mainmenu);
        DoctorCancelBooking doctorcancelbooking = new DoctorCancelBooking(consultationarray,appointmentarray);
    
        //linking
        mainmenu.setPage(doctorlogin);
        doctorlogin.setPage(mainmenu);
        
        mainmenu.setPage(patientlogin);
        patientlogin.setpage(mainmenu);
        
        doctorlogin.setPage(doctorprofile);
        doctorprofile.setPage(doctorlogin);
        
        doctorprofile.setPage(editdoctorprofile);
        editdoctorprofile.setPage(doctorprofile);
        
        patientlogin.setPage(patientprofile);
        patientprofile.setPage(patientlogin);
        
        patientlogin.setPage(patientregister);
        patientregister.setPage(patientlogin);
        
        patientprofile.setPage(editpatientprofile);
        editpatientprofile.setPage(patientprofile);
        
        patientprofile.setPage(bookconsultation);
        bookconsultation.setPage(patientprofile);
        
        doctorprofile.setPage(addconsult);
        addconsult.setPage(doctorprofile);
        
        doctorprofile.setPage(viewconsultation);
        viewconsultation.setPage(doctorprofile);
        
        viewconsultation.setPage(mainmenu);
        mainmenu.setPage(viewconsultation);
        
        doctorprofile.setPage(viewappointment);
        viewappointment.setPage(doctorprofile);
        
        doctorprofile.setPage(doctorcancelbooking);
        doctorcancelbooking.setPage(doctorprofile);
        
    }
    
    
    
}
