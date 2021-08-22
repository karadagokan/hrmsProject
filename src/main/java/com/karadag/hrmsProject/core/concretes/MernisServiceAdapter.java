package com.karadag.hrmsProject.core.concretes;

import com.karadag.hrmsProject.core.abstracts.JobSeekerCheckService;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;


public class MernisServiceAdapter implements JobSeekerCheckService {

    @Override
    public boolean ifRealPerson(String nationalityId, String firstName, String lastName, String yearOfBirth) {

        KPSPublicSoapProxy mhkkpsPublicSoap12 = new KPSPublicSoapProxy();

        try {
            boolean isReal = mhkkpsPublicSoap12.TCKimlikNoDogrula(Long.parseLong(nationalityId),
                    firstName.toUpperCase(), lastName.toUpperCase(),
                    Integer.parseInt(yearOfBirth));
            if (!isReal) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


}
