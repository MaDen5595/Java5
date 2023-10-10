package Zadacha1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Window {
    static int milangoal = 0;
    static int madridgoal = 0;
    static JLabel score = new JLabel("Result: 0X0");
    static  JLabel last = new JLabel("Last Scorer: N/A");
    static JLabel win = new JLabel("Winner: DRAW");
    public static void main(String[] args) {
        JFrame frame = new JFrame("Match");
        JPanel panel = new JPanel();
        ActionListener myButtonsListener = new ButtonsListener();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        panel.setPreferredSize(new Dimension(400,175));
        JButton milan = new JButton("AC Milan");
        milan.setActionCommand("milan");
        milan.setPreferredSize(new Dimension(150, 50));
        JButton madrid = new JButton("Real Madrid");
        madrid.setPreferredSize(new Dimension(150, 50));
        madrid.setActionCommand("madrid");
        milan.addActionListener(myButtonsListener);
        madrid.addActionListener(myButtonsListener);
        score.setPreferredSize(new Dimension(150,50));
        last.setPreferredSize(new Dimension(150,50));
        win.setPreferredSize(new Dimension(150,50));
        panel.add(milan);
        panel.add(madrid);
        panel.add(score);
        panel.add(last);
        panel.add(win);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public static class ButtonsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("milan")) {
                milangoal = milangoal+1;
                score.setText("Result: "+milangoal+"X"+madridgoal);
                last.setText("Last Scorer: AC Milan");
                if(milangoal>madridgoal){
                    win.setText("Winner: AC Milan");
                }else if(milangoal==madridgoal){
                    win.setText("Winner: DRAW");
                }
            }
            else {
                madridgoal = madridgoal+1;
                score.setText("Result: "+milangoal+"X"+madridgoal);
                last.setText("Last Scorer: Real Madrid");
                if(madridgoal>milangoal){
                    win.setText("Winner: Real Madrid");
                }else if(milangoal==madridgoal){
                    win.setText("Winner: DRAW");
                }
            }
        }
    }
}
