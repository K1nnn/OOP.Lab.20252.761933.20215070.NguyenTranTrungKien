package hust.soict.hedspi.aims.screen.manager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.exception.ExistedMediaException;
import hust.soict.hedspi.aims.exception.LimitExceedMediaException;
import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JPanel {
    private Store store;
    private JTextField titleInput;
    private JTextField categoryInput;
    private JTextField costInput;
    private JButton addButton;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        this.setLayout(new GridLayout(4, 2));
        JLabel header = new JLabel("STORE");
        this.add(header);
        addButton = new JButton("Add to Store");
        addButton.addActionListener(new AddButtonListener());
        this.add(addButton);

        JLabel title = new JLabel("Enter Title: ");
        titleInput = new JTextField(20);
        this.add(title);
        this.add(titleInput);

        JLabel category = new JLabel("Enter Category: ");
        categoryInput = new JTextField(20);
        this.add(category);
        this.add(categoryInput);

        JLabel cost = new JLabel("Enter Cost: ");
        costInput = new JTextField(20);
        this.add(cost);
        this.add(costInput);

    }

    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getTitleInput() {
        return titleInput;
    }

    public JTextField getCategoryInput() {
        return categoryInput;
    }

    public JTextField getCostInput() {
        return costInput;
    }

    protected Store getStore() {
        return store;
    }

    // Abstract method to be implemented by subclasses
    protected abstract void performAddAction() throws ExistedMediaException, LimitExceedMediaException;

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            try {
				performAddAction();
			} catch (ExistedMediaException | LimitExceedMediaException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // Delegate the action to the subclass
        }
    }
}
