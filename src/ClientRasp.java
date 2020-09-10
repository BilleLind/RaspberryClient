import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class ClientRasp {
    public static void main(String[] args) {

    }
    private static String KEY = "0123456789012345";
    public static String decrypt(String encrypted_encoded_string) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {


        String host = "192.168.43.251";
        int port = 45050;
        String plain_text = "";

            try {
                Socket socket = new Socket(host, port);

                DataOutputStream outGoing = new DataOutputStream(socket.getOutputStream());
                DataInputStream inComing = new DataInputStream(socket.getInputStream());

                for (int i = 0; i <= 1000; i++) {
                    outGoing.writeUTF("send");
                    outGoing.flush();

                    System.out.println(i + " message sent");
                    String info = inComing.readUTF(); //readline() ?? why did they write it as a comment?

                    System.out.println("Message" + info);

                    Thread.sleep(10000);


                }
                outGoing.close();
                inComing.close();
                socket.close();

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

            try{
                byte[] encrypted_decoded_bytes = Base64.getDecoder().decode(encrypted_encoded_string);
                String encrypted_decoded_string = new String(encrypted_decoded_bytes);
                String iv_string = encrypted_decoded_string.substring(0,16); //IV is retrieved correctly.

                IvParameterSpec iv = new IvParameterSpec(iv_string.getBytes());
                SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes("UTF-8"), "AES");

                Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
                cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

                plain_text = new String(cipher.doFinal(encrypted_decoded_bytes));//Returns garbage characters
                return plain_text;

            }  catch (Exception e) {
                System.err.println("Caught Exception: " + e.getMessage());
            }
        return plain_text;
        }


    }


