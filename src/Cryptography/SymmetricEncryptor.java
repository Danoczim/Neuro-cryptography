/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cryptography;

/**
 *
 * @author Matt
 */
import java.nio.charset.Charset;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder;

public class SymmetricEncryptor {
    private Cipher encryptCipher;
    private Cipher decryptCipher;    
    private String hashedPublicKey;

    public String encrypt(String plainData, String publicKey, SymmetricCryptoMethod method, Charset charset) throws Exception {
        byte[] plainbytes = plainData.getBytes(charset);
        encryptCipher = Cipher.getInstance(method.getName() + "/ECB/PKCS5Padding");
        encryptCipher.init(Cipher.ENCRYPT_MODE, buildKey(publicKey, method, charset));
        byte[] cipherbytes = encryptCipher.doFinal(plainbytes);
        return new sun.misc.BASE64Encoder().encode(cipherbytes);
    }

    public String decrypt(String encryptedString, String publicKey, SymmetricCryptoMethod method, Charset charset) throws Exception {
        decryptCipher = Cipher.getInstance(method.getName() + "/ECB/PKCS5Padding");
        decryptCipher.init(Cipher.DECRYPT_MODE, buildKey(publicKey, method, charset));
        byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(encryptedString);
        byte[] textDecrypted = decryptCipher.doFinal(dec);
        return new String(textDecrypted, charset);
    }

    private SecretKeySpec buildKey(String publicKey, SymmetricCryptoMethod method, Charset charset) throws Exception {
        MessageDigest digester = MessageDigest.getInstance(method.getKeyHashMethod());
        digester.update(publicKey.getBytes(charset));
        byte[] key = digester.digest();
        hashedPublicKey = new sun.misc.BASE64Encoder().encode(key);
        SecretKeySpec spec = new SecretKeySpec(key,0,method.getKeyLengthInBytes(), method.getName());
        return spec;
    }

    public Cipher getEncryptCipher() {
        return encryptCipher;
    }

    public Cipher getDecryptCipher() {
        return decryptCipher;
    }

    public String getHashedPublicKey() {
        return hashedPublicKey;
    }
}
