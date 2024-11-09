package com.separadorpix.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class IdentificadorPIXService {

    public String extrairIdentificadorPIX(String input) {
        // Expressão regular para encontrar um identificador PIX (telefone, email, CPF, CNPJ ou chave aleatória)
        Pattern pattern = Pattern.compile(
                "(\\b\\d{11}\\b)|" +             // CPF com 11 dígitos
                        "(\\b\\d{14}\\b)|" +             // CNPJ com 14 dígitos
                        "(\\b\\+?[1-9][0-9]{1,14}\\b)|" + // Telefone no formato internacional (ex: +5511999999999)
                        "(\\b[\\w.-]+@[\\w.-]+\\b)|" +   // Email padrão
                        "([a-zA-Z0-9\\-]{32})"           // Chave aleatória de 32 caracteres (alfanumérica)
        );

        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            // Retorna o identificador PIX encontrado na string
            return matcher.group();
        } else {
            // Caso nenhum identificador PIX seja encontrado
            return "Identificador PIX não encontrado na string.";
        }
    }
}
