//Kryptografia
//Zadanie 3 - Szyfry blokowe
//Seweryn Rutkowski 240865


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.Key;

class Helper
{
    private static final int CHUNK_WIDTH = 4;
    private static final int CHUNK_HEIGHT = 3;

    private int cols;
    private int rows;

    public Helper()
    {
        cols = 0;
        rows = 0;
    }


    private BufferedImage readBmpImage ()
    {
        File file = new File("plain.bmp");
        FileInputStream fis;
        BufferedImage image = null;
        try {
            fis = new FileInputStream(file);
            image = ImageIO.read(fis);
        }
        catch(IOException e){ System.out.println(e.getStackTrace()); }
        return image;
    }

    private BufferedImage[] divideImageToChunks()
    {
        BufferedImage image = readBmpImage();

        this.rows = image.getWidth()/CHUNK_WIDTH;
        this.cols = image.getHeight()/CHUNK_HEIGHT;
        int chunks = rows * cols;

        int count = 0;
        BufferedImage images[] = new BufferedImage[chunks]; //Image array to hold image chunks
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                //Initialize the image array with image chunks
                images[count] = new BufferedImage(CHUNK_WIDTH, CHUNK_HEIGHT, image.getType());

                // draws the image chunk
                Graphics2D gr = images[count++].createGraphics();
                gr.drawImage(image, 0, 0, CHUNK_WIDTH, CHUNK_HEIGHT, CHUNK_WIDTH * y, CHUNK_HEIGHT * x, CHUNK_WIDTH * y + CHUNK_WIDTH, CHUNK_HEIGHT * x + CHUNK_HEIGHT, null);
                gr.dispose();
            }
        }
        return images;
    }

    private BufferedImage mergeChunksToImage(BufferedImage[] chunks)
    {
        int type = chunks[0].getType();

        //Initializing the final image
        BufferedImage finalImg = new BufferedImage(CHUNK_WIDTH*cols, CHUNK_HEIGHT*rows, type);

        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                finalImg.createGraphics().drawImage(chunks[num], CHUNK_WIDTH * j, CHUNK_HEIGHT * i, null);
                num++;
            }
        }
        return finalImg;
    }

}


public class Block {

    public static void main(String[] args) throws Exception
    {
        File f = new File("plain.bmp");
        if(!f.exists()) {
            System.out.println("Brak pliku plain.bmp");
        }

        FileInputStream fs = new FileInputStream("plain.bmp");

        int HEADER_LENGTH = 14;  // 14 byte bmp header
        byte header [] = new byte[HEADER_LENGTH];
        fs.read(header, 0, HEADER_LENGTH);

        int INFO_HEADER_LENGTH = 40; // 40-byte bmp info header
        byte infoheader [] = new byte[INFO_HEADER_LENGTH];
        fs.read(infoheader, 0, INFO_HEADER_LENGTH);

        byte[] content = new byte[fs.available()];
        fs.read(content);

        writeToFile(header, infoheader, ecbEncrypt(content, "AES/ECB/PKCS5Padding"),"ecb_crypto.bmp");
        writeToFile(header, infoheader, cbcEncrypt(content, "AES/CBC/PKCS5Padding"),"cbc_crypto.bmp");
        fs.close();
    }

    public static byte [] ecbEncrypt(byte [] input, String transformation) throws Exception
    {
        Cipher cipher = Cipher.getInstance(transformation);
        Key secretKey = new SecretKeySpec("AvRh3DcpLdeA1321".getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(input);
    }

    public static byte [] cbcEncrypt(byte [] input, String transformation) throws Exception
    {
        Cipher cipher = Cipher.getInstance(transformation);
        Key secretKey = new SecretKeySpec("AvRh3DcpLdeA1321".getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(input);
    }


    public static void writeToFile(byte[] header, byte [] infoheader, byte [] content, String fileToWrite) throws Exception
    {
        FileOutputStream fos = new FileOutputStream(fileToWrite);
        fos.write(header);
        fos.write(infoheader);
        fos.write(content);
        fos.flush();
        fos.close();
    }

}
