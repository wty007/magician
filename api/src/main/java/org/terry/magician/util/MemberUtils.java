package org.terry.magician.util;

import org.terry.magician.domain.Member;
import org.springframework.util.StringUtils;

/**
 * @author Terry
 */
public class MemberUtils {

    public static boolean isGuestMember(Member member) {
        return StringUtils.isEmpty(member.getMobilePhone());
    }

}
