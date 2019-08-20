import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
/*        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);*/
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        Scanner sc = new Scanner(System.in);
        ArrayList<Task> commandList = new ArrayList<Task>();
        String input = sc.nextLine();
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                int size = commandList.size();
                for (int i = 1; i < size + 1; i++) {
                    System.out.print(i + ".");
                    System.out.println(commandList.get(i - 1));
                }
            } else if (input.substring(0,4).equals("done")) {
                String[] arr = input.split(" ");
                int number = Integer.parseInt(arr[1]);
                commandList.get(number-1).complete();
            } else {
                if (input.substring(0, 4).equals("todo")) {
                    ToDo todo = new ToDo(input.substring(5));
                    commandList.add(todo);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(todo);
                } else if (input.substring(0, 8).equals("deadline")) {
                    String deadlineDetails = input.substring(9);
                    String[] arr = deadlineDetails.split("/");
                    Deadline deadline = new Deadline(arr[0], arr[1]);
                    commandList.add(deadline);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(deadline);
                } else {
                    String eventDetails = input.substring(6);
                    String[] arr = eventDetails.split("/");
                    Event event = new Event(arr[0], arr[1]);
                    commandList.add(event);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(event);
                }
                int numberOfTasks = commandList.size();
                if (numberOfTasks == 1) {
                    System.out.println("Now you have " + numberOfTasks + " task in the list");
                } else
                    System.out.println("Now you have " + numberOfTasks + " tasks in the list");
            }
            input = sc.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
        }
    }
