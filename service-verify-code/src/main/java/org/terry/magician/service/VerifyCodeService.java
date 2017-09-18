package org.terry.magician.service;

/**
 * @author Terry
 */
public interface VerifyCodeService {

    String newOne(String owner, Integer type, Integer expireMills);

    Boolean verify(String owner, String code, Integer type);
}
