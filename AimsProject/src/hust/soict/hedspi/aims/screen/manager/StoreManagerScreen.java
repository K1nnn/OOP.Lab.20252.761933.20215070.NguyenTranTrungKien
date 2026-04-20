package hust.soict.hedspi.aims.screen.manager;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.manager.AddDigitalVideoDiscToStoreScreen;

import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private Store store;
    private int switchPanel = 0;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewStore = new JMenuItem("View Store");
        menu.add(viewStore);
        viewStore.addActionListener(new MenuListener());

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        smUpdateStore.add(addBook);
        addBook.addActionListener(new MenuListener());
        JMenuItem addCD = new JMenuItem("Add CD");
        smUpdateStore.add(addCD);
        addCD.addActionListener(new MenuListener());
        JMenuItem addDVD = new JMenuItem("Add DVD");
        smUpdateStore.add(addDVD);
        addDVD.addActionListener(new MenuListener());

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        menuBar.add(smUpdateStore);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        if (switchPanel == 0) {
            center.repaint();

            center.setLayout(new GridLayout(3, 3, 2, 2));

            ArrayList<Media> mediaInStore = store.getItemsInStore();
            for (Media media : mediaInStore) {
                MediaStore cell = new MediaStore(media);
                center.add(cell);
            }
        }
        if (switchPanel == 1) {
            center.repaint();
            center.setLayout(new GridLayout(1, 1));
            center.add(new AddBookToStoreScreen(store));
        }
        if (switchPanel == 2) {
            center.repaint();
            center.setLayout(new GridLayout(1, 1));
            center.add(new AddCompactDiscToStoreScreen(store));
        }
        if (switchPanel == 3) {
            center.repaint();
            center.setLayout(new GridLayout(1, 1));
            center.add(new AddDigitalVideoDiscToStoreScreen(store));
        }
        return center;

    }

    private class MenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            String button = evt.getActionCommand();
            if (button.equals("View Store"))
                switchPanel = 0;
            if (button.equals("Add Book"))
                switchPanel = 1;

            if (button.equals("Add CD"))
                switchPanel = 2;

            if (button.equals("Add DVD"))
                switchPanel = 3;
            getContentPane().removeAll();
            getContentPane().add(createNorth(), BorderLayout.NORTH);
            getContentPane().add(createCenter(), BorderLayout.CENTER);
            getContentPane().repaint();
            getContentPane().revalidate();
        }
    }
}