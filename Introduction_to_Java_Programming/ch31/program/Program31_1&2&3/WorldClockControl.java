import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by copperfield on 18/12/2016.
 */
public class WorldClockControl extends JPanel {
    private Locale[] availableLocales = Locale.getAvailableLocales();
    private String[] availableTimeZones = TimeZone.getAvailableIDs();
    
    private JComboBox jcbLocales = new JComboBox();
    private JComboBox jcbTimeZones = new JComboBox();
    
    private WorldClock clock = new WorldClock();
    
    public WorldClockControl() {
        setAvailableLocates();
        setAvailableTimeZones();
        
        clock.setLocale(availableLocales[jcbLocales.getSelectedIndex()]);
        clock.setTimeZone(TimeZone.getTimeZone(availableTimeZones[jcbTimeZones.getSelectedIndex()]));
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 1));
        panel1.add(new JLabel("Locale"));
        panel1.add(new JLabel("Time Zone"));
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 1));
        panel2.add(jcbLocales, BorderLayout.CENTER);
        panel2.add(jcbTimeZones, BorderLayout.CENTER);
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.add(panel1, BorderLayout.WEST);
        panel3.add(panel2, BorderLayout.CENTER);
        
        setLayout(new BorderLayout());
        add(panel3, BorderLayout.NORTH);
        add(clock, BorderLayout.CENTER);
        
        jcbLocales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.setLocale(availableLocales[jcbLocales.getSelectedIndex()]);
            }
        });
        
        jcbTimeZones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.setTimeZone(TimeZone.getTimeZone(availableTimeZones[jcbTimeZones.getSelectedIndex()]));
            }
        });
        
    }
    
    private void setAvailableLocates() {
        for (int i = 0; i < availableLocales.length; i++) {
            jcbLocales.addItem(availableLocales[i].getDisplayName() + " " + availableLocales[i].toString());
        }
    }
    
    private void setAvailableTimeZones() {
        Arrays.sort(availableTimeZones);
        for (int i = 0; i < availableTimeZones.length; i++) {
            jcbTimeZones.addItem(availableTimeZones[i]);
        }
    }
}
