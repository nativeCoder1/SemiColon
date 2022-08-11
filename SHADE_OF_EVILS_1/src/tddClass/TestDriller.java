package tddClass;

public class TestDriller {
    public int priceRange(int noOfCopies) {
        int price = 0;
        if (noOfCopies >= 1 && noOfCopies <= 4)
            price = noOfCopies * 2000;
        else if (noOfCopies >= 5 && noOfCopies <= 9)
            price = noOfCopies * 1800;
        else if (noOfCopies >= 10 && noOfCopies <= 29)
            price = noOfCopies * 1600;
        else if (noOfCopies >= 30 && noOfCopies <= 49)
            price = noOfCopies * 1500;
        else if (noOfCopies >= 50 && noOfCopies <= 99)
            price = noOfCopies * 1300;
        else if (noOfCopies >= 100 && noOfCopies <= 199)
            price = noOfCopies * 1200;
        else if (noOfCopies >= 200 && noOfCopies <= 499)
            price = noOfCopies * 1100;
        else
            price = noOfCopies * 1000;
        return price;
    }
}
