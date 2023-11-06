package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import spring.entity.User;
import spring.repository.UserRepository;

import javax.sql.DataSource;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(withDefaults())
                .authorizeHttpRequests((auth) ->
                        auth.requestMatchers(HttpMethod.POST, "/order","/product","/register")
                                .hasRole("USER")
                                .anyRequest()
                                .authenticated());
        return http.build();
    }

    @Bean
    public UserDetailsService users(UserRepository userRepository) {
        return username -> {
            User user = userRepository.findByUserName(username);
            if (user!= null) return user;
            throw new UsernameNotFoundException("User " + username + " not found!");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
