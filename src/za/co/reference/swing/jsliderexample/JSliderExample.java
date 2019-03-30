package za.co.reference.swing.jsliderexample;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class JSliderExample extends WindowDecorator implements ChangeListener{
	
	public JSliderExample(Window decoratedWindow){
		super(decoratedWindow);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JPanel sliderPanel = new JPanel();
		JSlider slider = new JSlider(JSlider.HORIZONTAL, FPS_MIN, FPS_MAX, FPS_INIT);
		slider.addChangeListener(this);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        Font font = new Font("Serif", Font.ITALIC, 15);
        slider.setFont(font);
        sliderPanel.add(slider);
		
		JPanel labelPanel = new JPanel();
		label = new JLabel("15");
		labelPanel.add(label);
		
		panel.add(sliderPanel);
		panel.add(labelPanel);
		addPanel(panel);
	}

	@Override
	public void stateChanged(ChangeEvent e){
		JSlider source = (JSlider)e.getSource();
		if (!source.getValueIsAdjusting()) {
            int fps = (int)source.getValue();
            label.setText(Integer.toString(fps));
		}
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}
	
	private JLabel label;
	private static final int FPS_MIN = 0;
	private static final int FPS_MAX = 30;
	private static final int FPS_INIT = 15;

}
