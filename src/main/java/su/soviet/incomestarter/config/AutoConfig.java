package su.soviet.incomestarter.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import su.soviet.incomestarter.client.IncomeClient;

@Configuration
@EnableConfigurationProperties(WebConfig.class)
public class AutoConfig {
    @Bean
    @ConditionalOnMissingBean
    public IncomeClient getIncomeClient(WebConfig webConfig) {
        return new IncomeClient(new RestTemplate(), webConfig);
    }
}