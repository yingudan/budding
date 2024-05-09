package com.ripper.budding.design.observer;

import java.util.Vector;

public class Teacher implements Subject {
    private String phone;
    private Vector students;

    public Teacher() {
        phone = "";
        students = new Vector();
    }

    @Override
    public void attach(Observer o) {
        students.add(o);
    }

    @Override
    public void detach(Observer o) {
        students.remove(o);
    }

    @Override
    public void notice() {
        for (int i = 0; i < students.size(); i++)
            ((Observer) students.get(i)).update();
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notice(); // --关键
    }

    public String getPhone() {
        return phone;
    }

}
