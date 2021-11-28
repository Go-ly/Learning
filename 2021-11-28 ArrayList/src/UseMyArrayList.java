public class UseMyArrayList {
    private static void assertTrue(boolean condition) {
        if (!condition) {
            throw new RuntimeException();
        }
    }
    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();
        arrayList.check();
        assertTrue(arrayList.getSize() == 0);

        // 测试用例
        arrayList.add(0, 100);
        arrayList.check();
        assertTrue(arrayList.getSize() == 1);
        assertTrue(arrayList.get(0) == 100);

        arrayList.add(0, 200);
        arrayList.check();
        assertTrue(arrayList.getSize() == 2);
        assertTrue(arrayList.get(0) == 200);
        assertTrue(arrayList.get(1) == 100);

        arrayList.add(1, 300);
        arrayList.check();
        assertTrue(arrayList.getSize() == 3);
        assertTrue(arrayList.get(0) == 200);
        assertTrue(arrayList.get(1) == 300);
        assertTrue(arrayList.get(2) == 100);

        arrayList.add(3, 400);
        arrayList.check();
        assertTrue(arrayList.getSize() == 4);
        assertTrue(arrayList.get(0) == 200);
        assertTrue(arrayList.get(1) == 300);
        assertTrue(arrayList.get(2) == 100);
        assertTrue(arrayList.get(3) == 400);

        arrayList.delete(0);
        arrayList.check();
        assertTrue(arrayList.getSize() == 3);
        assertTrue(arrayList.get(0) == 300);
        assertTrue(arrayList.get(1) == 100);
        assertTrue(arrayList.get(2) == 400);

        arrayList.delete(1);
        arrayList.check();
        assertTrue(arrayList.getSize() == 2);
        assertTrue(arrayList.get(0) == 300);
        assertTrue(arrayList.get(1) == 400);

        int r = arrayList.find(400);
        arrayList.check();
        assertTrue(arrayList.getSize() == 2);
        assertTrue(arrayList.get(0) == 300);
        assertTrue(arrayList.get(1) == 400);
        assertTrue(r == 1);
//        System.out.println(r);

        arrayList.change(0, 20);
        arrayList.check();
        assertTrue(arrayList.getSize() == 2);
        assertTrue(arrayList.get(0) == 20);
        assertTrue(arrayList.get(1) == 400);

        arrayList.change(1, 30);
        arrayList.check();
        assertTrue(arrayList.getSize() == 2);
        assertTrue(arrayList.get(0) == 20);
        assertTrue(arrayList.get(1) == 30);
    }
}
