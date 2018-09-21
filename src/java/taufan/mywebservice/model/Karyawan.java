/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taufan.mywebservice.model;

/**
 *
 * @author Taufan Septaufani
 */
public class Karyawan {
    private int idKaryawan;
    private String namaKaryawan;
    private String alamatKaryawan;
    private String emailKaryawan;
    private String teleponKaryawan;
    private String errorMessage;

    public int getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(int idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public String getAlamatKaryawan() {
        return alamatKaryawan;
    }

    public void setAlamatKaryawan(String alamatKaryawan) {
        this.alamatKaryawan = alamatKaryawan;
    }

    public String getEmailKaryawan() {
        return emailKaryawan;
    }

    public void setEmailKaryawan(String emailKaryawan) {
        this.emailKaryawan = emailKaryawan;
    }

    public String getTeleponKaryawan() {
        return teleponKaryawan;
    }

    public void setTeleponKaryawan(String teleponKaryawan) {
        this.teleponKaryawan = teleponKaryawan;
    }
    
    public String getErrorMessage(){
        return errorMessage;
    }
    
    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
   
}
