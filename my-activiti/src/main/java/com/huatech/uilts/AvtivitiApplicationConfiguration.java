package com.huatech.uilts;

import static java.util.Arrays.asList;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-07-19 23:04
 **/
//@Configuration
public class AvtivitiApplicationConfiguration {
    private Logger logger;

    {
        logger = LoggerFactory.getLogger(AvtivitiApplicationConfiguration.class);
    }

    @Bean
    public UserDetailsService myUserDetailsService() {

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        String[][] usersGroupsAndRoles = {
                {"bajie", "123", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam"},
                {"wukong", "123", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam"},
                {"shaseng", "123", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam"},
                {"tangseng", "123", "ROLE_ACTIVITI_USER", "GROUP_otherTeam"},
                {"system", "password", "ROLE_ACTIVITI_USER"},
                {"admin", "password", "ROLE_ACTIVITI_USER", "GROUP_otherTeam"},
        };

        for (String[] user : usersGroupsAndRoles) {
            List<String> authoritiesStrings = asList(Arrays.copyOfRange(user, 2, user.length));
            logger.info("> Registering new user: " + user[0] + " with the following Authorities[" + authoritiesStrings + "]");
            inMemoryUserDetailsManager.createUser(new User(user[0], passwordEncoder().encode(user[1]),
                    authoritiesStrings.stream().map(s -> new SimpleGrantedAuthority(s)).collect(Collectors.toList())));
        }


        return inMemoryUserDetailsManager;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}