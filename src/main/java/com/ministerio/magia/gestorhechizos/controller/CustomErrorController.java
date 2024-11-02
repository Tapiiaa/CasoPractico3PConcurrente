package com.ministerio.magia.gestorhechizos.controller;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public ResponseEntity<Map<String, Object>> handleError(WebRequest webRequest) {
        Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());
        HttpStatus status = getStatus(errorAttributes);

        // Personalizar el mensaje de error o agregar datos adicionales, si es necesario
        errorAttributes.put("message", "Ocurrió un error en la aplicación");
        errorAttributes.put("support", "Contacte a soporte técnico");

        return new ResponseEntity<>(errorAttributes, status);
    }

    private HttpStatus getStatus(Map<String, Object> errorAttributes) {
        Integer statusCode = (Integer) errorAttributes.get("status");
        if (statusCode != null) {
            return HttpStatus.valueOf(statusCode);
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
