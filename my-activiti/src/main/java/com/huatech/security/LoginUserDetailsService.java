package com.huatech.security;

import com.huatech.entity.LoginUser;
import com.huatech.mapper.LoginUserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-07-25 13:50
 **/
@Component
@Primary()
public class LoginUserDetailsService implements UserDetailsService {
    @Resource
    private LoginUserMapper mapper;

    /**
     * 这个方法是比对用户的
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //密码加密测试
        String passWord = passwordEncoder().encode("222");
//        获取当前用户
        LoginUser loginUser = mapper.selectUserByUserName(username);
//        用户是否存在（不存在）
        if (Objects.isNull(loginUser)) {
            throw new UsernameNotFoundException("没有查到用户");
        }
//        存在（返回当前用户到userDetails去比对查询到的用户）
        return loginUser;
    }


    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
