
public class Aims {
    public static void main(String[] args) {
        // create a new cart
        Cart anOrder = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // print all the items in the cart
        anOrder.printDetail();
        // print the total cost of the items in the cart
        System.out.printf("%-3s%-20s%-20.2f\n\n", "", "Total Cost", anOrder.totalCost());

        // try to remove an item
        anOrder.removeDigitalVideoDisc(dvd2);
        // print all the items in the cart
        anOrder.printDetail();
        // print the total cost of the items in the cart
        System.out.printf("%-3s%-20s%-20.2f\n\n", "", "Total Cost", anOrder.totalCost());

        // try to add items
        DigitalVideoDisc[] dvdList = { dvd1, dvd2, dvd3 };
        anOrder.addDigitalVideoDisc(dvdList);

        // use arbitrary number of arguments
        // anOrder.addDigitalVideoDisc(dvd1,dvd2,dvd3);

        // print all the items in the cart
        anOrder.printDetail();
        // print the total cost of the items in the cart
        System.out.printf("%-3s%-20s%-20.2f\n\n", "", "Total Cost", anOrder.totalCost());

        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());

    }

    public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
        DigitalVideoDisc tmp = new DigitalVideoDisc(o1.getTitle(), o1.getCategory(), o1.getDirector(), o1.getLength(),
                o1.getCost());

        o1.setTitle(o2.getTitle());
        o2.setTitle(tmp.getTitle());

        o1.setCategory(o2.getCategory());
        o2.setCategory(tmp.getCategory());

        o1.setCost(o2.getCost());
        o2.setCost(tmp.getCost());

        o1.setDirector(o2.getDirector());
        o2.setDirector(tmp.getDirector());

        o1.setLength(o2.getLength());
        o2.setLength(tmp.getLength());
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
