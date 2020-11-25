
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.math.NumberUtils;


public class SignatureEquity {

	
	public static void main(String args[]) throws IOException {		
		main87(null);		
	}
	
	public static void main87(String args[]) {
		Map<String, String> params = new LinkedHashMap<String, String>();		
		System.out.println(System.currentTimeMillis()/1000);
		params.put("requestUrl","https://uat-ebrex.loyrewards.com/rexSSOReceive");
		params.put("loyalty_id","1109561000000621");
		params.put("nonce","1234");
		params.put("program_code", "EBREX");
		params.put("signature_method","hmac-sha256");
		//params.put("timestamp","1566543564");
		
		List<String> lst = new ArrayList<String>();		
		lst.add("loyalty_id");
		lst.add("nonce");
		lst.add("program_code");
		lst.add("signature_method");		
		//lst.add("timestamp");

		String uri = getSignatureURI(params, lst);
		System.out.println("Uri ="+uri);
		String str = generateMacSignature_Dummy("hi7u1BnImmRaNlMAzgJQEDn0kawNX9IQWq9E2vZz", uri, "HmacSHA256");
		System.out.println("non encoded signature ="+str);
		String sig = URLEncoder.encode(str);
		
		System.out.println("https://uat-equitybankgroup.com/rexSSOReceive?loyalty_id="+params.get("loyalty_id")+"&nonce="+params.get("nonce")+"&program_code="+params.get("program_code")+"&signature_method="+params.get("signature_method")+"&signature="+str);
		

		
		//https://uat-ebrex.loyrewards.com/rexSSOReceive?loyalty_id=1109561000000621&nonce=1234&program_code=EBREX&signature_method=hmac-sha256&signature=LnH60H1joUzuwOIHUpOn14zMvRpJyHmTk9GwMiIxG5o=
		
	}
		
	public static String getSignatureURI(Map<String, String> allParams, List<String> paramsForSignature) {
		StringBuilder requestParam =  new StringBuilder();
		
		requestParam.append(allParams.get("requestUrl"));
		if(!paramsForSignature.isEmpty()) {
			requestParam.append("?");
			for(String param : paramsForSignature) {
				requestParam.append(param).append("=").append(allParams.get(param)).append("&");
			}
		}
		
		if(requestParam.lastIndexOf("&") == requestParam.length() - 1) {
			requestParam.setLength(Math.max(requestParam.length() - 1, 0));
		}

		return requestParam.toString();		
	}
	
	public static String generateMacSignature_Dummy(String key,String baseString, String hmcAlgo) {
		//System.out.println("key ="+key);
		//System.out.println("baseString ="+baseString);
		//System.out.println("hmacAlgo="+hmcAlgo);
		String appSignatureBaseString;
		try {
			appSignatureBaseString = baseString;
			
			//Standard java code to generate the HMAC (The base string would be HMACed using the secret key)
			String hmacAlgo = hmcAlgo;
			SecretKeySpec secretKeyObj = new SecretKeySpec(key.getBytes("UTF-8"),hmacAlgo);
			Mac mac = Mac.getInstance(hmacAlgo);	
			mac.init(secretKeyObj);
			byte[] macSignatureBytes = mac.doFinal(appSignatureBaseString.getBytes("UTF-8"));
			//Getting the Base64 encoded String from the byte array
			String macSignature =  new String(Base64.encodeBase64(macSignatureBytes)).replace("\r\n","");	
			return macSignature;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
}
