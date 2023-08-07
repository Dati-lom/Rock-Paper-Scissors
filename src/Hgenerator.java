import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Hgenerator {
    private final String encoded;
    private final String key;
    public Hgenerator(String text) throws Exception {
        this.key = generateRandomKey();
        this.encoded = generateHMAC(encodeBase(text),this.key);
    }

    public String getEncoded() {
        return encoded;
    }

    public String getKey() {
        return key;
    }

    public static String encodeBase(String move){
        byte[] encodedBytes = Base64.getEncoder().encode(move.getBytes(StandardCharsets.UTF_8));
        return new String(encodedBytes,StandardCharsets.UTF_8);
    }
    private static String generateRandomKey() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstanceStrong();
        byte[] randBytes= new byte[32];
        random.nextBytes(randBytes);

        return Base64.getEncoder().encodeToString(randBytes);
    }
    private static String generateHMAC(String secretKey, String message) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        byte[] hmacBytes = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hmacBytes);
    }



}
