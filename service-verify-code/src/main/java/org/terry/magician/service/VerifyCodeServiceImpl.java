package org.terry.magician.service;

import org.terry.magician.common.util.IdService;
import org.terry.magician.domain.VerifyCode;
import org.terry.magician.repository.VerifyCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Terry
 */
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {

    private static String[] verifyCodeArray = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    @Autowired
    IdService idService;

    @Autowired
    VerifyCodeRepository verifyCodeRepository;

    private static String createVerifyCode(int length) {
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            buffer.append(verifyCodeArray[(int) (Math.random() * 9)]);
        }
        return buffer.toString();
    }

    @Override
    public String newOne(String owner, Integer type, Integer expireMills) {
        final String code = createVerifyCode(6);

        VerifyCode verifyCode = new VerifyCode();
        verifyCode.setId(idService.newOne());
        verifyCode.setCode(code);

        final Date now = new Date();
        verifyCode.setCreateTime(now);

        verifyCode.setType(type);
        verifyCode.setOwner(owner);
        verifyCode.setUsed(Boolean.FALSE);

        final Date time = getExpireTime(expireMills, now);
        verifyCode.setExpireTime(time);

        verifyCodeRepository.save(verifyCode);

        return code;
    }

    private Date getExpireTime(Integer expireMills, Date now) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.MILLISECOND, expireMills);
        return calendar.getTime();
    }

    @Override
    public Boolean verify(String owner, String code, Integer type) {
        List<VerifyCode> verifyCodeList = verifyCodeRepository.findTop1ByOwnerAndCodeAndTypeAndUsedOrderByCreateTimeDesc(owner, code, type, Boolean.FALSE);

        if (CollectionUtils.isEmpty(verifyCodeList)) {
            return Boolean.FALSE;
        }

        for (VerifyCode verifyCode : verifyCodeList) {
            if (verifyCode.getExpireTime().getTime() >= Calendar.getInstance().getTimeInMillis()) {
                verifyCode.setUsed(Boolean.TRUE);
                verifyCode.setUseTime(new Date());
                verifyCodeRepository.save(verifyCode);
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }
}
