// ClockInOut.java
import java.io.IOException;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClockInOut")
public class ClockInOut extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private boolean isClockedIn = false;
    private boolean isClockedOut = false;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Clock clock = Clock.systemDefaultZone();
        Instant instant = clock.instant();
        ZoneId zoneId = clock.getZone();

        request.setAttribute("currentTime", instant);
        request.setAttribute("currentTimeZone", zoneId);

        if (isClockedIn) {
            request.setAttribute("clockInButtonDisabled", true);
        } else {
            request.setAttribute("clockInButtonDisabled", false);
        }

        if (isClockedOut) {
            request.setAttribute("clockOutButtonDisabled", true);
        } else {
            request.setAttribute("clockOutButtonDisabled", false);
        }

        request.getRequestDispatcher("clockInOut.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("clockIn")) {
            Clock clock = Clock.systemDefaultZone();
            Instant clockInTime = clock.instant();
            ZoneId clockInZone = clock.getZone();

            request.setAttribute("clockInTime", clockInTime);
            request.setAttribute("clockInZone", clockInZone);

            isClockedIn = true;
            isClockedOut = false;

            request.getRequestDispatcher("clockInOut.jsp").forward(request, response);
        } else if (action.equals("clockOut")) {
            Clock clock = Clock.systemDefaultZone();
            Instant clockOutTime = clock.instant();
            ZoneId clockOutZone = clock.getZone();

            request.setAttribute("clockOutTime", clockOutTime);
            request.setAttribute("clockOutZone", clockOutZone);

            isClockedIn = false;
            isClockedOut = true;

            request.getRequestDispatcher("clockInOut.jsp").forward(request, response);
        }
    }
}