package darius.licenta.backend.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public SpringSecurityConfiguration(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.exceptionHandling().accessDeniedPage("/login");
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/users/signup")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/api/users/login")
                .permitAll()
                .anyRequest()
                .authenticated();

        http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        final CorsConfiguration configuration = new CorsConfiguration();

        List<String> allowedOrigins = new ArrayList<>();
        allowedOrigins.add("http://localhost:3000");
        allowedOrigins.add("http://localhost:3000");

        configuration.setAllowedOrigins(allowedOrigins);
        List<String> allowedMethods = new ArrayList<>();
        allowedMethods.add("HEAD");
        allowedMethods.add("GET");
        allowedMethods.add("POST");
        allowedMethods.add("PUT");
        allowedMethods.add("DELETE");
        allowedMethods.add("PATCH");

        configuration.setAllowedMethods(allowedMethods);

        configuration.setAllowCredentials(true);

        List<String> allowedHeaders = new ArrayList<>();
        allowedHeaders.add("Authorization");
        allowedHeaders.add("Cache-Control");
        allowedHeaders.add("Content-Type");
        allowedHeaders.add("Content-Disposition");

        configuration.setAllowedHeaders(allowedHeaders);
        configuration.addExposedHeader("Filename");
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/configuration/**")
                .antMatchers("/webjars/**") //
                .antMatchers("/public")
                .antMatchers("/h2-console/**/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
