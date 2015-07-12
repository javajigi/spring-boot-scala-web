package mvctest

import org.springframework.context.annotation.Configuration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = Array("mvctest", "support"))
class SampleConfig