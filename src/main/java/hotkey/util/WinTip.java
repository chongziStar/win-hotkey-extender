package hotkey.util;

import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class WinTip {
    JFrame frame;
    int fontSize=36;
    int stayTime=500;
    public WinTip (String msg) {
       new WinTip(36,msg);
    }
    /**
     * swing弹窗提示,
     *
     * @param fontSize
     * @param msg
     * @return
     */
    public WinTip (int fontSize, String msg) {
       // 新建窗体
         frame = new JFrame("");
        // 设置圆角
        Window win = new Window(frame);
        // JFrame.setDefaultLookAndFeelDecorated(true)
        // 设置为swing默认窗体
        AWTUtilities.setWindowShape(win,
                new RoundRectangle2D.Double(0.0D, 0.0D, win.getWidth(), win.getHeight(), 26.0D, 26.0D));
        // 黑色背景，透明度为50的color；透明的取值范围0~255
        Color color = new Color(0, 0, 0, 50);
        // 设置窗口置顶
        frame.setAlwaysOnTop(true);
        // 设置网格包布局
        frame.setLayout(new GridBagLayout());
        // 设置无边框
        frame.setUndecorated(true);
        // 设置背景色
        frame.setBackground(color);

        JLabel label = new JLabel(msg);
        label.setForeground(Color.white);
        label.setFont(new Font("黑体", 0, fontSize));
        frame.setSize(msg.length() * fontSize, fontSize + 50);
        // 长度为字符大小*字符数量，宽度为字体大小+50像素
        // 添加到窗体
        frame.add(label);

        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    public void alert(){
        frame.setVisible(true);
        try {
            Thread.sleep(stayTime * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame.setVisible(false);
    }

    public static void main(String[] args) {
        new WinTip("!!!!!!!!").alert();
    }
}
