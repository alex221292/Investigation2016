package com.altr.core.system;

import com.altr.core.services.UserBean;
import com.altr.core.services.UserBeanImpl;
import com.altr.solutions.strimach.ClassModel.UserModel.UserFactory;
import com.altr.solutions.strimach.ClassModel.UserModel.UserFactoryImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;

/**
 * Created by Алексей on 20.05.2016.
 */
@Configuration
@EnableCaching
@EnableWebMvc
@ComponentScan("com.altr")
@Import({ SecurityConfig.class })
@ImportResource("classpath:spring/config/BeanLocations.xml")
public class ContextConfiguration {
    @Bean
    public DataSource dataSource() {
        final BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/solution");
        ds.setUsername("root");
        ds.setPassword("431039");
        return ds;
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public JdbcOperations jdbcOperations() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public UserFactory userFactory() {
        return new UserFactoryImpl();
    }

    @Bean
    public UserBean userBean() {
        return new UserBeanImpl();
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("user", "roles");
    }

}
