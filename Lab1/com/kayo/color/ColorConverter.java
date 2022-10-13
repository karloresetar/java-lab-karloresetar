package Lab1.com.kayo.color;

public class ColorConverter {

    public static void main(String[] args) {

        String hexColor = "0x1FF0FF";

        Color c = Color.decode(hexColor);

        float[] hsbCode = new float[3];

        Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), hsbCode);
        System.out.println("Boja u HEX formatu: 0x" +
                Integer.toHexString(c.getRGB() & 0x00FFFFFF));

        System.out.println("Boja u RGB formatu: " + c.getRed() + ", " +
                c.getGreen() + ", " + c.getBlue());

        System.out.println("Boja u HSB formatu: " + hsbCode[0] * 360 + "°, " +
                hsbCode[1] * 100 + "%, " + hsbCode[2] * 100 + "%");
        float [] hslcode=Color.RGBtoHSL(c.getRed(), c.getGreen(), c.getBlue());
        System.out.println("Boja u HSL formatu: "+hslcode[0]+" "+hslcode[1]+" "+hslcode[2]);
        float [] CMYKcode=Color.RGBtoCMYK(c.getRed(), c.getGreen(), c.getBlue());
        System.out.println("Boja u CMYK formatu: "+CMYKcode[0]+" "+CMYKcode[1]+" "+CMYKcode[2]+" "+CMYKcode[3]);
    }
}