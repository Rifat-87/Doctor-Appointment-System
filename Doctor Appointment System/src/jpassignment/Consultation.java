package jpassignment;

public class Consultation {
    private String doctorname;
    private String day;
    private String time;
    
    public Consultation(String a, String b, String c){
        doctorname = a;
        day = b;
        time = c;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
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

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

}
