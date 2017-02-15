/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edib.urlparser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alumno
 */
public class ImageParser {
    
    private String html;
    
    public List<ImageUrl> parse(){
        
        List<ImageUrl> htmlTagList = new ArrayList<>();
        
        Pattern pattern = Pattern.compile("<img src=\"(.*?)\"");
        Matcher matcher = pattern.matcher(getHtml());
        
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            ImageUrl imageUrl = new ImageUrl();
            imageUrl.setUrl(matcher.group(1));
            htmlTagList.add(imageUrl);
        }
        
        return htmlTagList;
    }

    /**
     * @return the html
     */
    public String getHtml() {
        return html;
    }

    /**
     * @param html the html to set
     */
    public void setHtml(String html) {
        this.html = html;
    }
    
}
