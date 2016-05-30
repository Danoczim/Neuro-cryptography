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
public enum SymmetricCryptoMethod {
    DES("DES","MD5",8),
    TripleDES("DESede","SHA-256",24),
    AES("AES","SHA-256",16),
    Blowfish("Blowfish","SHA-256",16),
    RC2("RC2","SHA-256",16);
    
    private final String name;
    private final String keyHashMethod;
    private final int keyLength;
    /**
     * @param name
     */
    private SymmetricCryptoMethod(final String name, final String keyHashMethod, final int keyLength) {
        this.name = name;
        this.keyHashMethod = keyHashMethod;
        this.keyLength = keyLength;
    }
    
    public String getName(){
        return name;
    }
    
    public String getKeyHashMethod(){
        return keyHashMethod;
    }
    
    public int getKeyLengthInBytes(){
        return keyLength;
    }
}
