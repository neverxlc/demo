package com.example.demo;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.demo.annotation.EnableGlobalExceptionHandler;
import com.example.demo.annotation.EnableParamPrint;
import com.example.demo.domain.Car;
import com.example.demo.domain.CarDTO;
import com.example.demo.mapper.CarMapper;
import com.example.demo.service.StorageProperties;
import com.spring4all.swagger.EnableSwagger2Doc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Slf4j
@EnableConfigurationProperties(StorageProperties.class)
@EnableScheduling
//@EnableGlobalExceptionHandler
//@EnableParamPrint
//@ComponentScan(basePackages={"com.example.demo"})
//@EnableSwagger2Doc
public class DemoApplication extends SpringBootServletInitializer implements CommandLineRunner{

	@Autowired
	private ThreadPoolTaskScheduler taskScheduler;

	public static void main(String[] args) {
//		System.out.println("传入的参数是" + args[0]);
		SpringApplication.run(DemoApplication.class, args);
//		SpringApplication app = new SpringApplication(DemoApplication.class);
//		app.setBannerMode(Banner.Mode.OFF);
//		app.run(args);

	}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(DemoApplication.class);
//	}

	@Override
	public void run(String... args) throws Exception {

//		log.info("你好世界,{},zheshi ceshi ", args);
		System.out.println("hhhhh");
		System.err.println("xxxxxx");
		test();
//		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//		taskScheduler.initialize();
//		taskScheduler.getScheduledExecutor().scheduleAtFixedRate(()->{
//			System.out.println("当前线程是"+Thread.currentThread().getName());
//		},3,3, TimeUnit.SECONDS);
//		taskScheduler.scheduleAtFixedRate(()->{
//			System.out.println("当前线程是"+Thread.currentThread().getName());
//		}, new Date(), 10);

	}

	private void test(){
//		Car car = new Car( "Morris", 5);
//		CarDTO carDto = CarMapper.INSTANCE.carToCarDto( car );
//		log.info("car:{}",car);
//		log.info("carDTO:{}", carDto);

	}

//    @Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//
//
//		return args->{
//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}
//		};
//	}


//
//	public void test001(){
//		System.out.println("test001====="+Thread.currentThread().getName());
//	}

//	/**
//	 * Hikari DataSource configuration.
//	 */
//	@Configuration(proxyBeanMethods = false)
//	@ConditionalOnClass(DruidDataSource.class)
//	@ConditionalOnMissingBean(DataSource.class)
//	@ConditionalOnProperty(name = "spring.datasource.type", havingValue = "com.alibaba.druid.pool.DruidDataSource",
//			matchIfMissing = true)
//	static class Hikari {
//
//		@Bean
//		@ConfigurationProperties(prefix = "spring.datasource.druid")
//		DruidDataSource dataSource(DataSourceProperties properties) {
//			DruidDataSource dataSource = createDataSource(properties, DruidDataSource.class);
//			if (StringUtils.hasText(properties.getName())) {
//				dataSource.setName(properties.getName());
//			}
//			return dataSource;
//		}
//
//
//	}
//
//	@SuppressWarnings("unchecked")
//	protected static <T> T createDataSource(DataSourceProperties properties, Class<? extends DataSource> type) {
//		return (T) properties.initializeDataSourceBuilder().type(type).build();
//	}



}
