package com.Coralesk1.Spring_Boot_Phone_Book.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*Content Negotiation - é o mecanismo que decide qual formato de resposta (JSON, XML, HTML etc.)*/

@Configuration //diz ao spring que é necessario carregar as configurações dessa class
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        //VIA EXTENTION. http://localhost:8080/api/contacts/4.xml mas não funciona mais desse jeito
        //VIA QUERY PARAM http://localhost:8080/api/contacts/2?mediaType=xml que funciano mais é meio ruin por que vc adiciona mais um param na URL
        /*configurer.favorParameter(true)
                .parameterName("mediaType")
                .ignoreAcceptHeader(true)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                    //definindo o tipo que aceita
                    .mediaType("json", MediaType.APPLICATION_JSON)
                    .mediaType("xml", MediaType.APPLICATION_XML);
       Detalhe :
       via path é só para identificar recursos específicos , como requisições e id's
       e via header é para passar informações que não fazem parte da identificação do recurso,
       mas contexto da requisição, como Autenticação, controle de versão da api , tipo de conteudo (Json/xml).

       e como estamos trabalhando com o tipo de conteudo o melhor é pelo header

*/

        //VIA HEADER PARAM http://localhost:8080/api/contacts/2
        configurer.favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                //definindo o tipo que aceita
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML);


    }

}
