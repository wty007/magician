package org.terry.magician.rpc.hystrix;

import org.terry.magician.rpc.SMSServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Terry
 */
@Service
public class HystrixSMSServiceClient implements SMSServiceClient {

    @Autowired
    private SMSServiceClient smsServiceClient;

    public Boolean sendTextFallBackCall(String mobilePhone, String code) {
        return Boolean.FALSE;
    }

    public Boolean sendVoiceFallBackCall(String mobilePhone, String code) {
        return Boolean.FALSE;
    }

    @Override
    @HystrixCommand(fallbackMethod = "sendTextFallBackCall")
    public Boolean sendText(String mobilePhone, String code) {
        return smsServiceClient.sendText(mobilePhone, code);
    }

    @Override
    @HystrixCommand(fallbackMethod = "sendVoiceFallBackCall")
    public Boolean sendVoice(String mobilePhone, String code) {
        return smsServiceClient.sendVoice(mobilePhone, code);
    }

}

