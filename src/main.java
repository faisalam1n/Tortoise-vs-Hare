import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class RaceTesting {

    static int harePos = 1;
    static int turtlePos = 1;

    enum Status {
        FAST_PLOD,
        SLIP,
        SLOW_PLOD,
        SLEEP,
        BIG_HOP,
        BIG_SLIP,
        SMALL_HOP,
        SMALL_SLIP;
    }

    static Status hareStatus, turtleStatus;

    public static void turtle() {

            SecureRandom random = new SecureRandom();

            int randomValue = 1 + random.nextInt(10);

            if (randomValue >= 1 && randomValue <= 5) {
                turtlePos = turtlePos + 3;
                turtleStatus = Status.FAST_PLOD;
                System.out.println(turtleStatus);
            }
            else if (randomValue == 6 || randomValue == 7)
            {
                if ( (turtlePos - 6) < 1) {
                    turtlePos = 1;
                    turtleStatus = Status.SLIP;
                    System.out.println(turtleStatus);
                }
                else {
                    turtlePos = turtlePos - 6;
                    turtleStatus = Status.SLIP;
                    System.out.println(turtleStatus);
                }
            }

            else if (randomValue >= 8 && randomValue <= 10) {
                turtlePos = turtlePos + 1;
                turtleStatus = Status.SLOW_PLOD;
                System.out.println(turtleStatus);
            }
            
     }

    public static void hare() {

           SecureRandom random = new SecureRandom();

            int randomValue = 1 + random.nextInt(10);

            if (randomValue == 1 || randomValue == 2) {
                harePos = harePos + 0;
                hareStatus = Status.SLEEP;
                System.out.println(hareStatus);
            }
            else if (randomValue == 3 || randomValue == 4) {
                harePos = harePos + 9;
                hareStatus = Status.BIG_HOP;
                System.out.println(hareStatus);
            }
            else if (randomValue == 5) {
                if ( (harePos - 12) < 1) {
                    harePos = 1;
                    hareStatus = Status.BIG_SLIP;
                    System.out.println(hareStatus);
                }
                
                else {
                    harePos = harePos - 12;
                    hareStatus = Status.BIG_SLIP;
                    System.out.println(hareStatus);
                }
            }
            else if (randomValue >= 6 && randomValue <= 8) {
                harePos = harePos + 1;
                hareStatus = Status.SMALL_HOP;
                System.out.println(hareStatus);
            }
            else if (randomValue == 9 || randomValue == 10) {
                if ( (harePos - 2 ) < 1){
                    harePos = 1;
                    hareStatus = Status.SMALL_SLIP;
                    System.out.println(hareStatus);
                }
                else {
                    harePos = harePos - 2;
                    hareStatus = Status.SMALL_SLIP;
                    System.out.println(hareStatus);
                }
            }
   }
    public static void main(String[] args) throws InterruptedException {
        System.out.print("The Race is Starting in ");
        TimeUnit.SECONDS.sleep(1);
        System.out.print(" 3");
        TimeUnit.SECONDS.sleep(1);
        System.out.print(" 2");
        TimeUnit.SECONDS.sleep(1);
        System.out.print(" 1");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(" GOOO!!!!");

        do {
            
            
            TimeUnit.SECONDS.sleep(1);
            
            turtle();
            
            System.out.println( "                    __\n" +
                                "         .,-;-;-,. /'_\\\n" +
                                "       _/_/_/_|_\\_\\) /\n" +
                                "     '-<_><_><_><_>=/\\\n" +
                                "       `/_/====/_/-'\\_\\\n" +
                                "        \"\"     \"\"    \"\"");
            System.out.println("->: " + turtlePos + "\n");
            
            hare();
            System.out.println(  "            ,\\\n" +
                        "             \\\\\\,_\n" +
                        "              \\` ,\\\n" +
                        "         __,.-\" =__)\n" +
                        "       .\"        )\n" +
                        "    ,_/   ,    \\/\\_\n" +
                        "    \\_|    )_-\\ \\_-`\n" +
                        "       `-----` `--`");
            System.out.println("->: " + harePos + "\n");
            if (turtlePos == harePos) {
                System.out.println("OUCH!!");
            }
            
            if (turtlePos >= 70) {
                System.out.println("Turtle Won!!");
                break;
            }
            else if (harePos >= 70) {
                System.out.println("Hare Won!!");
                break;
            }
        }
        while (turtlePos < 70 || harePos < 70);
    }
}