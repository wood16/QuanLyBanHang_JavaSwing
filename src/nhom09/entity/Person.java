/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom09.entity;

/**
 *
 * @author FPT
 */
public class Person {
      private int  id;
     private String username ;
 private String  fullname ;
private String  gioiTinh ;
private String  birthDay ;
private String  Address ;
private int idchucVu;
    public Person() {
    }



    public Person(String username, String fullname, String gioiTinh, String birthDay, String Address, int idchucVu) {
        this.username = username;
        this.fullname = fullname;
        this.gioiTinh = gioiTinh;
        this.birthDay = birthDay;
        this.Address = Address;
        this.idchucVu = idchucVu;
    }

    public int getIdchucVu() {
        return idchucVu;
    }

    public void setIdchucVu(int idchucVu) {
        this.idchucVu = idchucVu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    @Override
    public String toString() {
        return id+" "+username+" "+fullname+" "+gioiTinh;
    }
    
    public boolean checkEqualObject(Person p1, Person p2){
        if (p1.getId()==p2.getId()) {
            return true;
        }
        else
            return false;
    }
    
}
