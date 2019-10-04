package com.bdqn.gateway.exception;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.*;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: JsonExceptionHandler
 * create by:  xyf
 * description: TODO JSON异常处理类 自定义异常处理
 * SpringBoot 提供了默认的异常处理类，这显然不符合我们的预期
 * 因此需要重写此类，返回统一的 JSON 格式
 * create time: 2019/10/2 0002 下午 12:37
 */
public class JsonExceptionHandler extends DefaultErrorWebExceptionHandler {

    public JsonExceptionHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties, ErrorProperties errorProperties, ApplicationContext applicationContext) {
        super(errorAttributes, resourceProperties, errorProperties, applicationContext);
    }

    /**
     * description: TODO  获取异常属性
     * create time: 2019/10/2 0002下午 1:27
     *
     * @ param [request, includeStackTrace]
     * @ return java.util.Map<java.lang.String,java.lang.Object>
     */
    @Override
    protected Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
        int code = 500;
        Throwable error = super.getError(request);
        if (error instanceof NotFoundException) {
            code = 404;
        }
        return response(code, this.buildMessage(request, error));
    }

    /**
     * description: TODO  指定响应处理方法为 JSON 处理的方法
     * create time: 2019/10/2 0002下午 1:28
     *
     * @ param [errorAttributes]
     * @ return org.springframework.web.reactive.function.server.RouterFunction<org.springframework.web.reactive.function.server.ServerResponse>
     */
    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {

        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }

    /**
     * description: TODO 根据 code 获取对应的 HttpStatus
     * create time: 2019/10/2 0002下午 1:28
     *
     * @ param [errorAttributes]
     * @ return org.springframework.http.HttpStatus
     */
    @Override
    protected HttpStatus getHttpStatus(Map<String, Object> errorAttributes) {

        int statusCode = (int) errorAttributes.get("code");
        return HttpStatus.valueOf(statusCode);
    }

    /**
     * description: TODO  构建异常信息
     * create time: 2019/10/2 0002下午 1:05
     *
     * @ param [request, ex]
     * @ return java.lang.String
     */
    private String buildMessage(ServerRequest request, Throwable ex) {

        StringBuilder message = new StringBuilder("Failed to handle request [");
        message.append(request.methodName());
        message.append(" ");
        message.append(request.uri());
        message.append("]");
        if (ex != null) {
            message.append(": ");
            message.append(ex.getMessage());
        }
        return message.toString();
    }


    /**
     * description: TODO  构建返回的 JSON 数据格式
     * create time: 2019/10/2 0002下午 1:04
     *
     * @ param [status, errorMessage]
     * @ return java.util.Map<java.lang.String,java.lang.Object>
     */
    public static Map<String, Object> response(int status, String errorMessage) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", status);
        map.put("message", errorMessage);
        map.put("data", null);
        return map;
    }
}
