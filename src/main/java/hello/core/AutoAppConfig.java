package hello.core;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import static org.springframework.context.annotation.ComponentScan.*;
@Configuration
@ComponentScan(
//        지정하지않으면 @ComponentScan이 붙은 설정 정보 클래스의 패키지가 시작 위치
//        (AutoAppConfig -> hello.core 패키지) 따라서 프로젝트 시작 루트 위치에 두자!
//        basePackages = "hello.core.member",
//        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

/*
    // 수동 빈 등록이 우선권 (수동 빈이 자동 빈을 오버라이딩)
    @Bean(name = "memoryMemberRepository")
    public MemoryMemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
*/

}