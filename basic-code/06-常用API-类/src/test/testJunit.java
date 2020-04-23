package test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class testJunit {


    @Test
    public void testAdd(){
        StringBuilder sbu=new StringBuilder("abc");
        System.out.println(sbu);
        sbu.append(111);
        System.out.println(sbu);
        String str1=sbu.toString();
        System.out.println(str1);
    }


}
