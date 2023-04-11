package com.practice.springbasic.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Spring Security 설정 클래스입니다.
 *
 * <p>이 클래스는 Spring Security의 설정을 구성하는 역할을 합니다. {@link WebSecurityConfigurerAdapter}를
 * 상속받아 구현하며, configure(HttpSecurity http) 메서드를 오버라이드하여 HttpSecurity 객체를 커스터마이징합니다.</p>
 *
 * <p>이 설정 클래스는 다음과 같은 작업을 수행합니다.</p>
 *
 * <ul>
 *   <li>CSRF 토큰을 비활성화합니다.</li>
 *   <li>Form Login 을 비활성화합니다.</li>
 *   <li>HTTP Basic 인증을 비활성화합니다.</li>
 *   <li>모든 요청에 대해 인증 없이 접근 가능하도록 설정합니다.</li>
 *   <li>X-Frame-Options 헤더를 비활성화합니다.</li>
 *   <li>CORS 를 허용하는 설정을 추가합니다. 허용되는 도메인과 메서드를 설정할 수 있습니다.</li>
 * </ul>
 *
 * @author middlefitting
 * @see WebSecurityConfigurerAdapter
 * @version 1.0.0
 * @since 2023-04-05
 */
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.formLogin().disable();
    http.httpBasic().disable();
    http.authorizeRequests().antMatchers("/**").permitAll();
    http.headers().frameOptions().disable();
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.addAllowedOrigin("http://127.0.0,1:8000");
    configuration.addAllowedOrigin("http://localhost:8000");
    configuration.addAllowedOrigin("http://192.168.219.109:8000");
    configuration.addAllowedMethod("*");
    configuration.addExposedHeader("*");
    configuration.addAllowedMethod("*");
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
}

