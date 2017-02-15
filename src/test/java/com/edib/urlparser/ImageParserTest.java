/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edib.urlparser;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alumno
 */
public class ImageParserTest {

    public ImageParserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of parse method, of class ImageParser.
     */
    @org.junit.Test
    public void testParse() {
     
        
        //Objeto a probar
        ImageParser instance = new ImageParser();
        String html = "<img id=\"img\" src=\"https://netbeans.org/images_www/articles/72/java/junit/junit3-vectors-createtests2323.png\" alt=\"\"/> "
                + " <img src=\"https://netbeans.org/images_www/articles/72/java/junit/junit3-vectors-createtests.png\" alt=\"\"/> ";

        instance.setHtml(html);

        //Resultado esperado
        List<ImageUrl> expResult = new ArrayList<>();
        ImageUrl imageUrl = new ImageUrl();
        imageUrl.setUrl("https://netbeans.org/images_www/articles/72/java/junit/junit3-vectors-createtests.png");
        expResult.add(imageUrl);

        List<ImageUrl> result = instance.parse();
        
        assertEquals(expResult.get(0).getUrl(), result.get(0).getUrl());
        assertEquals(expResult.get(1).getUrl(), result.get(1).getUrl());
 
    }

}
