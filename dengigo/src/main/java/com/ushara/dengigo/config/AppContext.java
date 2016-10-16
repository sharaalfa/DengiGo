package com.ushara.dengigo.config;

@Configuration
@PropertySource(value = {"classpath:util.properties"})
@PropertySource(value = {"classpath:auth.properties"})
public class AppContext {
    @Autowired
    Environment environment;

    @Autowired
    HibernateConfig hibernateConfig;
    @Bean
    public AppInitialiser dataLoader(){
        return new AppInitialiser();
    }

    @Bean
    public CreateTable createTable(){
        return new CreateTable(jdbcTemplate());
    }

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.postgresql.driverClass"));
        dataSource.setUrl(environment.getProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getProperty("jdbc.postgresql.username"));
        dataSource.setPassword(environment.getProperty("jdbc.postgresql.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
        jdbcDao.setDataSource(hibernateConfig.dataSource());
        jdbcDao.setAuthoritiesByUsernameQuery(environment.getProperty("rolesByLogin"));
        jdbcDao.setUsersByUsernameQuery(environment.getProperty("usersByLogin"));
        return jdbcDao;
    }
}
