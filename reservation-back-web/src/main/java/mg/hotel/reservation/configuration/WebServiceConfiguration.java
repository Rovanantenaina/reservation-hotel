package mg.hotel.reservation.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfiguration extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "reservationsWsdl")
    public DefaultWsdl11Definition reservationWsdl11Definition(@Qualifier("reservationXsdSchema") XsdSchema reservationSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ReservationPort");
        wsdl11Definition.setLocationUri("/ws/reservations");
        wsdl11Definition.setTargetNamespace("http://hotel.mg/reservation");
        wsdl11Definition.setSchema(reservationSchema);
        return wsdl11Definition;
    }

    @Bean(name = "reservationsAgenceWsdl")
    public DefaultWsdl11Definition reservationAgenceWsdl11Definition(@Qualifier("reservationAgenceXsdSchema") XsdSchema reservationAgenceSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ReservationAgencePort");
        wsdl11Definition.setLocationUri("/ws/reservations-agence");
        wsdl11Definition.setTargetNamespace("http://hotel.mg/reservation-agence");
        wsdl11Definition.setSchema(reservationAgenceSchema);
        return wsdl11Definition;
    }

    @Bean("reservationXsdSchema")
    public XsdSchema reservationSchema() {
        return new SimpleXsdSchema(new ClassPathResource("wsdl/reservations.xsd"));
    }

    @Bean("reservationAgenceXsdSchema")
    public XsdSchema reservationAgenceSchema() {
        return new SimpleXsdSchema(new ClassPathResource("wsdl/reservations-agence.xsd"));
    }

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        PayloadValidatingInterceptor validatingInterceptor = new PayloadValidatingInterceptor();
        validatingInterceptor.setValidateRequest(true);
        validatingInterceptor.setValidateResponse(true);
        validatingInterceptor.setXsdSchema(reservationAgenceSchema());
        interceptors.add(validatingInterceptor);
    }

}