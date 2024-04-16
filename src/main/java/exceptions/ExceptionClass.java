package exceptions;

public class ExceptionClass {

    public static void main(String[] args) {
        //checkedExceptionSecond();
        uncheckedExceptionIndexOfBoundsExc(1);
        System.out.println("after exception");
        methodWithMyException(null);
        System.out.println("after  my exception");
    }

    public static void  methodWithMyException(String str){
        if (str == null) try {
            throw new MyException("it is my exception");
        } catch (MyException e) {
            e.printStackTrace();
        }

        else System.out.println(str);
    }
    public static void uncheckedExceptionIndexOfBoundsExc(int i) {
        String[] array = {"one", "two", "three"};
        String str = null;
        try {
            str = array[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            str = array[array.length -1];
        }
        System.out.println("str -->"+ str);
    }

    public static void checkedExceptionSecond() {
        try {
            checkedException();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }

    public static void checkedException() throws InterruptedException {
        Thread.sleep(3000);
    }
}
