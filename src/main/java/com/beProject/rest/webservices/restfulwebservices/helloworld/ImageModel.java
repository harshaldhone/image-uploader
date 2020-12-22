package com.beProject.rest.webservices.restfulwebservices.helloworld;
import javax.persistence.*;

@Entity
@Table(name = "images")
public class ImageModel {

    public ImageModel() {
        super();
    }


    public ImageModel(String name, String type, byte[] picByte,String preHash,String newHash/*String DigitalSign*/,int nodeid,int sensor) {
        this.name = name;

        this.type = type;

        this.picByte = picByte;

        this.preHash = preHash;

        this.newHash = newHash;

        this.sensor=sensor;

        this.nodeid=nodeid;

        //this.DigitalSign=DigitalSign;

    }

    @Id

    @Column(name = "id")

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "name")

    private String name;

    @Column(name = "type")

    private String type;

    @Column(name = "picByte", length = 1000)

    private byte[] picByte;

    @Column(name = "preHash")
    private String preHash;

    @Column(name ="newHash")
    private String newHash;

    @Column(name ="nodeID")
    private int nodeid;

    @Column(name ="sensor")
    private int sensor;

    public ImageModel(String name, String type, byte[] decompressBytes, String preHash, String newHash) {
    }


    /*@Column(name = "Digital_sign")
    private String DigitalSign;*/

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public String getType() {

        return type;

    }

    public void setType(String type) {

        this.type = type;

    }
    public byte[] getPicByte() {

        return picByte;

    }
    public void setPicByte(byte[] picByte) {

        this.picByte = picByte;

    }

    public String getPreHash() {
        return preHash;
    }

    public void setPreHash(String preHash) {
        this.preHash = preHash;
    }

    public String getNewHash() {
        return newHash;
    }

    public void setNewHash(String newHash) {
        this.newHash = newHash;
    }

    public int getNodeid() {
        return nodeid;
    }

    public void setNodeid(int nodeid) {
        this.nodeid = nodeid;
    }

    public int getSensor() {
        return sensor;
    }

    public void setSensor(int sensor) {
        this.sensor = sensor;
    }





    /*public String getDigitalSign() {
        return DigitalSign;
    }

    public void setDigitalSign(String digitalSign) {
        DigitalSign = digitalSign;
    }*/
}