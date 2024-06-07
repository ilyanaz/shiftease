<!-- clockInOut.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clock In/Out Page</title>
</head>
<body>
    <h1>Clock In/Out Page</h1>
    <form action="ClockInOut" method="post">
        <input type="hidden" name="action" value="clockIn">
        <input type="submit" value="Clock In" ${clockInButtonDisabled? 'disabled' : ''}>
    </form>
    <form action="ClockInOut" method="post">
        <input type="hidden" name="action" value="clockOut">
        <input type="submit" value="Clock Out" ${clockOutButtonDisabled? 'disabled' : ''}>
    </form>

    <p>Current Time: ${currentTime}</p>
    <p>Current Time Zone: ${currentTimeZone}</p>

    <p>Clock In Time: ${clockInTime}</p>
    <p>Clock In Zone: ${clockInZone}</p>

    <p>Clock Out Time: ${clockOutTime}</p>
    <p>Clock Out Zone: ${clockOutZone}</p>

Calendar calendar = Calendar.getInstance();
calendar.add(Calendar.DAY_OF_YEAR, 1);
calendar.set(Calendar.HOUR_OF_DAY, 7);
calendar.set(Calendar.MINUTE, 40);
calendar.set(Calendar.SECOND, 0);
</body>
</html>