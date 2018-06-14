/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class AvailList {
    private int pos;
    private int size;
    private String file;
            
    public AvailList() {
    }

    public AvailList(int pos, int size) {
        this.pos = pos;
        this.size = size;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
    
    public int getSize() {
        return size;
    }

    public String getFile() {
        return file;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setFile(String file) {
        this.file = file;
    }
    
    
    /*public AvailList BestFit(){
        
    }*/
}
