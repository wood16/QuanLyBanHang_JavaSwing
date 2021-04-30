
package nhom09.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import nhom09.view.MainNhanVienBanHang;
import nhom09.view.MainNhanVienKho;
import nhom09.view.MainQuanLy;
import sun.net.www.content.audio.x_aiff;

public class AddAccount {
      public  static int insertData(String fullname,String gioiTinh,String userName,String pass,String birthDay,String address,int idchucvu){
          int x=-1,y=-1;
           Connection c = getConnection.getDataConnection();
            try {   
              String passEncrypt = BCrypt.hashpw(pass, BCrypt.gensalt(8));
                String sql1  = " Insert INTO dangnhap(username,password,idchucvu)  values (?,?,?)";
                PreparedStatement pre  = c.prepareStatement(sql1);       
                pre.setString(1, userName);
                pre.setString(2, passEncrypt);
                pre.setInt(3, idchucvu+1);             
                String query = "";
                
                if (idchucvu==0) {
                String sql2  = " Insert INTO quanly(username,fullname,gioiTinh,birthDay,Address)  values (?,?,?,?,?)";
                query=sql2;
                     }
                
                else if (idchucvu==1) {
       String sql2  = " Insert INTO nhanvienkho(username,fullname,gioiTinh,birthDay,Address)  values (?,?,?,?,?)";       
             query=sql2;
                }
                else if (idchucvu==2) {
                    
               
 {
         String sql2  = " Insert INTO nhanvienbanhang(username,fullname,gioiTinh,birthDay,Address)  values (?,?,?,?,?)";           
               query=sql2;
                }
             }
               PreparedStatement pre1  = c.prepareStatement(query);
               pre1.setString(1, userName);
                pre1.setString(2, fullname);
                 pre1.setString(3, gioiTinh);
                pre1.setString(4, birthDay);
                 pre1.setString(5, address);
                x = pre.executeUpdate();
               y= pre1.executeUpdate();
               
                
             } catch (Exception e) {
                 e.printStackTrace();
            }
            return x+y;
    
    }   
}
