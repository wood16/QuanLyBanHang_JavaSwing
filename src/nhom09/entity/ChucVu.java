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
public class ChucVu {
    private  int idChucVu;
    private String tenChucVu;

    public ChucVu(int idChucVu, String tenChucVu) {
        this.idChucVu = idChucVu;
        this.tenChucVu = tenChucVu;
    }

    public int getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(int idChucVu) {
        this.idChucVu = idChucVu;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }
    
            
}
