import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Main implements NativeKeyListener {
    StringBuilder keys = new StringBuilder();
        public void nativeKeyPressed(NativeKeyEvent e) {
            /*System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

            if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
                try {
                    GlobalScreen.unregisterNativeHook();
                } catch (NativeHookException e1) {
                    e1.printStackTrace();
                }hola como estas
            }*/
        }

        public void nativeKeyReleased(NativeKeyEvent e) {
            //System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
            //String key = NativeKeyEvent.getKeyText(e.getKeyCode());
            keys.append(NativeKeyEvent.getKeyText(e.getKeyCode()) + "\n");
            System.out.println(keys);
        }

        public void nativeKeyTyped(NativeKeyEvent e) {
            //System.out.println("Key Typed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        }

        public static void main(String[] args) {
            try {
                GlobalScreen.registerNativeHook();
            }
            catch (NativeHookException ex) {
                //System.err.println("There was a problem registering the native hook.");
                //System.err.println(ex.getMessage());

                System.exit(1);
            }
            GlobalScreen.addNativeKeyListener(new Main());
        }
}