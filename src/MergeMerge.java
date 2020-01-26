import java.util.ArrayList;

public class MergeMerge {
    private static void merge(ArrayList<Integer> a, ArrayList<Integer> b) throws Exception {
        ArrayList<Integer> mergedList = new ArrayList<>(a.size() + b.size());
        int indexA = 0;
        int indexB = 0;
        while (indexA < a.size() && indexB < b.size()) {
            mergedList.add(a.get(indexA) < b.get(indexB) ? a.get(indexA++) : b.get(indexB++));
        }

        ArrayList<Integer> lastPart;
        int lastIndex;
        if (indexA < a.size()) {
            lastPart = a;
            lastIndex = indexA;
        } else {
            lastPart = b;
            lastIndex = indexB;
        }

        for (int i = lastIndex; i < lastPart.size(); i++) {
            mergedList.add(lastPart.get(i));
        }

        a.clear();
        a.addAll(mergedList);
    }


    public static void main(String[] args) {
        ArrayList<Integer> sourceA = new ArrayList<>();
        sourceA.add(1);
        sourceA.add(3);
        sourceA.add(5);

        ArrayList<Integer> sourceB = new ArrayList<>();
        sourceB.add(2);
        sourceB.add(6);
        sourceB.add(8);

        try {
            merge(sourceA, sourceB);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
