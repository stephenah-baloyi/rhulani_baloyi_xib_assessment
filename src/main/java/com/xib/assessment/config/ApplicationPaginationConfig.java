package com.xib.assessment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Enable auto resolution of Pageable instance
 *
 */

@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
public class ApplicationPaginationConfig {}
