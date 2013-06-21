package br.unirio.wsimxp.endpoint;

import br.unirio.wsimxp.entity.Site;
import br.unirio.wsimxp.entity.User;
import br.unirio.wsimxp.service.ISiteService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebService
public class SmartBrickEndpoint {

    @Resource
    private WebServiceContext context;

    public Set<Site> getSitesForUser(String user){
        return getSiteService().findByUser(new User(user));
    }

    private ISiteService getSiteService(){
        ServletContext servletContext = (ServletContext) context.getMessageContext().get("javax.xml.ws.servlet.context");
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        return webApplicationContext.getAutowireCapableBeanFactory().getBean(ISiteService.class);
    }
}
