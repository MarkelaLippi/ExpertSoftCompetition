import java.util.ArrayList;
import java.util.stream.Collectors;

public class MergeQuicksort{
    private static void merge(ArrayList<Integer> a, ArrayList<Integer> b) throws Exception {
        if (a == null || b == null)
            throw new Exception("One or two arguments are null");
        if (a.size() != b.size())
            throw new Exception("Arguments are not the same size");

        ArrayList<Integer> orderedA = (ArrayList<Integer>) a.stream()
                .sorted()
                .collect(Collectors.toList());
        if (!a.equals(orderedA))
            throw new Exception("The first argument is not ordered");

        ArrayList<Integer> orderedB = (ArrayList<Integer>) b.stream()
                .sorted()
                .collect(Collectors.toList());
        if (!b.equals(orderedB))
            throw new Exception("The second argument is not ordered");

        a.addAll(b);

        quickSort(a, 0, a.size() - 1);
    }

    private static void quickSort(ArrayList<Integer> list, int start, int end) {
        if (list.size() == 0)
            return;
        if (start >= end)
            return;

        int middle = start + (end - start) / 2;
        int supportingElement = list.get(middle);

        int i = start, j = end;
        while (i <= j) {
            while (list.get(i) < supportingElement) {
                i++;
            }
            while (list.get(j) > supportingElement) {
                j--;
            }
            if (i <= j) {//меняем местами
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
                j--;
            }
        }
        if (start < j)
            quickSort(list, start, j);
        if (end > i)
            quickSort(list, i, end);
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
