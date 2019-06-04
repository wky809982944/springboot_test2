import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class demoss {
    private JFrame frame;
    private JTextArea txt;
    private StringBuffer hint = new StringBuffer();

    public demoss(){
        if(txt==null)
            txt = new JTextArea(20,20);
    }
    public void intit() {
        //1.创建GUI
        frame = new JFrame("环境保护执法系统");
        frame.setLayout(new FlowLayout());
        frame.setSize(500, 500);
        frame.setLocation(500, 450);
        frame.setVisible(true);


        frame.add(txt);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //2.建立监听事件
            System.out.println(txt);
            MyWindowListener listener = new demoss().new MyWindowListener();
            System.out.println(txt);
        //3.向事件源注册事件监听器对象
        frame.addWindowListener(listener);
    }
    //实现windowListener监听器接口
    class MyWindowListener implements WindowListener{
        //窗口第一次激活时运行
        public void windowActivated(WindowEvent arg0){
            System.out.println("====="+txt);
            txt.setText("窗口激活");
            System.out.println("窗口激活");
        }

        public void windowDeactivated(WindowEvent arg0){
            System.out.println("====="+txt);
            txt.setText("窗口失活");
            txt.append("窗口失活");
            System.out.println("窗口激活");
        }

        public void windowIconified(WindowEvent arg0){
            txt.setText("窗口最小化");
            txt.append("窗口最小化");
            System.out.println("窗口最小化");
        }

        public void windowOpened(WindowEvent arg0){
           txt.setText("窗口打开");
        }
        public void windowClosing(WindowEvent arg0){
            JOptionPane.showInternalMessageDialog(null,"退出系统");
            System.exit(0);
        }
        public void windowClosed(WindowEvent arg0){
            txt.setText("窗口已关闭");
        }
        public void windowDeiconified(WindowEvent arg0){
            txt.setText("窗口激活");
        }
    }


}