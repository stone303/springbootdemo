package com.example.springbootdemo.config;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.example.springbootdemo.interceptor.FlagTrackInterceptor;
import org.springframework.util.StringUtils;

/**
 * @author guocang.shi
 */
public class FlagPatternConverter extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        String flag = FlagTrackInterceptor.getFlag();
        return StringUtils.isEmpty(flag) ? "flag" : flag;
    }
}