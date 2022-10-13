package Lab1.com.kayo.color;

public class Color {

    int[] rgb = new int[3];

    public Color(int a, int b, int c) {
        rgb[0] = a;
        rgb[1] = b;
        rgb[2] = c;
    }

    public static  Color decode(String hexadecimal) {
        String[] hex = hexadecimal.split("");
        int r = Integer.parseInt(hex[2] + hex[3], 16);
        int g = Integer.parseInt(hex[4] + hex[5], 16);
        int b = Integer.parseInt(hex[6] + hex[7], 16);
        return new Color(r, g, b);
    }

    public static void RGBtoHSB(int r, int g, int b, float[] hsbvals) {
        float hue, saturation, brightness;
        if (hsbvals == null) {
            hsbvals = new float[3];
        }
        int cmax = Math.max(r, g);
        if (b > cmax)
            cmax = b;
        int cmin = Math.min(r, g);
        if (b < cmin)
            cmin = b;

        brightness = ((float) cmax) / 255.0f;
        if (cmax != 0)
            saturation = ((float) (cmax - cmin)) / ((float) cmax);
        else
            saturation = 0;
        if (saturation == 0)
            hue = 0;
        else {
            float redc = ((float) (cmax - r)) / ((float) (cmax - cmin));
            float greenc = ((float) (cmax - g)) / ((float) (cmax - cmin));
            float bluec = ((float) (cmax - b)) / ((float) (cmax - cmin));
            if (r == cmax)
                hue = bluec - greenc;
            else if (g == cmax)
                hue = 2.0f + redc - bluec;
            else
                hue = 4.0f + greenc - redc;
            hue = hue / 6.0f;
            if (hue < 0)
                hue = hue + 1.0f;
        }
        hsbvals[0] = hue;
        hsbvals[1] = saturation;
        hsbvals[2] = brightness;
    }

    public static float[] RGBtoHSL(int red, int green, int blue) {
        float[] array = new float[3];

        float r = red / 255.0f;
        float g = green / 255.0f;
        float b = blue / 255.0f;

        float min = Math.min(r, Math.min(g, b));
        float max = Math.max(r, Math.max(g, b));

        float h = 0;

        if (max == min)
            h = 0;
        else if (max == r)
            h = ((60 * (g - b) / (max - min)) + 360) % 360;
        else if (max == g)
            h = (60 * (b - r) / (max - min)) + 120;
        else if (max == b)
            h = (60 * (r - g) / (max - min)) + 240;

        float l = (max + min) / 2;

        float s = 0;

        if (max == min)
            s = 0;
        else if (l <= .5f)
            s = (max - min) / (max + min);
        else
            s = (max - min) / (2 - max - min);

        array[0] = h;
        array[1] = s * 100;
        array[2] = l * 100;

        return array;
    }

    public static float[] RGBtoCMYK(int r, int g, int b) {
        float[] array = new float[4];
        float percentageR = (float) (r / 255.0 * 100);
        float percentageG = (float) (g / 255.0 * 100);
        float percentageB = (float) (b / 255.0 * 100);

        float k = 100 - Math.max(Math.max(percentageR, percentageG), percentageB);

        if (k == 100) {
            return new float[] { 0, 0, 0, 100 };
        }

        array[0] = (100 - percentageR - k) / (100 - k);
        array[1] = (100 - percentageG - k) / (100 - k);
        array[2] = (100 - percentageB - k) / (100 - k);
        array[3] = (int) k;
        return array;
    }

    public int getRGB() {
        return (255 << 24) | (rgb[0] << 16) | (rgb[1] << 8) | (rgb[2]);
    }

    public int getAlpha() {
        return getRed() / 255;
    }

    public int getRed() {
        return rgb[0];

    }

    public int getGreen() {
        return rgb[1];

    }

    public int getBlue() {
        return rgb[2];
    }

}
