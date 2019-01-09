package pl.sdacademy;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by adam.
 */
@WebServlet(name = "Download", value = "/Download.do")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"welcome.txt\"");

        ServletContext servletContext = getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("/welcome.txt");
        ServletOutputStream responseOutputStream = response.getOutputStream();

        byte[] buffer = new byte[8 * 1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            responseOutputStream.write(buffer, 0, bytesRead);
        }
        responseOutputStream.flush();
        responseOutputStream.close();
    }

}
