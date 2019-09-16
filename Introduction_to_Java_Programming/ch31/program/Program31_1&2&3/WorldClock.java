import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Created by copperfield on 18/12/2016.
 */
public class WorldClock extends JPanel {
    private TimeZone timeZone = TimeZone.getTimeZone("EST");
    private Timer timer = new Timer(1000, new TimerListener());
    private StillClock clock = new StillClock();
    private JLabel jlblDigitTime = new JLabel("", JLabel.CENTER);
    
    public WorldClock() {
        setLayout(new BorderLayout());
        add(clock, BorderLayout.CENTER);
        add(jlblDigitTime, BorderLayout.SOUTH);
        timer.start();
    }
    
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
    
    
    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar calendar = new GregorianCalendar(timeZone, getLocale());
            clock.setHour(calendar.get(Calendar.HOUR));
            clock.setMinute(calendar.get(Calendar.MINUTE));
            clock.setSecond(calendar.get(Calendar.SECOND));
    
            DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.LONG, getLocale());
            formatter.setTimeZone(timeZone);
            jlblDigitTime.setText(formatter.format(calendar.getTime()));
        }
    }
}
