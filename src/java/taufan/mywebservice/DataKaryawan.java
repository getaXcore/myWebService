/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taufan.mywebservice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import taufan.mywebservice.model.Karyawan;
import taufan.mywebservice.util.Database;

/**
 *
 * @author Taufan Septaufani
 */
@WebService(serviceName = "DataKaryawan")
public class DataKaryawan {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getKaryawan")
    public List<Karyawan> getKaryawan() {
        //TODO write your implementation code here:
        List<Karyawan> lk = new ArrayList<Karyawan>();
        Database db = new Database();
        try{
            String sql = "select * from tbl_karyawan";
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Karyawan karyawan = new Karyawan();
                karyawan.setErrorMessage("");
                karyawan.setIdKaryawan(rs.getInt("id_karyawan"));
                karyawan.setNamaKaryawan(rs.getString("nama_karyawan"));
                karyawan.setAlamatKaryawan(rs.getString("alamat_karyawan"));
                karyawan.setEmailKaryawan(rs.getString("email_karyawan"));
                karyawan.setTeleponKaryawan(rs.getString("telepon_karyawan"));
                lk.add(karyawan);
            }
            return lk;
        }catch(Exception e){
            Karyawan karyawan = new Karyawan();
            karyawan.setErrorMessage(e.getMessage());
            lk.add(karyawan);
            return lk;
        }finally{
            db.closeConnection();
            db = null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cariKaryawan")
    public List<Karyawan> cariKaryawan(@WebParam(name = "namaKaryawan") String namaKaryawan) {
        //TODO write your implementation code here:
        List<Karyawan> lk = new ArrayList<Karyawan>();
        Database db = new Database();
        try{
            //String sql = "select *from tbl_karyawan where nama_karyawan like?"; //for mysql
            String sql = "select *from tbl_karyawan where nama_karyawan ILIKE '%"+namaKaryawan+"%'"; //for postgre
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            //ps.setString(1,"%"+namaKaryawan+"%"); //for mysql
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Karyawan karyawan = new Karyawan();
                karyawan.setErrorMessage("");
                karyawan.setIdKaryawan(rs.getInt("id_karyawan"));
                karyawan.setNamaKaryawan(rs.getString("nama_karyawan"));
                karyawan.setAlamatKaryawan(rs.getString("alamat_karyawan"));
                karyawan.setEmailKaryawan(rs.getString("email_karyawan"));
                karyawan.setTeleponKaryawan(rs.getString("telepon_karyawan"));
                lk.add(karyawan);
            }
            return lk;
        }catch(Exception e){
            Karyawan karyawan = new Karyawan();
            karyawan.setErrorMessage(e.getMessage());
            lk.add(karyawan);
            return lk;
        }finally{
            db.closeConnection();
            db = null;
        }
    }
}
