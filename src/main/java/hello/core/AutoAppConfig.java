package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//1.        basePackages = "hello.core.member",
        //스캔 시작 위치 및 탐색 범위(하위 패키지) 지정
        //스캔 시간 단축 효과
//2.        basePackageClasses = AutoAppConfig.class,
//3.        default 옵션
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    } //빈 등록 충돌!
}
