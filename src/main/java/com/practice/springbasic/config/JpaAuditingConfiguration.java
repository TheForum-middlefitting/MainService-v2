package com.practice.springbasic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Spring Data JPA를 이용하여 엔티티의 생성시간과 수정시간을 자동으로 처리하기 위한 설정 클래스입니다.
 * <p>
 * 엔티티 클래스에서 @EntityListeners(AuditingEntityListener.class) 어노테이션을 추가하여 활성화합니다.
 * </p>
 *
 * @author middlefitting
 * @version 1.0.0
 * @since 2023-04-05
 */
@Configuration
@EnableJpaAuditing
public class JpaAuditingConfiguration {

}
