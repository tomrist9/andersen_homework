import org.util.CustomArrayList;
import org.util.CustomHashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing CustomArrayList:");
        testCustomArrayList();

        System.out.println("\nTesting CustomHashSet:");
        testCustomHashSet();
    }

    private static void testCustomArrayList() {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        customArrayList.put("Apple");
        customArrayList.put("Banana");
        customArrayList.put("Grapes");
        customArrayList.put("Peach");


        System.out.println("Element at index 2: " + customArrayList.get(2));


        customArrayList.delete(2);
        System.out.println("After deleting index 2: " + customArrayList);


        for (int i = 0; i < 15; i++) {
            customArrayList.put("Element " + i);
        }
        System.out.println("CustomArrayList after adding 15 more elements: " + customArrayList);
        System.out.println("Size of CustomArrayList: " + customArrayList.getSize());
    }

    private static void testCustomHashSet() {

        CustomHashSet<String> customHashSet = new CustomHashSet<>();
        customHashSet.put("Apple");
        customHashSet.put("Banana");
        customHashSet.put("Grapes");
        customHashSet.put("Apple");


        System.out.println("Contains 'Apple': " + customHashSet.contains("Apple"));
        System.out.println("Contains 'Orange': " + customHashSet.contains("Orange"));


        customHashSet.delete("Banana");
        System.out.println("After deleting 'Banana':");
        customHashSet.iterate();


        for (int i = 0; i < 20; i++) {
            customHashSet.put("Element " + i);
        }
        System.out.println("CustomHashSet size after adding 20 more elements: " + customHashSet.size());
        System.out.println("Elements in CustomHashSet:");
        customHashSet.iterate();
    }
}

