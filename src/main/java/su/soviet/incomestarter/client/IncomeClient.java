package su.soviet.incomestarter.client;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import su.soviet.incomestarter.config.WebConfig;
import su.soviet.incomestarter.dto.UserDTO;

import java.util.Objects;

@Service
@PropertySource("default.yml")
public class IncomeClient {

    private final RestTemplate template;
    private final WebConfig webConfig;

    public IncomeClient(RestTemplate template, WebConfig webConfig) {
        this.template = template;
        this.webConfig = webConfig;
    }

    public int getIncome(Long id) {
        UserDTO[] users = template.getForObject(webConfig.getIncomeUrl(), UserDTO[].class);
        for (UserDTO userDTO : users) {
            if (Objects.equals(userDTO.getId(), id)) {
                return userDTO.getIncome();
            }
        }
        return 0;
    }
}
