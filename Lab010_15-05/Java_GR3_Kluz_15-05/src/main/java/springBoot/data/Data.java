package springBoot.data;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Data {
    private int index;
    private String fileName;
    private int width;
    private int height;
    private int size;

    /*public Data(int index, String fileName) {
        this.index = index;
        this.fileName = fileName;
        this.width = 0;
        this.height = 0;
        this.size = 0;
    }*/

    public Data(int index, String fileName, int width, int height, int size) {
        this.index = index;
        this.fileName = fileName;
        this.width = width;
        this.height = height;
        this.size = size;
    }

    public Data(){

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
