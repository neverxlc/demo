package com.example.demo.vo;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import org.springframework.beans.BeanUtils;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.stream.Stream;


public class Photos {


    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) throws Exception{
//        readPic();
//        Stream.of(InetAddress.getAllByName("www.baidu.com"))
//                .forEach(System.out::println);

//        Photos photos = new Photos();
////        photos.setId(100);
////        Person person = new Person();
////        BeanUtils.copyProperties(photos, person);
////        System.out.println(person);

        System.out.println(new String(new byte[]{54,48,48}));
    }



    public static  void readPic() {
        System.out.println("开始读取图片信息...");
        File jpegFile = new File("D:\\IMG_0326.JPG");
        Metadata metadata;
        try {
            metadata = JpegMetadataReader.readMetadata(jpegFile);
            Iterator<Directory> it = metadata.getDirectories().iterator();
            while (it.hasNext()) {
                Directory exif = it.next();
                Iterator<Tag> tags = exif.getTags().iterator();
                while (tags.hasNext()) {
                    Tag tag = (Tag) tags.next();
                    System.out.println(tag);
                }
            }
            System.out.println("图片信息读取完成！");
        } catch (JpegProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
