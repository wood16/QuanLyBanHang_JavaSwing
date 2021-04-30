/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom09.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import nhom09.entity.Person;

/**
 *
 * @author FPT
 */
public class TestMain {
    
  
     public static boolean checkEqualObject(Person p1, Person p2){
        if (p1.getUsername().equals(p2.getUsername())) {
            return true;
        }
        else
            return false;
    }
     public  static void xly( List <Person> s,  List <Person> s1){
     
        for (Person i : s1) {
              int x =0;
              for (Person j : s) {
                  
          
                  if (checkEqualObject(i, j)) {
                      x=1; break;
                  }
              }
              if (x==0) {
                 s.add(i);
              }
        }
     }
     
     
    public static void main(String[] args) {
       
         List <Person> s = new ArrayList<>();
         List <Person> s1 = new ArrayList<>();
         s1= getAcountNhanVien.getUserName("tk%");
        xly(s, s1);
 System.out.println("s1 ======");
     
          for (Person i : s) {
              System.out.println(i.getUsername()+" "+i.getId()+ " "+i.getIdchucVu());
          }
      
     
       
       
       
       
       
       
       
       
       
       
       
       System.out.println("=============================");
      Connection c = getConnection.getDataConnection();
        try {
            
             String s4  = "SELECT * FRom dangnhap,chucvu where dangnhap.username like ? and  dangnhap.idchucvu = chucvu.idchucvu  ";  
           PreparedStatement pre4  = c.prepareStatement(s4);  
              pre4.setString(1,"tk%" );//
              HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
                  ResultSet resultSet4 = pre4.executeQuery();
                 while (resultSet4.next()) {   
                  
                    hashMap.put(resultSet4.getString("userName"),resultSet4.getInt("idchucvu") );
         }    
            
             for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                        String key = entry.getKey();
                        Integer value = entry.getValue();
                    System.out.println("  "+ key +"  "+value);    
                    }  
       String query1  = "SELECT * FRom quanly where username like ? ";
          PreparedStatement pre1  = c.prepareStatement(query1);
                 pre1.setString(1, "tk%");
          ResultSet resultSet1 = pre1.executeQuery();
               // qly
                while (resultSet1.next()) { 
                
                    Person p = new Person();
                    p.setId(resultSet1.getInt("idquanly"));
                    p.setUsername(resultSet1.getString("username"));
                    p.setFullname(resultSet1.getString("fullname"));
                    p.setGioiTinh(resultSet1.getString("gioiTinh"));
                    p.setBirthDay(resultSet1.getString("birthDay"));
                    p.setAddress(resultSet1.getString("Address"));
                //   p.setIdchucVu(id.get(i));
                    for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                        String key = entry.getKey();
                        Integer value = entry.getValue();
                        if (resultSet1.getString("username").equals(key)) {
                            p.setIdchucVu(value);
                            break;
                        }
                    }
                   s.add(p);
                  
                 
                }
//            System.out.println("---------------------"); 
//            for (Person person : s) {
//                System.out.println("username "+person.getUsername()+"  "+ person.getIdchucVu());
//            }
           // nvbh
            String query2  = "SELECT * FRom nhanvienbanhang where username like ? ";
             PreparedStatement pre2  = c.prepareStatement(query2);
                 pre2.setString(1, "tk%");
         ResultSet resultSet2 = pre2.executeQuery();
  while (resultSet2.next()) { 
                    
                    Person p = new Person();
                    p.setId(resultSet2.getInt("idnhanvienbanhang"));
                    p.setUsername(resultSet2.getString("username"));
                    p.setFullname(resultSet2.getString("fullname"));
                    p.setGioiTinh(resultSet2.getString("gioiTinh"));
                    p.setBirthDay(resultSet2.getString("birthDay"));
                    p.setAddress(resultSet2.getString("Address"));
                    for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                        String key = entry.getKey();
                        Integer value = entry.getValue();
                        if (resultSet2.getString("username").equals(key)) {
                            p.setIdchucVu(value);
                            break;
                        }
                    }
                   s.add(p); 
                 
                }
//            System.out.println("---------------------"); 
//            for (Person person : s) {
//                System.out.println("username "+person.getUsername()+"  "+ person.getIdchucVu());
//            }
          // nvkho  
       String s3  = "SELECT * FRom nhanvienkho where username like ? ";
        PreparedStatement pre3  = c.prepareStatement(s3);
                 pre3.setString(1, "tk"+"%");
        ResultSet resultSet3 = pre3.executeQuery();          
            while (resultSet3.next()) {  
                 
                    Person p = new Person();
                    p.setId(resultSet3.getInt("idNhanvienKho"));
                    p.setUsername(resultSet3.getString("username"));
                    p.setFullname(resultSet3.getString("fullname"));
                    p.setGioiTinh(resultSet3.getString("gioiTinh"));
                    p.setBirthDay(resultSet3.getString("birthDay"));
                    p.setAddress(resultSet3.getString("Address"));
                 for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                        String key = entry.getKey();
                        Integer value = entry.getValue();
                        if (resultSet3.getString("username").equals(key)) {
                            p.setIdchucVu(value);
                            break;
                        }
                    }
                   s.add(p);
                  
                }  
//          System.out.println("---------------------"); 
//            for (Person person : s) {
//                System.out.println("username "+person.getUsername()+"  "+ person.getIdchucVu());
//            }   
//            
            
        } catch (Exception e) {
        }
      
     
        
        
    }
    
    
    
    
    
}
