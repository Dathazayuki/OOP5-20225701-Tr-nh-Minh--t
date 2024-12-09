package hust.soict.dsai.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

class ButtonListener implements ActionListener {
	private JTextField tfDisplay;  
    public ButtonListener(JTextField tfDisplay) {
        this.tfDisplay = tfDisplay;
    } 
    
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
            tfDisplay.setText(tfDisplay.getText() + button);
        } else if (button.equals("DEL")) {
        	 String currentText = tfDisplay.getText();
             if (currentText.length() > 0) {
                 tfDisplay.setText(currentText.substring(0, currentText.length() - 1)); // Xóa ký tự cuối cùng
             }
             } else {
            	 tfDisplay.setText("");
        }
    }

}
