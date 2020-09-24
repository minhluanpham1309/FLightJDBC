package com.project.FlightJDBC.config;

//<editor-fold defaultstate="collapsed" desc="comment">
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan
 * @email phamminhluan@fabercompany.co.jp
 */
public class ThymeleafDispathcerServlet extends DispatcherServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void render(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            super.render(mv, request, response);
        } catch (Exception ex) {
            logger.error(ExceptionUtils.getStackTrace(ex));
            throw new Exception();
        }
    }
}
