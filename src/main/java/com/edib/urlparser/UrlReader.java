/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edib.urlparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 *
 * @author alumno
 */
public class UrlReader {

    private String urlStr;

    public List<ImageUrl> processUrl() throws MalformedURLException, IOException {
        
        URL url = new URL(getUrlStr());
        
        String html = getUrlSource(url);
        
        ImageParser imageParser = new ImageParser();
        
        imageParser.setHtml(html);
        
        List<ImageUrl> imageList = imageParser.parse();
        
        return imageList;
       
    }

    private String getUrlSource(URL url) throws IOException {

        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream(), "UTF-8"));
        //yc.getInputStream() --> HTML Bytes
        String inputLine;
        StringBuilder a = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            a.append(inputLine);
        }

        in.close();

        return a.toString();
    }

    /**
     * @return the urlStr
     */
    public String getUrlStr() {
        return urlStr;
    }

    /**
     * @param urlStr the urlStr to set
     */
    public void setUrlStr(String urlStr) {
        this.urlStr = urlStr;
    }

}
