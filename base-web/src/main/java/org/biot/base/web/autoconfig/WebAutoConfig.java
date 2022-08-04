package org.biot.base.web.autoconfig;

import org.biot.base.web.advice.GlobalExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = { GlobalExceptionHandler.class })
public class WebAutoConfig {
}
