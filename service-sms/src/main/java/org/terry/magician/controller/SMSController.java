package org.terry.magician.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.netflix.client.ClientException;
import org.terry.magician.common.service.SMSServiceDefinition;
import org.terry.magician.common.util.IdService;
import org.terry.magician.domain.SMSLog;
import org.terry.magician.domain.SMSSendStatusEnum;
import org.terry.magician.repository.SMSLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Terry
 */
@RestController
public class SMSController implements SMSServiceDefinition {

    private static final int TYPE_SMS_TEXT = 1;

    private static final int TYPE_SMS_VOICE = 2;
    private static final String ACCESS_KEY_ID = "你的accessKeyId";
    private static final String ACCESS_KEY_SECRET = "你的accessKeySecret";
    private static final String SIGN_NAME = "阿里云短信测试专用";
    private static final String TEMPLATE_CODE = "你的templateCode";

    @Autowired
    SMSLogRepository smsLogRepository;

    @Autowired
    IdService idService;

    @Override
    public Boolean sendText(@RequestParam String mobilePhone, @RequestParam String code) {
        // TODO: 2017-07-06 接入阿里大鱼
        System.out.println(String.format("向%s发送文本验证码:%s", mobilePhone, code));
        String codemsg = "{\"code\":\"" + code + "\"}";
        SendSmsResponse sendSmsResponse = null;
        try {

            sendSmsResponse = SendMsgUtil.sendSms(ACCESS_KEY_ID,
                    ACCESS_KEY_SECRET,
                    mobilePhone, SIGN_NAME,
                    TEMPLATE_CODE,
                    codemsg,
                    null);
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (com.aliyuncs.exceptions.ClientException e) {
            e.printStackTrace();
        }
        boolean flag = Boolean.FALSE;
        SMSLog smsLog = new SMSLog();
        smsLog.setId(idService.newOne());
        smsLog.setSendTime(new Date());
        smsLog.setCode(code);
        smsLog.setMobilePhone(mobilePhone);
        smsLog.setOriginResult(""); // TODO: 2017-07-06
        smsLog.setType(TYPE_SMS_TEXT);
        if (sendSmsResponse != null && sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            flag = Boolean.TRUE;
            smsLog.setStat(SMSSendStatusEnum.SUCCESS.getCode());
            smsLog.setReturnCode(sendSmsResponse.getBizId());
        } else {
            flag = Boolean.TRUE;
            smsLog.setStat(SMSSendStatusEnum.ERROR.getCode());
        }
        smsLogRepository.save(smsLog);
        return flag;
    }

    @Override
    public Boolean sendVoice(@RequestParam String mobilePhone, @RequestParam String code) {
        // TODO: 2017-07-06 接入阿里大鱼
        System.out.println(String.format("向%s发送语音验证码:%s", mobilePhone, code));

        SMSLog smsLog = new SMSLog();

        smsLog.setId(idService.newOne());
        smsLog.setSendTime(new Date());
        smsLog.setCode(code);
        smsLog.setMobilePhone(mobilePhone);
        smsLog.setOriginResult(""); // TODO: 2017-07-06
        smsLog.setType(TYPE_SMS_VOICE);

        smsLogRepository.save(smsLog);

        return Boolean.TRUE;
    }
}
