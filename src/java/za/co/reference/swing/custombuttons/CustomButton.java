package za.co.reference.swing.custombuttons;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;

public class CustomButton extends JButton implements FocusListener{

	public CustomButton(){
		addFocusListener(this);
		setBorder(BorderFactory.createEmptyBorder());
		setContentAreaFilled(false);
	}

	@Override
	public void setIcon(Icon defaultIcon){
		setPreferredSize(new Dimension(defaultIcon.getIconWidth(), defaultIcon.getIconHeight()));
		super.setIcon(defaultIcon);
	}

	@Override
	public void setPressedIcon(Icon pressedIcon){
		super.setPressedIcon(pressedIcon);
	}

	@Override
	public void setRolloverIcon(Icon rolloverIcon){
		super.setRolloverIcon(rolloverIcon);
	}

	@Override
	public void setDisabledIcon(Icon disabledIcon){
		super.setDisabledIcon(disabledIcon);
	}

	@Override
	public synchronized void focusGained(FocusEvent e){
		normalIcon = getIcon();
		setIcon(getRolloverIcon());
	}

	@Override
	public synchronized void focusLost(FocusEvent e){
		setIcon(normalIcon);
		normalIcon = null;
	}

	private Icon normalIcon;

}