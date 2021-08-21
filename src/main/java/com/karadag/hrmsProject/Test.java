package com.karadag.hrmsProject;

import java.rmi.RemoteException;

import tr.gov.nvi.tckimlik.WS.KPSPublicLocator;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class Test {
	public static void main(String[] args) {
		//org.apache.commons.logging.LogFactory Hatası alınırsa bu eklenmeli.
		System.setProperty("org.apache.commons.logging.LogFactory", "org.apache.commons.logging.impl.LogFactoryImpl");
//	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
//			  "cloud_name", "karadag",
//			  "api_key", "331497793914745",
//			  "api_secret", "T4ejZVzESCPWHRehevQZg_XiHts"));
//			
//			try {
//				//cloudinary.uploader().upload(new File("https://i4.hurimg.com/i/hurriyet/75/1110x740/5b8e6d967152d827603dd434.jpg"),ObjectUtils.asMap()); ->Kendi bilgisayarınızdan yükleyecekseniz
//				cloudinary.uploader().upload("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg",ObjectUtils.asMap()); //Linkten alacaksanız.
//			} catch (IOException e) {
//				e.printStackTrace();
//			}

//		JobSeekerCheckManager checkManager = new JobSeekerCheckManager(new MernisServiceAdapter());
//		checkManager.ifRealPerson("15473260288","Okan", "Karadağ", "1995");

		KPSPublicSoapProxy mhkkpsPublicSoap12 = new KPSPublicSoapProxy(null);
		boolean resul = false;
		
		KPSPublicLocator kpsPublicLocator=new KPSPublicLocator();
		try {
			resul=mhkkpsPublicSoap12.TCKimlikNoDogrula(Long.parseLong("15473260288"), "OKAN", "KARADAĞ", 1995);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(resul);
	}
}
