/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edib.urlparser;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author alumno
 */
public class SaveImage {

    private List<ImageUrl> imageList;

    public void save() throws IOException {

        if (getImageList() != null) {
            for (ImageUrl image : getImageList()) {
                createImage(image.getUrl());
            }
        }

    }

    private void createImage(String urlStr) throws IOException {

        URL url;
        BufferedImage image = null;
        try {

            url = new URL(urlStr);

            image = ImageIO.read(url);
            
            String extension = returnFormat(url);
            
            String path = url.getPath();
            
            int indice = path.lastIndexOf("/");
      
            String name = path.substring(indice + 1);
    
            ImageIO.write(image, extension, new File("target/" + name));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String returnFormat(URL url) {
        boolean ret = false;
        String extension = null;
        try {
            URLConnection con = url.openConnection();
            String headerType = con.getContentType();
            String guessType = con.guessContentTypeFromName(url.getFile());

            if (headerType.indexOf("/") > 0) {
                extension = headerType.split("/")[1];
            }

            if (extension == null) {
                extension = guessType.split("/")[1];
            }

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (extension == null) {
            extension = "png";
        }
        return extension;
    }

    /**
     * @return the imageList
     */
    public List<ImageUrl> getImageList() {
        return imageList;
    }

    /**
     * @param imageList the imageList to set
     */
    public void setImageList(List<ImageUrl> imageList) {
        this.imageList = imageList;
    }

}
