package com.servlet;

import service.Imaged;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author shelc
 */
public class Imagedata {

    private Integer id;
    private String filename;
    private byte[] data;

    public Imagedata() {
    }
    
    

    public Imagedata(Integer id) {
        this.id = id;
    }

    public Imagedata(Integer id, String filename, byte[] data) {
        this.id = id;
        this.filename = filename;
        this.data = data;
    }

    Imagedata(Imaged ls) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

}
