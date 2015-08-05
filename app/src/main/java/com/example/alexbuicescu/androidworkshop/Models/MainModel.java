package com.example.alexbuicescu.androidworkshop.Models;

import com.example.alexbuicescu.androidworkshop.Interfaces.SimpleObservable;

/**
 * Created by alexbuicescu on 05.08.2015.
 */
public class MainModel extends SimpleObservable<MainModel> {

    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName, boolean... update) {
        this.firstName = firstName;
        if(update.length > 0 && update[0])
        {
            notifyObservers();
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
