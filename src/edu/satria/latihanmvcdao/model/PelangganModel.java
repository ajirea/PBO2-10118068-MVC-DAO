/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.satria.latihanmvcdao.model;

import edu.satria.latihanmvcdao.database.KingBarbershopDatabase;
import edu.satria.latihanmvcdao.entity.Pelanggan;
import edu.satria.latihanmvcdao.error.PelangganException;
import edu.satria.latihanmvcdao.event.PelangganListener;
import edu.satria.latihanmvcdao.service.PelangganDao;
import java.sql.SQLException;

/**
 *	
 * @author
 * NIM      : 10118068
 * NAMA     : Satria Aji Putra
 * KELAS    : IF-2
 * 
 */
public class PelangganModel {
    
    private int id;
    private String nama, alamat, telepon, email;
    private PelangganListener listener;

    public PelangganListener getListener() {
        return listener;
    }

    public void setListener(PelangganListener listener) {
        this.listener = listener;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        fireOnChange();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
        fireOnChange();
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
        fireOnChange();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        fireOnChange();
    }
    
    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(Pelanggan pelanggan) {
        if (listener != null) {
            listener.onInsert(pelanggan);
        }
    }
    
    protected void fireOnUpdate(Pelanggan pelanggan) {
        if (listener != null) {
            listener.onUpdate(pelanggan);
        }
    }
    
    protected void fireOnDelete() {
        if(listener != null) {
            listener.onDelete();
        }
    }
    
    public void insertPelanggan() throws SQLException, PelangganException {
        PelangganDao dao = KingBarbershopDatabase.getPelangganDao();
        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setNama(nama);
        pelanggan.setAlamat(alamat);
        pelanggan.setTelepon(telepon);
        pelanggan.setEmail(email);
        
        dao.insertPelanggan(pelanggan);
        fireOnInsert(pelanggan);
    }
    
    public void updatePelanggan() throws SQLException, PelangganException {
        PelangganDao dao = KingBarbershopDatabase.getPelangganDao();
        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setNama(nama);
        pelanggan.setAlamat(alamat);
        pelanggan.setTelepon(telepon);
        pelanggan.setEmail(email);
        pelanggan.setId(id);
        
        dao.updatePelanggan(pelanggan);
        fireOnUpdate(pelanggan);
    }
    
    public void deletePelanggan() throws SQLException, PelangganException {
        PelangganDao dao = KingBarbershopDatabase.getPelangganDao();
        Pelanggan pelanggan = new Pelanggan();
        dao.deletePelanggan(id);
        fireOnDelete();
    }
    
    public void resetPelanggan() {
        setId(0);
        setNama("");
        setAlamat("");
        setTelepon("");
        setEmail("");
    }
    
}
