/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom09.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author FPT
 */
public class EditAccount {
    public static int UpdateData(String fullname , String gioitinh , String username , String BirthDay , String Address, String tenchucVu) {
       
        int flagNhanVien = -1;
         Connection c = getConnection.getDataConnection();
         try {
            


        String queryDangNhap="";
             if (tenchucVu.equals("quanLy")) {
      queryDangNhap = "update quanly set fullname = ? , gioitinh= ?, birthDay = ? , Address = ?  where username = ? ";
             }
             else if (tenchucVu.equals("nhanvienkho")) {
           queryDangNhap = "update nhanvienkho set fullname = ? , gioitinh= ?, birthDay = ? , Address = ?  where username = ? ";
            
             }
             else {
     queryDangNhap = "update nhanvienbanhang set fullname = ? , gioitinh= ?, birthDay = ? , Address = ?  where username = ? ";
     
             }
  PreparedStatement pre  = c.prepareStatement(queryDangNhap);       
                pre.setString(1, fullname);
                pre.setString(2, gioitinh);
                pre.setString(3, BirthDay);              
                pre.setString(4, Address);              
                pre.setString(5, username);              
           flagNhanVien=  pre.executeUpdate();
            
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flagNhanVien;     
    }

    public static int  EditAccount(String username, String pass, String usernameFromJtable, int chucVu, int chuvuAge) {
        Connection c = getConnection.getDataConnection();
         int x =-1,y=-1;
        try {
             // thay doi dang nhap trc
                  String passEncrypt = BCrypt.hashpw(pass, BCrypt.gensalt(8));
           String   queryDangNhap = "update dangnhap set username = ? , password= ?,idchucvu = ?  where username = ? ";
             PreparedStatement pre  = c.prepareStatement(queryDangNhap);       
                pre.setString(1, username);
                pre.setString(2, passEncrypt);
                   pre.setInt(3, chucVu);
                   pre.setString(4, usernameFromJtable);
                x= pre.executeUpdate();
            
            
        // neu ko doi chuc vu
             if (chucVu==chuvuAge) {
                 
            
                 
                if (chucVu==1) {
                String queryQuanLy = "update quanly set username = ?   where username = ? ";
                 PreparedStatement pre1  = c.prepareStatement(queryQuanLy);       
                pre1.setString(1, username);
                pre1.setString(2, usernameFromJtable);
                y = pre1.executeUpdate();
            }
            else if (chucVu==2) {
                String queryNhanVienKho = "update nhanvienkho set username = ?   where username = ? ";
                 PreparedStatement pre1  = c.prepareStatement(queryNhanVienKho);       
                pre1.setString(1, username);
                pre1.setString(2, usernameFromJtable);
                y = pre1.executeUpdate();
            }
            else {
                 String queryNhanVienBanHang = "update nhanvienbanhang set username = ?   where username = ? ";
                 PreparedStatement pre1  = c.prepareStatement(queryNhanVienBanHang);       
                pre1.setString(1, username);
                pre1.setString(2, usernameFromJtable);
                y = pre1.executeUpdate();
                }
    
            }
             // th đổi chuc vu
             
             else{
             int y1=-1,y2=-1;
                 System.out.println("thay doi chuc vu roi");
             // lay thong tin cai cu va xoa cai cu
             String fullname="", gioiTinh="", birthDay="", address=""; int idchucvu=chucVu;
             if (chuvuAge==1) {
                   String queryData = "select * FROM quanly WHERE username = ? ";
                     PreparedStatement pre2  = c.prepareStatement(queryData);       
                pre2.setString(1, usernameFromJtable);
                 ResultSet resultSet = pre2.executeQuery();
                    while (resultSet.next()) { 
                        fullname = resultSet.getString("fullname");
                        gioiTinh = resultSet.getString("gioiTinh");
                        birthDay = resultSet.getString("birthDay");
                        address = resultSet.getString("Address");
                    }
                 
                String queryQuanLy = "DELETE FROM quanly WHERE username = ? ";
                 PreparedStatement pre1  = c.prepareStatement(queryQuanLy);       
                pre1.setString(1, usernameFromJtable);
                y1 = pre1.executeUpdate();
                
                
            }
            else if (chuvuAge==2) {
                
                
                 String queryData = "select * FROM nhanvienkho WHERE username = ? ";
                     PreparedStatement pre2  = c.prepareStatement(queryData);       
                pre2.setString(1, usernameFromJtable);
                 ResultSet resultSet = pre2.executeQuery();
                    while (resultSet.next()) { 
                        fullname = resultSet.getString("fullname");
                        gioiTinh = resultSet.getString("gioiTinh");
                        birthDay = resultSet.getString("birthDay");
                        address = resultSet.getString("Address");
                    }
                
                
                String queryNhanVienKho = "DELETE FROM nhanvienkho WHERE username = ?  ";
                 PreparedStatement pre1  = c.prepareStatement(queryNhanVienKho);       
               
                pre1.setString(1, usernameFromJtable);
                y1 = pre1.executeUpdate();
                     
            }
            else {
                     
                  String queryData = "select * FROM nhanvienbanhang WHERE username = ? ";
                     PreparedStatement pre2  = c.prepareStatement(queryData);       
                pre2.setString(1, usernameFromJtable);
                 ResultSet resultSet = pre2.executeQuery();
                    while (resultSet.next()) { 
                        fullname = resultSet.getString("fullname");
                        gioiTinh = resultSet.getString("gioiTinh");
                        birthDay = resultSet.getString("birthDay");
                        address = resultSet.getString("Address");
                    }

                 String queryNhanVienBanHang = "DELETE FROM nhanvienbanhang WHERE username =  ? ";
                 PreparedStatement pre1  = c.prepareStatement(queryNhanVienBanHang);       
               
                pre1.setString(1, usernameFromJtable);
                y1 = pre1.executeUpdate();
                }
    // add nv với đúng chuc vu
    
      // add nhan vien vs đúng chuc vu mới
      
      
                 try {
                     
                      String query = "";
                
                if (chucVu==1) {
                String sql2  = " Insert INTO quanly(username,fullname,gioiTinh,birthDay,Address)  values (?,?,?,?,?)";
                query=sql2;
                     }
                
                else if (chucVu==2) {
       String sql2  = " Insert INTO nhanvienkho(username,fullname,gioiTinh,birthDay,Address)  values (?,?,?,?,?)";       
             query=sql2;
                }
                else if (chucVu==3) {
                    
         String sql2  = " Insert INTO nhanvienbanhang(username,fullname,gioiTinh,birthDay,Address)  values (?,?,?,?,?)";           
               query=sql2;
                }
             
               PreparedStatement pre1  = c.prepareStatement(query);
               pre1.setString(1, username);
                pre1.setString(2, fullname);
                 pre1.setString(3, gioiTinh);
                pre1.setString(4, birthDay);
                 pre1.setString(5, address);
                y2= pre1.executeUpdate();
                     
                     System.out.println("username = "+ username+ " full name = "+ fullname+" idchucvu moi "+ chucVu+" idchucvucu "+chuvuAge);    
                     
                     
                 } catch (Exception e) {
                 }
           y=y1+y2;
             } // neu thay doi chuc vu
            
                
                System.out.println(x);
                System.out.println(y);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x+y;
        
    }

  
}
