package task1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"task1.beans2"})
@ComponentScan(basePackages = {"task1.beans3"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Bean[^DF]")})
public class AppConfig2 {
}
