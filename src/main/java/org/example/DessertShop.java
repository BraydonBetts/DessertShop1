package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class DessertShop {
    public static void main(String[] args) {
        Order order = new Order();

        //Adding items to the order
        order.addItem(new Candy("Candy Corn", 1.5, 0.25));
        order.addItem(new Candy("Gummy Bears", 0.25, 0.35));
        order.addItem(new Cookie("Chocolate Chip", 6, 3.99));
        order.addItem(new IceCream("Pistachio", 2, 0.79));
        order.addItem(new Sundae("Vanilla", 3.00));
        order.addItem(new Cookie("Oatmeal", 2, 3.45));

        boolean closed = false; // Flag to indicate if the program should stop

        while (!closed) {
            Order order1 = new Order(); // Create a new order
            boolean done = false; // Flag to check if user is done with order
            Scanner in = new Scanner(System.in); // Scanner for user input
            String choice;
            DessertItem orderItem;

            while (!done) {
                System.out.println("\n1: Candy");
                System.out.println("2: Cookie");
                System.out.println("3: Ice Cream");
                System.out.println("4: Sundae");
                System.out.println("5: Admin Module");

                System.out.print("\nWhat would you like to add to the order? (1-5, Enter for done): ");
                choice = in.nextLine();

                if (choice.equals("")) {
                    done = true;
                } else {
                    switch (choice) {
                        case "1":
                            orderItem = userPromptCandy();
                            order.addItem(orderItem);
                            break;
                        case "2":
                            orderItem = userPromptCookie();
                            order.addItem(orderItem);
                            break;
                        case "3":
                            orderItem = userPromptIceCream();
                            order.addItem(orderItem);
                            break;
                        case "4":
                            orderItem = userPromptSundae();
                            order.addItem(orderItem);
                            break;
                        case "5":
                            adminModule();
                            break;
                        default:
                            System.out.println("Invalid choice, please select 1-4 or press Enter to finish.");
                    }
                }
            }

            if (order.getTotalItems() > 0) {
                // Customer input
                System.out.print("\nEnter the customer name: ");
                String custName = in.nextLine();

                Customer customer;
                if (hasCustomer(custName)) {
                    customer = getCustomer(custName);
                } else {
                    customer = new Customer(custName);
                    createCustomer(custName, customer);
                }

                //Payment method
                String paymentMethod = getPaymentMethod(in, order);

                //Print receipt
                System.out.println(order);
                customer.addToHistory(order);

                System.out.printf("\nCustomer Name: %-20s Customer ID: %-10d Total Orders: %d%n",
                        customer.getName(), customer.getID(), customer.getOrderHistory().size());
            }

            System.out.print("\nHit enter to start a new order: ");
            String response = in.nextLine().trim();
            if (response.equalsIgnoreCase("")) {
                closed = false;
            }
        }

        System.out.println("Thank you for using DessertShop! Goodbye!");

    }

    private static String getPaymentMethod(Scanner in, Order order) {
        String paymentMethod;
        boolean valid = false;

        while (!valid) {
            System.out.println("\nSelect payment method (CASH, CARD, PHONE): ");
            paymentMethod = in.nextLine().toUpperCase();

            for (Payable.PayType type : Payable.PayType.values()) {
                if (paymentMethod.equalsIgnoreCase(type.name())) {
                    order.setPayType(type);
                    return type.name();
                }
            }

            System.out.println("Invalid payment method. Please select from CASH, CARD, PHONE.");
        }

        return "";
    }

    private static DessertItem userPromptCandy() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the type of the candy: ");
        String name = in.nextLine();

        double candyWeight = 0;
        while (true) {
            System.out.print("Enter the weight of the candy (in pounds): ");
            if (in.hasNextDouble()) {
                candyWeight = in.nextDouble();
                in.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number for the weight.");
                in.nextLine();
            }
        }

        double pricePerPound = 0;
        while (true) {
            System.out.print("Enter the price per pound of the candy: ");
            if (in.hasNextDouble()) {
                pricePerPound = in.nextDouble();
                in.nextLine();
                break;
            } else {
                System.out.print("Invalid input. Please enter a valid number for the price.");
                in.nextLine();
            }
        }

        return new Candy(name, candyWeight, pricePerPound);
    }

    private static DessertItem userPromptCookie() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the type of cookie: ");
        String name = in.nextLine();

        int cookieQty = 0;
        while (true) {
            System.out.print("Enter the quantity purchased:: ");
            if (in.hasNextInt()) {
                cookieQty = in.nextInt();
                in.nextLine(); // Consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer for the quantity.");
                in.nextLine(); // Consume invalid input
            }
        }

        double pricePerDozen = 0;
        while (true) {
            System.out.print("Enter the price per dozen: ");
            if (in.hasNextDouble()) {
                pricePerDozen = in.nextDouble();
                in.nextLine(); // Consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number for the price.");
                in.nextLine(); // Consume invalid input
            }
        }
        return new Cookie(name, cookieQty, pricePerDozen);
    }

    private static DessertItem userPromptIceCream() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the type of Ice Cream used: ");
        String name = in.nextLine();

        int scoopCount = 0;
        while (true) {
            System.out.print("Enter the number of scoops: ");
            if (in.hasNextInt()) {
                scoopCount = in.nextInt();
                in.nextLine(); // Consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer for the scoop count.");
                in.nextLine();
            }
        }

        double pricePerScoop = 0;
        while (true) {
            System.out.print("Enter the price per scoop: ");
            if (in.hasNextDouble()) {
                pricePerScoop = in.nextDouble();
                in.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number for the price.");
                in.nextLine();
            }
        }


        return new IceCream(name, scoopCount, pricePerScoop);
    }

    //----------------------------
    private static DessertItem userPromptSundae() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the topping name for the sundae: ");
        String toppingName = in.nextLine();

        //Input validation
        double toppingPrice = 0;
        while (true) {
            System.out.print("Enter the price for the topping: ");
            if (in.hasNextDouble()) {
                toppingPrice = in.nextDouble();
                in.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number for the topping price.");
                in.nextLine();
            }
        }

        //Return a new Sundae
        return new Sundae(toppingName, toppingPrice);
    }
    private static void adminModule() {
        while (true) {
            System.out.println("\nAdmin Module");
            System.out.println("1: Shop Customer List");
            System.out.println("2: Customer Order History");
            System.out.println("3: Best Customer");
            System.out.println("4: Exit Admin Module");
            System.out.print("Choose an option: ");
            Scanner in = new Scanner(System.in);
            String adminChoice = in.nextLine();
            switch (adminChoice) {
                case "1":
                    showCustomerList();
                    break;
                case "2":
                    showCustomerOrderHistory();
                    break;
                case "3":
                    showBestCustomer();
                    break;
                case "4":
                    System.out.println("Exiting Admin Module...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showCustomerList() {
        System.out.println("\nShop Customer List");
        if (customerDB.isEmpty()) {
            System.out.println("No customers in the system.");
        } else {
            for (Customer customer : customerDB.values()) {
                System.out.printf("Customer Name: %s, Customer ID: %d%n", customer.getName(), customer.getID());
            }
        }
    }

    private static void showCustomerOrderHistory() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter the customer name: ");
        String name = in.nextLine();
        Customer customer = customerDB.get(name);

        if (customer == null) {
            System.out.println("Customer not found.");
        } else {
            System.out.printf("\n--- Order History for %s ---\n", name);
            if (customer.getOrderHistory().isEmpty()) {
                System.out.println("No orders found for this customer.");
            } else {
                for (Order order : customer.getOrderHistory()) {
                    System.out.println(order);
                }
            }
        }
    }

    private static void showBestCustomer() {
        String bestCustomer = null;
        int maxOrders = 0;

        for (Customer customer : customerDB.values()) {
            int orderCount = customer.getOrderHistory().size();
            if (orderCount > maxOrders) {
                maxOrders = orderCount;
                bestCustomer = customer.getName();
            }
        }

        if (bestCustomer == null) {
            System.out.println("No customers have placed orders yet.");
        } else {
            System.out.printf("Congratulations to our Best Customer: %s with %d orders!%n", bestCustomer, maxOrders);
        }
    }


    private static  HashMap<String, Customer> customerDB = new HashMap<>();

    public static boolean hasCustomer(String name) {
        return customerDB.containsKey(name);
    }

    public static Customer getCustomer(String name) {
        return customerDB.get(name);
    }

    public static void createCustomer(String name, Customer customer) {
        customerDB.put(name, customer);
    }
}
