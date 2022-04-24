package com.example.tp4.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //using jdbc Authentication :
        //aprés l'authentification il vas exécuter la requete pour savoir quel role
        /*PasswordEncoder passwordEncoder=passwordEncoder();
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username as principal, password as credentials, active from users where username=?")
                //chargement de role
                .authoritiesByUsernameQuery("select username as principal, role as role from users_roles where username=?")
                //ajouter un prefix exemple => ROLE_ADMIN
                .rolePrefix("ROLE_")
                //password encoder
                .passwordEncoder(passwordEncoder);
*/

        //using inMemoryAuthentication
        //user qui ont le droit d'acceder à l'app
        //noop => indiquer au spring qu'il y a pas password hasher
        PasswordEncoder passwordEncoder=passwordEncoder();
        String encodePWD=passwordEncoder.encode("1234");
        System.out.println(encodePWD);
        auth.inMemoryAuthentication().withUser("user1").password(encodePWD).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("1111")).roles("USER","ADMIN");
        auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder.encode("0000")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //utiliser un formulaire :
        http.formLogin();
        //permission de la page home => rendre public
        http.authorizeRequests().antMatchers("/").permitAll();
        //indiquer les paths (url) accessible au user => "admin"
        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
        //indiquer les paths (url) accessible au user => "user1"
        http.authorizeRequests().antMatchers("/user/**").hasRole("USER");
        //tous le reste ca nécissite une authentification
        http.authorizeRequests().anyRequest().authenticated();
        http.exceptionHandling().accessDeniedPage("/403");
    }

    //Utiliser Bcrypte comme type de cryptage
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
