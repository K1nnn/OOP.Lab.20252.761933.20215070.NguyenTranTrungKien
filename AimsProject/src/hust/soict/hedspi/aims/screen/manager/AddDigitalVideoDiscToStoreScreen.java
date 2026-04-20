package hust.soict.hedspi.aims.screen.manager;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.exception.ExistedMediaException;
import hust.soict.hedspi.aims.exception.LimitExceedMediaException;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField directorInput;
    private JTextField lengthInput;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        this.setLayout(new GridLayout(6, 2));
        JLabel director = new JLabel("Enter Director: ");
        directorInput = new JTextField(20);
        this.add(director);
        this.add(directorInput);

        JLabel length = new JLabel("Enter Length: ");
        lengthInput = new JTextField(20);
        this.add(length);
        this.add(lengthInput);

    }

    @Override
    protected void performAddAction() throws LimitExceedMediaException, ExistedMediaException {
        String title = getTitleInput().getText();
        String category = getCategoryInput().getText();
        float cost = Float.parseFloat(getCostInput().getText());
        String director = directorInput.getText();
        int length = Integer.parseInt(lengthInput.getText());

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
        getStore().addMedia(dvd);
        getTitleInput().setText("");
        getCategoryInput().setText("");
        getCostInput().setText("");
        directorInput.setText("");
        lengthInput.setText("");
    }
}
