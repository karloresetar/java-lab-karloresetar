package Lab1.com.kayo.color.com.kayo.color.test;

import Lab1.com.kayo.color.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ColorTest {

    private static Color c;
    @Test
    public void decodeTest() {
        Color c1=Color.decode("0x1FF0FF");

        Assert.assertEquals(31,c1.getRed());
    }
    @Test
    public void RGBtoHSLtest(){
        float [] test=new float[3];
        test=c.RGBtoHSL(31, 240, 255);
        Assert.assertEquals((int)184.01785,(int)test[0], 0);
    }
    @Test
    public void RGBtoHSBtest() {
        float [] test1=new float[3];
        c.RGBtoHSB(31, 240, 255, test1);
        Assert.assertEquals((int)184.01784,(int)(test1[0]*360), 0);
    }
    @Test
    public void RGBtoCMYKtest() {
        float [] test1=new float[4];
        test1=Color.RGBtoCMYK(31, 240, 255);
        Assert.assertEquals( 0.8784313797950745, test1[0], 0);
    }
}
