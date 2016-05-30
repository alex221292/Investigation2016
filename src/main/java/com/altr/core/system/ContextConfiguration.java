package com.altr.core.system;


import com.altr.core.services.IService.*;
import com.altr.core.services.ImplService.*;
import com.altr.core.services.business.shopservice.ShopBean;
import com.altr.core.services.business.shopservice.impl.ShopBeanImpl;
import com.altr.core.system.view.CommonPage;
import com.altr.core.system.view.impl.CommonPageImpl;
import org.hibernate.SessionFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;

/**
 * Created by Алексей on 20.05.2016.
 */
@Configuration
@EnableCaching
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.altr")
@Import({SecurityConfig.class})
public class ContextConfiguration extends WebMvcConfigurerAdapter implements TransactionManagementConfigurer {

    @Bean
    public DataSource dataSource() {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        return dsLookup.getDataSource("jdbc/ConnectionPool");
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public JdbcOperations jdbcOperations() {
        return new JdbcTemplate(dataSource());
    }

    @Override @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new HibernateTransactionManager(sessionFactory());
    }

    @Bean
    public UserBean userBean() {
        return new UserBeanImpl();
    }

    @Bean
    public CategoryBean categoryBean() {
        return new CategoryBeanImpl();
    }

    @Bean
    public BoxBean boxBean() {
        return new BoxBeanImpl();
    }

    @Bean
    public OrderBean orderBean() {
        return new OrderBeanImpl();
    }

    @Bean
    public ProductBean productBean() {
        return new ProductBeanImpl();
    }

    @Bean
    public CommonPage commonPage() {
        return new CommonPageImpl();
    }

    @Bean
    public ShopBean shopBean() {
        return new ShopBeanImpl();
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("user", "roles", "category");
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new LocalSessionFactoryBuilder(dataSource())
                .addAnnotatedClasses(com.altr.core.Model.UserTable.class,
                        com.altr.core.Model.RolesTable.class,
                        com.altr.core.Model.UserRoles.class,
                        com.altr.core.Model.ProductTable.class,
                        com.altr.core.Model.BoxesTable.class,
                        com.altr.core.Model.OrderTable.class,
                        com.altr.core.Model.CategoryTable.class)
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect").buildSessionFactory();
    }



}
