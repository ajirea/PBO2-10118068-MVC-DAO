/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.satria.latihanmvcdao.event;

import edu.satria.latihanmvcdao.entity.Pelanggan;
import edu.satria.latihanmvcdao.model.PelangganModel;

/**
 *	
 * @author
 * NIM      : 10118068
 * NAMA     : Satria Aji Putra
 * KELAS    : IF-2
 * 
 */
public interface PelangganListener {
    
    public void onChange(PelangganModel model);
    
    public void onInsert(Pelanggan pelanggan);
    
    public void onUpdate(Pelanggan pelanggan);
    
    public void onDelete();
    
}
