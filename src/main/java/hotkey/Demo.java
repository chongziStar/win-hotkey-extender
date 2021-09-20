package hotkey;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

public class Demo {
    /**
     *
     */
    /**
     * 一,JIntellitype调用getInstance()方法后有两个重构方法registerHotKey()注册热键,分别为:
     * 1.registerHotKey(int identifier, int modifier, int keycode)
     * 2.registerHotKey(int identifier, String modifierAndKeyCode)
     * 其中:
     * identifier为自定义的热键的标识
     * modifier为键shift/win/ctrl/alt一个或多个的值(整型,JIntellitype静态成员已定义),取值见JIntellitype.swingToIntelliType()方法，如果不要组合键，参数为0
     * keycode为键盘码,可由JIntellitype.getKey2KeycodeMapping()方法中查看
     * modifierAndKeyCode为键shift/win/ctrl/alt一个或多个的字符串值(字符串类型,大写)
     *
     * 二,JIntellitype调用getInstance()方法后调用[热键]addHotKeyListener()或者[媒体类型]addIntellitypeListener()监听,方法参数为类HotkeyListener或IntellitypeListener的对象,可通过匿名内部类重写处理方法
     * 三,释放热键参见demo的HotKeyThread线程类中实现
     * ————————————————
     * 版权声明：本文为CSDN博主「swiftlzk」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/qq_30359369/article/details/104713688
     */
    /**
     * https://blog.csdn.net/qq_40388798/article/details/104006534
     * @param args
     */
    public static void main1(String[] args) {
        /*
           注册热键，第一个参数为序号，在添加监听时会用到
                   第二个参数为是否时组合键，为0时即非组合键
                   第三个参数为需要注册的按键，可以使用按键code或者直接char类型大写按键代替
         */
        // JIntellitype.getInstance().registerHotKey(1, 0, 27);
        // JIntellitype.getInstance().registerHotKey(2, 0, 'K');
        //JIntellitype.getInstance().registerHotKey(3, JIntellitype.MOD_ALT, 'R');
        /*
          注册监听，case选项的值即为注册热键时热键的序号
         */
        HotkeyListener hotkeyListener = new HotkeyListener() {
            public void onHotKey(int code) {
                switch (code) {
                    case 1:
                        System.out.println("esc");
                        break;
                    case 2:
                        System.out.println("k");
                        break;
                    case 3:
                        System.out.println("r");
                        break;
                }
            }
        };
        //添加监听
        JIntellitype.getInstance().addHotKeyListener(hotkeyListener);
        //注销按键并不会注销监听，必须要手动注销监听
        //注销监听
        JIntellitype.getInstance().removeHotKeyListener(hotkeyListener);
        //注销按键
        JIntellitype.getInstance().unregisterHotKey(1);


    }
}
