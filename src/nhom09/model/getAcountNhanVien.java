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
import nhom09.entity.NhanVienBanHang;
import nhom09.entity.Person;
import nhom09.view.MainNhanVienBanHang;
import nhom09.view.MainNhanVienKho;
import nhom09.view.MainQuanLy;

/**
 *
 * @author FPT
 */
public class getAcountNhanVien {
     public  static String Select(String name, String pass){
      
            Connection c = getConnection.getDataConnection();
            try {
               String s  = "SELECT * FRom dangnhap where username = ?   ";
                PreparedStatement pre  = c.prepareStatement(s);
               
                pre.setString(1, name);//
               
                ResultSet resultSet = pre.executeQuery();
               
                while (resultSet.next()) {                    
                    if (BCrypt.checkpw(pass, resultSet.getString("password"))) {
                       return String.valueOf(resultSet.getInt("idchucvu"));
                    }
                }
              
            } catch (Exception e) {
                e.printStackTrace();
            }
        return "";
           
     }
        
    public static List <Person> getUserName(String userName){
          Connection c = getConnection.getDataConnection();
            List <Person> s = new ArrayList<>();
          try {
                
                String s1  = "SELECT * FRom quanly where username like ? ";
                String s2  = "SELECT * FRom nhanvienbanhang where username like ? ";
                String s3  = "SELECT * FRom nhanvienkho where username like ? ";
        String s4  = "SELECT * FRom dangnhap,chucvu where dangnhap.username like ? and  dangnhap.idchucvu = chucvu.idchucvu  ";     
              PreparedStatement pre4  = c.prepareStatement(s4);  
              pre4.setString(1,userName+"%" );//
              HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
                  ResultSet resultSet4 = pre4.executeQuery();
                 while (resultSet4.next()) {   
                  
                    hashMap.put(resultSet4.getString("userName"),resultSet4.getInt("idchucvu") );
         }    
        
        
       
        PreparedStatement pre1  = c.prepareStatement(s1);
                 pre1.setString(1, userName+"%");
//
                PreparedStatement pre2  = c.prepareStatement(s2);
                 pre2.setString(1, userName+"%");
//
                PreparedStatement pre3  = c.prepareStatement(s3);
                 pre3.setString(1, userName+"%");
//
                  ResultSet resultSet1 = pre1.executeQuery();
                  ResultSet resultSet2 = pre2.executeQuery();
                  ResultSet resultSet3 = pre3.executeQuery();
 //
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
               
        } catch (Exception e) {
        }
         return s;
    }
     
    
}
