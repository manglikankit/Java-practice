import java.util.*;
import java.util.function.Predicate;

public class Main {
    public  void main() {

    }
    public void main(int a){

    }
    static public void main(String[] args) {

        Operation op=new Operation();

        System.out.println("before change "+op.data);
        op.change(500);
        System.out.println("after change "+op.data);

        List<Integer> numbers = List.of(23, 12, 34, 45, 36, 48);
        Predicate<? super Integer> evenPredicate = num -> num % 2 == 0;
        Predicate<? super Integer> oddPredicate = num -> num % 2 == 1;
        numbers.stream()
                .filter(evenPredicate)
                .forEach(e -> System.out.println(e));


        System.out.println(List.of(23, 12, 34, 53).stream().max((n1, n2) -> Integer.compare(n1, n2)).orElse(0));

        MyCustomList<String> list3 = new MyCustomList<>();
        list3.addElement("Element-1");
        list3.addElement("Element-2");
        System.out.println(list3);
        MyCustomList<Integer> list2 = new MyCustomList<>();
        list2.addElement(Integer.valueOf(5));
        list2.addElement(Integer.valueOf(9));
        System.out.println(list2);

        int[] marks = {75, 60, 56};
        Arrays.stream(marks).sorted();


        System.out.println(marks.toString());
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);

//        integer += 5;
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("a", 100);
        System.out.println(hashMap.get("a"));
//        System.out.println(integer);

        String text = doSomething("Hello");
        Integer value = doSomething(Integer.valueOf(7));
        ArrayList<String> list4 = doSomething(new ArrayList<String>(List.of("A", "B", "C")));
        duplicate(list4);
        System.out.println(list4);
//        LinkedList<Integer> list11 = doSomething(new LinkedList<String>(List.of(1, 2, 3)));
//        duplicate(list11);
//        System.out.println(list11);
        List<Number> numberList = new ArrayList<>();
        addAFewNumbers(numberList);
        System.out.println("Super => "+ numberList);
    }

    static void addAFewNumbers(List<? super Number> numbers) {
        numbers.add(1);
        numbers.add(1l);
        numbers.add(1.0);
        numbers.add(1.0);
    }

    static <X> X doSomething(X value) {
        return value;
    }

    static <X extends List> void duplicate(X list) {
        list.add(list);
    }
}

 class MyCustomList<T> {
    ArrayList<T> list = new ArrayList<>();
    public void addElement(T element) {
        list.add(element);
    }
    public void removeElement(T element) {
        list.remove(element);
    }
    public String toString() {
        return list.toString();
    }
}

class Operation {
    int data = 50;

   protected void change(int data) {
        data = data + 100;//changes will be in the local variable only
    }
}
class Subclass extends Operation {
    public Subclass() {

        super();
        
    }

    @Override
    public void change(int data){

    }
}