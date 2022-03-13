package no.kebabproffen.filters;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

enum LogLevel{
    INFO, ERROR, DEBUG 
}


@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
@WebFilter("/")
public class LogFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(LogFilter.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
                HttpServletRequest httpRequest = (HttpServletRequest) request;


                logger.info(String.format("%s: %s - %s",getFormatLocalDateTime(LocalDateTime.now()), LogLevel.INFO, createHttpRequestLogString(httpRequest)));
                chain.doFilter(request, response);
    }

    private String createHttpRequestLogString(HttpServletRequest request){
        String logString = String.format("Request by: %s, Type: %s, Target: %s, Length: %o ",request.getRemoteAddr(), request.getMethod(),request.getContextPath(), request.getContentLength());
        return logString;
    }

    private String getFormatLocalDateTime(LocalDateTime time){
        return dateTimeFormatter.format(time);
    }
    
}
