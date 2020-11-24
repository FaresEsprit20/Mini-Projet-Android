package com.example.miniprojetandroid.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

 @PrimaryKey(autoGenerate = true)
 public int id;
 @ColumnInfo( name ="name")
 public String name;
 @ColumnInfo( name ="lastName")
 public String lastName;
 @ColumnInfo( name ="role")
 public String role;
 @ColumnInfo( name ="password")
 public String password;
 @ColumnInfo( name ="email")
 public String email;
 @ColumnInfo( name ="phone")
 public String phone;
    @Ignore
 public User(){
 }

    public User( String name, String lastName, String password,  String email, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.role = "client";
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    @Ignore
    public User(int id, String name, String lastName, String password,  String email, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.role= "client";
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
