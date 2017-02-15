/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edib.urlparser;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author alumno
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        
        UrlReader urlReader = new UrlReader();
        urlReader.setUrlStr("http://3coma1415.blogspot.es/");
        
        List<ImageUrl> imageList = urlReader.processUrl();
        
        SaveImage saveImage = new SaveImage();
        saveImage.setImageList(imageList);
        
        saveImage.save();
        
    }
    
}
