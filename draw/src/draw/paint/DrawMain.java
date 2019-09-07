package draw.paint;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class DrawMain extends JPanel {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DrawMain Draw = new DrawMain();//�½������ʼ��
        Draw.InitUI();
    }
    public void InitUI() {//��������
        JFrame jf = new JFrame();//������Ļ��window�Ķ����ܹ���󻯡���С�����رա�
        jf.setSize(1000, 780);
        jf.setTitle("�򵥻���");
        jf.setDefaultCloseOperation(3);//Ĭ�Ϲر�ʱ��
        jf.setLocationRelativeTo(null);
        jf.setLayout(new BorderLayout());
        // ʵ�����¼�������
        DrawListener dl = new DrawListener(this);
        // ʵ���м����
        this.setBackground(Color.WHITE);//���屳������
        jf.add(this, BorderLayout.CENTER);///���岼��
        // ʵ����״���
        JPanel ShapePanel = new JPanel();
        ShapePanel.setBackground(Color.black);
        ShapePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        ShapePanel.setBackground(Color.gray);
        ;
        String[] Shape = { "ֱ��", "����", "Բ", "��ǹ", "��Ƥ��", "����", "��Բ", "Բ�Ǿ���",
                "����", "�����", "ͼ��", "������", "����Բ", };
        for (int i = 0; i < Shape.length; i++) {
            JButton button = new JButton(Shape[i]);
            button.setBackground(Color.WHITE);
            button.addActionListener(dl); // ����¼���������
            ShapePanel.add(button);
        }
        jf.add(ShapePanel, BorderLayout.NORTH);
        // ʵ����ɫ���
        JPanel ColorPanel = new JPanel();
        ColorPanel.setBackground(Color.black);
        ColorPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        ColorPanel.setBackground(Color.gray);
        ;
        Color[] color = { Color.BLACK, Color.blue, Color.white, Color.gray,
                Color.red, Color.CYAN, Color.green, Color.darkGray, Color.pink };
        for (int i = 0; i < color.length; i++) {
            JButton button = new JButton();//��ʼ��
            button.addActionListener(dl); // ����¼���������
            button.setPreferredSize(new Dimension(30, 30));
            button.setBackground(color[i]);
            ColorPanel.add(button);
        }
        jf.add(ColorPanel, BorderLayout.SOUTH);//��ɫ�������
        jf.setVisible(true);
        this.addMouseListener(dl);
        this.addMouseMotionListener(dl);
    }
}
