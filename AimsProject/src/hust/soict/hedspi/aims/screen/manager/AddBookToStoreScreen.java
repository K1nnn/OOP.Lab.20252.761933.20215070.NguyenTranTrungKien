package hust.soict.hedspi.aims.screen.manager;

import java.awt.GridLayout;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.exception.ExistedMediaException;
import hust.soict.hedspi.aims.exception.LimitExceedMediaException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField authorsInput;

    public AddBookToStoreScreen(Store store) {
        super(store);
        this.setLayout(new GridLayout(5, 2));
        JLabel authors = new JLabel("Enter Authors (split by ','): ");
        authorsInput = new JTextField(30);
        this.add(authors);
        this.add(authorsInput);
    }

    @Override
    protected void performAddAction() throws LimitExceedMediaException, ExistedMediaException {
        String title = getTitleInput().getText();
        String category = getCategoryInput().getText();
        float cost = Float.parseFloat(getCostInput().getText());
        List<String> authors = new ArrayList<>(Arrays.asList(authorsInput.getText().split(",")));

        Book book = new Book(title, category, cost, authors);
        getStore().addMedia(book);
        getTitleInput().setText("");
        getCategoryInput().setText("");
        getCostInput().setText("");
        authorsInput.setText("");
    }
}
