package com.bwie.gateway.filters;

import com.bwie.common.constants.TokenConstants;
import com.bwie.common.utils.JwtUtils;
import com.bwie.common.utils.StringUtils;
import com.bwie.gateway.config.IgnoreWhiteConfig;
import com.bwie.gateway.utils.GatewayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class AuthFilter implements GlobalFilter, Ordered {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private IgnoreWhiteConfig ignoreWhiteConfig;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        List<String> whites = ignoreWhiteConfig.getWhites();
        String path = exchange.getRequest().getURI().getPath();
        System.out.println("path >>>>>>>>>>>>>>>> = " + path);
        if(StringUtils.matches(path,whites)){
            return chain.filter(exchange);
        }

        String first = exchange.getRequest().getHeaders().getFirst(TokenConstants.TOKEN);
        if(null==first){
            return GatewayUtils.errorResponse(exchange,"token不为空", HttpStatus.UNAUTHORIZED);
        }

        try {
            JwtUtils.parseToken(first);
        } catch (Exception e) {
            return GatewayUtils.errorResponse(exchange,"token格式错误", HttpStatus.UNAUTHORIZED);
        }
        String userKey = JwtUtils.getUserKey(first);
        if(!redisTemplate.hasKey(TokenConstants.LOGIN_TOKEN_KEY+userKey)){
            return GatewayUtils.errorResponse(exchange,"token过期", HttpStatus.UNAUTHORIZED);

        }
        redisTemplate.expire(TokenConstants.LOGIN_TOKEN_KEY+userKey,15, TimeUnit.MINUTES);


        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
