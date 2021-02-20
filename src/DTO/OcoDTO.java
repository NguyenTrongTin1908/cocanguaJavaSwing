/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Keyer
 */
public class OcoDTO {
    
    private int Id_o,trangthai,Id_qc;
    public OcoDTO() {
    }

    public int getId_o() {
        return Id_o;
    }

    public void setId_o(int Id_o) {
        this.Id_o = Id_o;
    }
    public int getId_qc() {
        return Id_qc;
    }

    public void setId_qc(int Id_qc) {
        this.Id_qc = Id_qc;
    }
    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
   
}
