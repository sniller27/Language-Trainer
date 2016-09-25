/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Soren
 */
public class Ord {

    private String danskord, engelskord;

    public Ord(String dkord, String ukord) {

        this.danskord = dkord;
        this.engelskord = ukord;

    }

    public String getDanskord() {
        return danskord;
    }

    public void setDanskord(String danskord) {
        this.danskord = danskord;
    }

    public String getEngelskord() {
        return engelskord;
    }

    public void setEngelskord(String engelskord) {
        this.engelskord = engelskord;
    }

    @Override
    public String toString() {
        return danskord + ", " + engelskord;
    }

}
