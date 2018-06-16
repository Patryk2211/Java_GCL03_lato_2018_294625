package SpringBoot.PictureDao;

import java.io.Serializable;

public class Picture implements Serializable {
    static int id=0;
    int index;
    String name;
    String resulution;
    long size;
    String created;

    byte [] imageArray;

    public Picture(String name, String resulution, long size, String creationTime) {
        this.index=++id;
        this.name = name;
        this.resulution=resulution;
        this.size = size;
        this.created = creationTime;
    }

    public Picture(String name, String resulution, long size, String creationTime, byte [] imageArray) {
        this.index=++id;
        this.name = name;
        this.resulution=resulution;
        this.size = size;
        this.created = creationTime;
        this.imageArray=imageArray;
    }

    public static void clearid()
    {
        id=0;
    }
    public  int getIndex() {
        return index;
    }

    public void setIndex(int id) {
        this.index = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResulution() {
        return resulution;
    }

    public void setResulution(String resulution) {
        this.resulution = resulution;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String creationTime) {
        this.created = creationTime;
    }

    public byte[] getImageArray() {
        return imageArray;
    }

    public void setImageArray(byte[] imageArray) {
        this.imageArray = imageArray;
    }

    public String toString()
    {
        return index + " " + name + " "+resulution +" " +size+ " "+created;

    }
}
