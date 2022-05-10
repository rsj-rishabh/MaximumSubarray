public class MarsBase {
    public static void main (String args[]) {
        switch (args[0]) {
            case "1":
                new task1().solve();
                break;

            // to test Task1
            case "1T":
                new task1().test(Integer.parseInt(args[1]));
                break;

            case "2":
                new task2().solve();
                break;

            // to test Task2
            case "2T":
                new task2().test(Integer.parseInt(args[1]));
                break;

            case "3a":
                new task3a().solve();
                break;
            
            // to test Task3a
            case "3aT":
                new task3a().test(Integer.parseInt(args[1]));
                break;

            case "3b":
                new task3b().solve();
                break;
            
            // to test Task3b
            case "3bT":
                new task3b().test(Integer.parseInt(args[1]));
                break;

            case "4":
                new task4().solve();
                break;

            // to test Task4
            case "4T":
                new task4().test(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                break;
            
            case "5":
                new task5().solve();
                break;

            // to test Task5
            case "5T":
                new task5().test(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                break;
            
            case "6":
                new task6().solve();
                break;

            // to test Task6
            case "6T":
                new task6().test(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                break;

            default:
                System.out.println("This option is not valid. Please enter one of the following: 1 2 3a 3b 4 5 6");
        }
    }
}
