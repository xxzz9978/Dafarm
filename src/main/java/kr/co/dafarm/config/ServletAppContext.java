package kr.co.dafarm.config;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.dafarm.bean.AdminAccountBean;
import kr.co.dafarm.bean.SellerBean;
import kr.co.dafarm.bean.UserBean;
import kr.co.dafarm.interceptor.AdminLoginCheck;
import kr.co.dafarm.interceptor.CheckSellerLoginInterceptor;
import kr.co.dafarm.interceptor.CheckUserLoginInterceptor;
import kr.co.dafarm.interceptor.TopMenuInterceptor;
import kr.co.dafarm.mapper.AdminAccountMapper;
import kr.co.dafarm.mapper.AdminRevenueMapper;
import kr.co.dafarm.mapper.AdminSellerBoardMapper;
import kr.co.dafarm.mapper.AdminSellerMapper;
import kr.co.dafarm.mapper.AdminTradeLogMapper;
import kr.co.dafarm.mapper.AdminUserBoardMapper;
import kr.co.dafarm.mapper.AdminUserMapper;
import kr.co.dafarm.mapper.ProfitMapper;
import kr.co.dafarm.mapper.SellerMapper;
import kr.co.dafarm.mapper.SellerNoticeMapper;
import kr.co.dafarm.mapper.SellerOrderMapper;
import kr.co.dafarm.mapper.SellerProductMapper;
import kr.co.dafarm.mapper.UserBoardMapper;
import kr.co.dafarm.mapper.UserCartMapper;
import kr.co.dafarm.mapper.UserMapper;
import kr.co.dafarm.mapper.UserPaymentMapper;
import kr.co.dafarm.mapper.UserTradeMapper;

//Spring MVC 프로젝트에 관련된 설정을 하는 클래스
@Configuration

//Controller 어노테이션이 셋팅되어 있는 클래스를 Controller로 등록한다.
@EnableWebMvc

//DB 연결 PropertySource 경로 등록
@PropertySource("/WEB-INF/properties/db.properties")

//스캔할 패키지를 지정한다.
@ComponentScan({ "kr.co.dafarm.config", "kr.co.dafarm.controller", "kr.co.dafarm.service", "kr.co.dafarm.mapper",
		"kr.co.dafarm.dao", "kr.co.dafarm.bean", "kr.co.dafarm.interceptor" })
public class ServletAppContext implements WebMvcConfigurer {

	@Autowired
	private AdminAccountBean loginAdminBean;

	// ===DB 접속 정보 Value값 지정=============================================
	@Value("${db_classname}")
	private String db_classname;

	@Value("${db_url}")
	private String db_url;

	@Value("${db_username}")
	private String db_username;

	@Value("${db_password}")
	private String db_password;

	// === Autowired 및 Resource 지정 =========================================

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@Resource(name = "loginSellerBean")
	private SellerBean loginSellerBean;

	// === view 및 resources 적용을 위한 메서드들 (Start)

	// Controller 메서드가 반환하는 jsp 이름 앞뒤에 경로, 확장자 설정
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	// 정적 파일 경로 매핑
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	// === view 및 resources 적용을 위한 메서드들 (End)

	// ===DB 접속 정보를 관리하는 Bean=============================================
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(db_classname);
		source.setUrl(db_url);
		source.setUsername(db_username);
		source.setPassword(db_password);
		return source;
	}

	// === 로그인 유무에 따른 페이지 변환
	// ===========================================================

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);

		AdminLoginCheck adminLoginCheckInterceptor = new AdminLoginCheck(loginAdminBean);
		InterceptorRegistration reg30 = registry.addInterceptor(adminLoginCheckInterceptor);
		reg30.addPathPatterns("/admin/**"); // 관리자 페이지의 모든 하위 경로에 적용
		reg30.excludePathPatterns("/admin/login/**"); // 로그인 관련 경로는 제외

		TopMenuInterceptor topMenuInterceptor = new TopMenuInterceptor(loginUserBean);
		// Login 확인 후 TopMenu 전환 Interceptor 등록
		InterceptorRegistration reg1 = registry.addInterceptor(topMenuInterceptor);
		// Login 확인 후 TopMenu 전환 Interceptor 관심사 등록
		reg1.addPathPatterns("/**"); // 모든 요청 주소에 동작

		// ==== User Login 관련 Interceptor =================================
		// Login 확인 Interceptor 객체 생성
		CheckUserLoginInterceptor checkUserLoginInterceptor = new CheckUserLoginInterceptor(loginUserBean);
		// Login 확인 Interceptor 등록
		InterceptorRegistration reg2 = registry.addInterceptor(checkUserLoginInterceptor);
		// Login 확인 Interceptor 관심사 등록
		reg2.addPathPatterns("/users/user/mypage", "/users/user/logout", "/users/user/cart"); // 마이페이지, 로그아웃, 장바구니에 대하여
																								// 로그인 상태 체크

		// ==== User Login 관련 Interceptor =================================
		// Login 확인 Interceptor 객체 생성
		CheckSellerLoginInterceptor checkSellerLoginInterceptor = new CheckSellerLoginInterceptor(loginSellerBean);
		// Login 확인 Interceptor 등록
		InterceptorRegistration reg3 = registry.addInterceptor(checkSellerLoginInterceptor);
		// Login 확인 Interceptor 관심사 등록
		reg3.addPathPatterns("/seller/**");
	}

	// === Error Message 등록
	// ========================================================================
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
		res.setDefaultEncoding("UTF-8"); // 글자 꺠짐 방지 UTF-8 Encoding Set
		res.setBasenames("/WEB-INF/properties/error_message"); // Error Message File 경로 지정
		return res;
	}

	// 메세지와 property 충돌을 막기 위함.
	// 소스와 메시지 별도 관리 하도록 property를 Bean으로 등록
	@Bean
	public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	// ===이하 아래======= DB 및 Mapper 관련 객체들
	// ====================================================

	// 쿼리문과 접속 정보를 관리하는 객체
	@Bean
	public SqlSessionFactoryBean factory(BasicDataSource source) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(source);
		return factoryBean;
	}

	// AdminUsermapper등록
	@Bean
	public MapperFactoryBean<AdminUserMapper> adminBuyerMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<AdminUserMapper> adminUserMapper = new MapperFactoryBean<>(AdminUserMapper.class);
		adminUserMapper.setSqlSessionFactory(factory);

		return adminUserMapper;
	}

	// AdminSellermapper
	@Bean
	public MapperFactoryBean<AdminSellerMapper> adminSellerMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<AdminSellerMapper> adminSellerMapper = new MapperFactoryBean<>(AdminSellerMapper.class);
		adminSellerMapper.setSqlSessionFactory(factory);

		return adminSellerMapper;
	}

	// AdminRevenueMapper
	@Bean
	public MapperFactoryBean<AdminRevenueMapper> adminRevenueMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<AdminRevenueMapper> adminRevenueMapper = new MapperFactoryBean<>(AdminRevenueMapper.class);
		adminRevenueMapper.setSqlSessionFactory(factory);

		return adminRevenueMapper;
	}

	// AdminRevenueMapper
	@Bean
	public MapperFactoryBean<AdminAccountMapper> adminAccountMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<AdminAccountMapper> adminAccountMapper = new MapperFactoryBean<>(AdminAccountMapper.class);
		adminAccountMapper.setSqlSessionFactory(factory);

		return adminAccountMapper;
	}

	// AdminBoardMapper
	@Bean
	public MapperFactoryBean<AdminUserBoardMapper> adminUserBoardMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<AdminUserBoardMapper> adminUserBoardMapper = new MapperFactoryBean<>(
				AdminUserBoardMapper.class);
		adminUserBoardMapper.setSqlSessionFactory(factory);

		return adminUserBoardMapper;
	}

	// AdminBoardMapper
	@Bean
	public MapperFactoryBean<AdminSellerBoardMapper> adminSellerBoardMapper(SqlSessionFactory factory)
			throws Exception {
		MapperFactoryBean<AdminSellerBoardMapper> adminSellerBoardMapper = new MapperFactoryBean<>(
				AdminSellerBoardMapper.class);
		adminSellerBoardMapper.setSqlSessionFactory(factory);

		return adminSellerBoardMapper;
	}

	@Bean
	public MapperFactoryBean<UserMapper> usersInfoMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<UserMapper> usersInfoMapper = new MapperFactoryBean<>(UserMapper.class);
		usersInfoMapper.setSqlSessionFactory(factory);

		return usersInfoMapper;
	}

	// UserBoardMapper 등록
	@Bean
	public MapperFactoryBean<UserBoardMapper> UserBoardMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<UserBoardMapper> factoryBean = new MapperFactoryBean<UserBoardMapper>(UserBoardMapper.class);
		factoryBean.setSqlSessionFactory(factory);

		return factoryBean;
	}

	// UserTradeMapper 등록
	@Bean
	public MapperFactoryBean<UserTradeMapper> UserTradeMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<UserTradeMapper> factoryBean = new MapperFactoryBean<UserTradeMapper>(UserTradeMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	// UserCartMapper 등록
	@Bean
	public MapperFactoryBean<UserCartMapper> UserCartMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<UserCartMapper> factoryBean = new MapperFactoryBean<UserCartMapper>(UserCartMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	// UserPaymentMapper 등록
	@Bean
	public MapperFactoryBean<UserPaymentMapper> UserPaymentMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<UserPaymentMapper> factoryBean = new MapperFactoryBean<UserPaymentMapper>(UserPaymentMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
	// SellerMapper 등록
	@Bean 
	public MapperFactoryBean<SellerMapper> getSellerMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<SellerMapper> factoryBean = new MapperFactoryBean<SellerMapper>(SellerMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	// SellerProductMapper 등록
	@Bean
	public MapperFactoryBean<SellerProductMapper> getSellerProductMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<SellerProductMapper> factoryBean = new MapperFactoryBean<SellerProductMapper>(
				SellerProductMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	// SellerOrderMapper 등록
	@Bean
	public MapperFactoryBean<SellerOrderMapper> getSellerOrderMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<SellerOrderMapper> factoryBean = new MapperFactoryBean<SellerOrderMapper>(
				SellerOrderMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	// ProfitMapper 등록
	@Bean
	public MapperFactoryBean<ProfitMapper> ProfitMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<ProfitMapper> factoryBean = new MapperFactoryBean<ProfitMapper>(ProfitMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	@Bean
	public MapperFactoryBean<AdminTradeLogMapper> AdminTradeLogMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<AdminTradeLogMapper> factoryBean = new MapperFactoryBean<AdminTradeLogMapper>(AdminTradeLogMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
	@Bean
	public MapperFactoryBean<SellerNoticeMapper> getSellerNoticeMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<SellerNoticeMapper> factoryBean = new MapperFactoryBean<SellerNoticeMapper>(SellerNoticeMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

}
