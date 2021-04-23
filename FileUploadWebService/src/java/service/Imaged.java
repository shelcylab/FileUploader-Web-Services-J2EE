package service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author shelc
 */
public class Imaged {

    private Integer id;
    private String filename;
    private byte[] data;

    public Imaged() {
    }

    public Imaged(Integer id) {
        this.id = id;
    }

    public Imaged(Integer id, String filename, byte[] data) {
        this.id = id;
        this.filename = filename;
        this.data = data;
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
