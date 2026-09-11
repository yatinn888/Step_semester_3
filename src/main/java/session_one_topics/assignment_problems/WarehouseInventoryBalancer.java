package session_one_topics.assignment_problems;

public class WarehouseInventoryBalancer {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;
        int highestQty = -1;
        String highestLocation = "";

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highestQty) {
                highestQty = sectionA[i];
                highestLocation = "Section A, Item " + (i + 1);
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highestQty) {
                highestQty = sectionB[i];
                highestLocation = "Section B, Item " + (i + 1);
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s)%n",
                totalA, totalB, status, highestQty, highestLocation);
    }

    public static void main(String[] args) {
        int[] secA = {20, 15, 30};
        int[] secB = {25, 10, 30};

        analyzeInventory(secA, secB);
    }
}