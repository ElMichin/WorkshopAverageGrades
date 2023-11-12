package co.edu.unbosque.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static org.apache.commons.codec.binary.Base64.encodeBase64;
import static org.apache.commons.codec.binary.Base64.decodeBase64;

public class AESUtil {
	
	private static final String ALGORITHM="AES";
	private static final String CIPHER_TYPE="AES/CBC/PKCS5Padding";
	
	public static String encrypt(String txt) {
		String iv="holamundo1234567" ;
		String key="llavede16caracte" ;
		return encrypt(key, iv, txt);
	}
	
	public static String encrypt(String key, String iv, String txt) {
		Cipher cipher=null;
		try {
			cipher=Cipher.getInstance(CIPHER_TYPE);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		SecretKeySpec secretKeySpec=new SecretKeySpec(key.getBytes(), ALGORITHM);
		IvParameterSpec ivParameterSpec=new IvParameterSpec(iv.getBytes());
		try {
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec,ivParameterSpec);
		} catch (InvalidKeyException | InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
		byte [] encrypted=null;
		try {
			encrypted=cipher.doFinal(txt.getBytes());
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return new String(encodeBase64(encrypted));
	}
	
	public static String decrypt(String txt) {
		String iv="holamundo1234567" ;
		String key="llavede16caracte" ;
		return decrypt(key, iv, txt);
	}
	
	public static String decrypt(String key, String iv, String txt) {
		Cipher cipher=null;
		
		try {
			cipher=cipher.getInstance(CIPHER_TYPE);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		SecretKeySpec secretKeySpec=new SecretKeySpec(key.getBytes(), ALGORITHM);
		IvParameterSpec ivParameterSpec=new IvParameterSpec(iv.getBytes());
		
		try {
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
		} catch (InvalidKeyException | InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
		
		byte[]encrypted=decodeBase64(txt);
		byte[]decrypted=null;
		
		try {
			decrypted=cipher.doFinal(encrypted);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		
		return new String (decrypted);
	}
	
	
}
