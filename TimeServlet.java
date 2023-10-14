import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        TimeZoneConverter converter = new TimeZoneConverter();
        String timezone = req.getParameter("timezone");
        if(timezone == null) {
            resp.getWriter().write(converter.timeZoneConvert("UTC"));
        }else {
            resp.getWriter().write(converter.timeZoneConvert(timezone));
        }
    }
}
