package br.unirio.wsimxp.endpoint;

import br.unirio.wsimxp.entity.Site;
import br.unirio.wsimxp.entity.User;
import br.unirio.wsimxp.service.ISiteService;
import br.unirio.wsimxp.spring.BeanRetriever;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import java.util.Set;

import static org.apache.commons.lang.StringUtils.isBlank;

@WebService
public class SmartBrickEndpoint {

    @Resource
    private WebServiceContext context;

    public @WebResult(name = "site") Set<Site> getSitesForUser(String user){
        if(isBlank(user)){
            throw new IllegalArgumentException("User cannot be blank.");
        }
        return getSiteService().findByUser(new User(user));
    }

    private ISiteService getSiteService(){
        ServletContext servletContext = (ServletContext) context.getMessageContext().get("javax.xml.ws.servlet.context");
        return (ISiteService) BeanRetriever.getBean(servletContext, ISiteService.class);
    }
}
