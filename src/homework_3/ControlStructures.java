package homework_3;

import java.util.Scanner;

public class ControlStructures {
    public static void main(String[] args) {
        getMonthName();
        getSeasonName();
        defineIfEven();
        getWeather();
        getColorOfRainbow();
    }

    public static void getMonthName() {
        int numberOfMonth = checkValidMonth();
        String nameOfMonth = null;
        switch (numberOfMonth) {
            case 1:
                nameOfMonth = "January";
                break;
            case 2:
                nameOfMonth = "February";
                break;
            case 3:
                nameOfMonth = "March";
                break;
            case 4:
                nameOfMonth = "April";
                break;
            case 5:
                nameOfMonth = "May";
                break;
            case 6:
                nameOfMonth = "June";
                break;
            case 7:
                nameOfMonth = "July";
                break;
            case 8:
                nameOfMonth = "August";
                break;
            case 9:
                nameOfMonth = "September";
                break;
            case 10:
                nameOfMonth = "October";
                break;
            case 11:
                nameOfMonth = "November";
                break;
            case 12:
                nameOfMonth = "December";
                break;
        }
        System.out.println("Your entered number " + numberOfMonth + " corresponds to month: " + nameOfMonth);
    }

    public static void getSeasonName() {
        int numberOfMonth = checkValidMonth();
        String nameOfSeason;
        if (numberOfMonth > 2 && numberOfMonth < 6) {
            nameOfSeason = "Spring";
        } else if (numberOfMonth > 5 && numberOfMonth < 9) {
            nameOfSeason = "Summer";
        } else if (numberOfMonth > 8 && numberOfMonth < 12) {
            nameOfSeason = "Autumn";
        } else {
            nameOfSeason = "Winter";
        }
        System.out.println("Your entered number " + numberOfMonth + " corresponds to season: " + nameOfSeason);
    }


    // define 0 as even
    public static void defineIfEven() {
        Scanner scanner = new Scanner(System.in);
        boolean validValue = false;
        int number = 0;
        while (!validValue) {
            System.out.println("Please enter the whole number to define if it is even or not.");
            if (!scanner.hasNextInt()) {
                System.out.println("You've entered invalid value.");
                scanner.next();
            } else {
                number = scanner.nextInt();
                if (number % 2 != 0 && (Math.abs(number % 2) != 1)) {
                    System.out.println("You've entered invalid value.");
                } else {
                    validValue = true;
                }
            }
        }
        if (number % 2 == 0) {
            System.out.println("Your entered number " + number + " is even.");
        } else {
            System.out.println("Your entered number " + number + " is not even.");
        }
    }

    public static void getWeather() {
        Scanner scanner = new Scanner(System.in);
        boolean validValue = false;
        while (!validValue) {
            System.out.println("Укажите, сколько градусов сегодня на улице (целое число), чтобы узнать, холодно или нет.");
            if (!scanner.hasNextInt()) {
                System.out.println("Вы не ввели целое число.");
                scanner.next();
            } else {
                validValue = true;
            }
        }
        int temperature = scanner.nextInt();
        String weather;
        if (temperature > -5) {
            weather = "тепло.";
        } else if (temperature > -20) {
            weather = "нормально.";
        } else {
            weather = "холодно.";
        }
        System.out.println("Сегодня " + weather);
    }

    public static void getColorOfRainbow() {
        Scanner scanner = new Scanner(System.in);
        boolean validValue = false;
        String color = null;
        int numberOfColor = 0;
        while (!validValue) {
            System.out.println("Please enter the number of rainbow color from 1 to 7. To define the color of corresponding number.");
            if (!scanner.hasNextInt()) {
                System.out.println("You've entered invalid value.");
                scanner.next();
            } else {
                numberOfColor = scanner.nextInt();
                if (numberOfColor <= 0 || numberOfColor > 7) {
                    System.out.println("Your entered number " + numberOfColor + " doesn't correspond to any rainbow color.");
                    System.out.println("-----------------------------------------------------------");
                } else {
                    validValue = true;
                }
            }
        }
        switch (numberOfColor) {
            case 1:
                color = "red";
                break;
            case 2:
                color = "orange";
                break;
            case 3:
                color = "yellow";
                break;
            case 4:
                color = "green";
                break;
            case 5:
                color = "light blue";
                break;
            case 6:
                color = "blue";
                break;
            case 7:
                color = "purple";
                break;
        }
        System.out.println("Your entered number " + numberOfColor + " corresponds to rainbow color: " + color);
    }

    public static int checkValidMonth(){
        boolean validValue=false;
        int numberOfMonth=0;
        Scanner scanner = new Scanner(System.in);
        while (!validValue) {
            System.out.println("Please enter the number of month from 1 to 12. To define the name of corresponding month.");
            if (!scanner.hasNextInt()) {
                System.out.println("You've entered invalid value.");
                scanner.next();
            } else {
                numberOfMonth = scanner.nextInt();
                if (numberOfMonth <= 0 || numberOfMonth > 12) {
                    System.out.println("Your entered number " + numberOfMonth + " doesn't correspond to any month.");
                    System.out.println("-----------------------------------------------------------");
                } else {
                    validValue = true;
                }
            }
        }
        return numberOfMonth;
    }
}




