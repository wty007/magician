package org.terry.magician.repository;

import org.terry.magician.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Terry
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    List<Member> findByLoginNameAndPassword(String loginName, String password);

    Member findByMobilePhone(String mobilePhone);

    Member findByToken(String token);

    List<Member> findByMobilePhoneAndPassword(String mobilePhone, String md5password);
}
