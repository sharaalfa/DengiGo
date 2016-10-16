package com.ushara.dengigo.config.application;

@Configuration
@EnableWebMvc
@ComponentScan({"com.ushara.dengigo.config", "com.ushara.dengigo.controller", "com.ushara.dengigo","com.ushara.dengigo.config.db",})
public class WebConfig extends WebMvcConfigurerAdapter{
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    ViewResolver tilesViewResolver(){
        TilesViewResolver viewResolver = new TilesViewResolver();
        viewResolver.setOrder(0);
        return viewResolver;
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setContentType("text/html; charset-utf-8");
        viewResolver.setOrder(1);
        return viewResolver;
    }
    @Bean
    TilesConfigurer tilesConfigurer(){
        TilesConfigurer tiles = new TilesConfigurer();
        tiles.setDefinitions("/WEB-INF/views/layout/tiles.xml");
//        tiles.setDefinitions("file: web/WEB-INF/views/layout/tiles.xml"); // for junit
//        tiles.setDefinitionsFactoryClass(TilesDefinitionsConfig.class); // for java config
//        // Add apache tiles definitions
//        TilesDefinitionsConfig.addDefinitions();
        tiles.setCheckRefresh(true);
        return tiles;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/views/css/");
        registry.addResourceHandler("/bootstrap/**").addResourceLocations("/WEB-INF/views/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/views/js/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/WEB-INF/views/fonts/");
        registry.addResourceHandler("/font-awesome/**").addResourceLocations("/WEB-INF/views/font-awesome/");
        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/views/img/");
    }
}
