package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.exception.ExistedMediaException;
import hust.soict.hedspi.aims.exception.LimitExceedMediaException;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField artistInput;
    private JTextArea tracksInput;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        this.setLayout(new GridLayout(6, 2));
        JLabel artistLabel = new JLabel("Enter Artist: ");
        artistInput = new JTextField(20);
        this.add(artistLabel);
        this.add(artistInput);

        JLabel tracksLabel = new JLabel("Enter Tracks (title,length separated by comma): ");
        tracksInput = new JTextArea(4, 20);
        JScrollPane scrollPane = new JScrollPane(tracksInput);
        this.add(tracksLabel);
        this.add(scrollPane);

        setSize(400, 300); // Adjusted size to accommodate new fields
    }

    @Override
    protected void performAddAction() throws ExistedMediaException, LimitExceedMediaException {
        String title = getTitleInput().getText();
        String category = getCategoryInput().getText();
        float cost = Float.parseFloat(getCostInput().getText());
        String artist = artistInput.getText();
        String[] trackInfo = tracksInput.getText().split(","); // Split tracks by comma

        CompactDisc cd = new CompactDisc(title, category, cost, artist);
        for (int i = 0; i < trackInfo.length; i += 2) {
            String trackTitle = trackInfo[i].trim();
            int trackLength = Integer.parseInt(trackInfo[i + 1].trim());
            cd.addTrack(new Track(trackTitle, trackLength)); // Add track to CD
        }
        getStore().addMedia(cd);
        getTitleInput().setText("");
        getCategoryInput().setText("");
        getCostInput().setText("");
        artistInput.setText("");
        tracksInput.setText("");
    }
}