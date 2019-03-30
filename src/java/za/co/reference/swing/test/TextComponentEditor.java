package za.co.reference.swing.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

public class TextComponentEditor{

    public void addTextComponent(JTextComponent component){
System.out.println("TextComponentEditor.addTextComponent()");
        component.addMouseListener(mediator);
    }

    public void removeTextComponent(JTextComponent component){
System.out.println("TextComponentEditor.removeTextComponent()");
        component.removeMouseListener(mediator);
    }

    private JPopupMenu createPopupMenu(){
System.out.println("TextComponentEditor.createPopupMenu()");
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.setLightWeightPopupEnabled(true);
        popupMenu.add(createCutMenuItem());
        popupMenu.add(createCopyMenuItem());
        popupMenu.add(createPasteMenuItem());
        return popupMenu;
    }

    private JMenuItem createCutMenuItem(){
System.out.println("TextComponentEditor.createCutMenuItem()");
        cutMenuItem = new MenuItem("Cut");
        cutMenuItem.addActionListener(mediator);
        return cutMenuItem;
    }

    private JMenuItem createCopyMenuItem(){
System.out.println("TextComponentEditor.createCopyMenuItem()");
        copyMenuItem = new MenuItem("Copy");
        copyMenuItem.addActionListener(mediator);
        return copyMenuItem;
    }

    private JMenuItem createPasteMenuItem(){
System.out.println("TextComponentEditor.createPasteMenuItem()");
        pasteMenuItem = new MenuItem("Paste");
        pasteMenuItem.addActionListener(mediator);
        return pasteMenuItem;
    }

    private class Mediator extends MouseAdapter implements ActionListener{

        @Override
        public void mousePressed(MouseEvent e){
System.out.println("TextComponentEditor.Mediator.mousePressed()");
            if (!SwingUtilities.isRightMouseButton(e)){
                return;
            }
            if (!(e.getSource() instanceof JTextComponent)){
                return;
            }
            currentTextComponent = (JTextComponent) e.getSource();
            if (currentTextComponent.getSelectionStart() == currentTextComponent.getSelectionEnd()){
                cutMenuItem.setEnabled(false);
                copyMenuItem.setEnabled(false);
            }
            else{
                if (currentTextComponent.isEditable()){
                    cutMenuItem.setEnabled(true);
                }
                else{
                    cutMenuItem.setEnabled(false);
                }
                copyMenuItem.setEnabled(true);
            }
            if (currentTextComponent.isEditable()){
                pasteMenuItem.setEnabled(true);
            }
            else{
                pasteMenuItem.setEnabled(false);
            }
            if (popupMenu.isEnabled()){
                popupMenu.show(currentTextComponent, e.getX(), e.getY());
            }
        }

        @Override
		public void actionPerformed(ActionEvent e){
System.out.println("TextComponentEditor.Mediator.actionPerformed()");
            if (e.getSource() == cutMenuItem){
                currentTextComponent.cut();
            }
            else if (e.getSource() == copyMenuItem){
                currentTextComponent.copy();
            }
            else if (e.getSource() == pasteMenuItem){
                currentTextComponent.paste();
            }
        }

    }

    private Mediator mediator = new Mediator();
    private JPopupMenu popupMenu = createPopupMenu();
    private JMenuItem cutMenuItem;
    private JMenuItem copyMenuItem;
    private JMenuItem pasteMenuItem;
    private JTextComponent currentTextComponent;
    //private List<JTextComponent> textComponents = new LinkedList<JTextComponent>();

}