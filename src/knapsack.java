import java.util.Arrays;

class Knapsack {
    public static void main(String[] args) {
        int sack = 8;
        Item[] items = new Item[5];
        items[0] = new Item(5, 3);
        items[1] = new Item(5, 2);
        items[2] = new Item(9, 3);
        items[3] = new Item(5, 1);
        items[4] = new Item(10, 1);

//        // Sorting in decreasing order of profit/weight
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                if (items[j].pbyw < items[j + 1].pbyw) {
//                    Item temp = items[j];
//                    items[j] = items[j + 1];
//                    items[j + 1] = temp;
//                }
//            }
//        }
        Arrays.sort(items,(a,b)->Double.compare(b.pbyw,a.pbyw));
        int currwt = 0;
        double maxprofit = 0.00;

        for (int i = 0; i < 5; i++) {
            if (currwt + items[i].weight <= sack) { // If full item fits
                currwt += items[i].weight;
                maxprofit += items[i].profit;
                items[i].fraction=1;
            } else { // If only a fraction fits
                int remaining = sack - currwt;
                maxprofit += (double) remaining / items[i].weight * items[i].profit;
                items[i].fraction=(double)remaining/items[i].weight;
                break; // Knapsack is full
            }

        }
        for (Item ditto:items){
            ditto.display();
        }

        System.out.println("Maximum Profit: " + maxprofit);
    }
}

class Item {
    int profit;
    int weight;
    double pbyw;
    double fraction;

    Item(int p, int w) {
        this.profit = p;
        this.weight = w;
        this.pbyw = (double) p / w;
    }
    void display(){
        System.out.print("Profit "+profit+" ");
        System.out.print("Weight "+weight+" ");
        System.out.print("P/w "+pbyw+" ");
        System.out.println("fraction "+fraction);

    }
}
