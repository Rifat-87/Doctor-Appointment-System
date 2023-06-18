package jpassignment;

public class Appointment {
    private String doctorname;
    private String patientname;
    private String day;
    private String time;
    
    public Appointment(String a, String b, String c, String d){
        doctorname = a;
        patientname = b;
        day = c;
        time = d;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public String getPatientname() {
        return patientname;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

   

}
