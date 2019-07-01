/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binus_final_project;

/**
 *
 * @author user
 */
public class Student {
    private String ID;
    private String name;
    private String gender;
    private int age;
    private String city;
    private String School;

    public Student(String ID, String name, String gender, int age, String city, String School) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.city = city;
        this.School = School;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String School) {
        this.School = School;
    }
    
    
}
 


