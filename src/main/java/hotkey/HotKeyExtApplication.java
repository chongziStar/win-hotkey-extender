package hotkey;


import com.tulskiy.keymaster.common.Provider;
import hotkey.util.ClipboardUtil;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.stream.Collectors;

public class HotKeyExtApplication {

    public static void main(String[] args) {
        // 用swing的queue
        Provider provider = Provider.getCurrentProvider(true);
     // 绑定快捷键
        provider.register(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.ALT_MASK),
                x->
                { String clipboardText = ClipboardUtil.getClipboardString();
        if (clipboardText != null && clipboardText.contains("\n")) {
            ClipboardUtil.setClipboardString(
                    "(" + Arrays.stream(clipboardText.split("\\n")).map(str -> "'" + str + "'").collect(Collectors.joining(","))+")");
        }     }
                
                );

    }

}
