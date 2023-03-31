import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.floor;

/**
 * Class Data is a representation of a date. It contains methods to check leap year and compare two Data objects.
 * It also contains a nested class Month which has properties of fullName, shortName, romeNumber, monthId, numberOfDays.
 * The class also has static final int variables ROME, SHORT, LONG and FULL.
 *
 * @author Damian Ciura
 * @version 1.0
 */
public class Data implements Comparable<Data> {

    /**
     * ROME is a static final int variable
     */
    static final int ROME = 542;
    /**
     * SHORT is a static final int variable
     */
    static final int SHORT = 543;
    /**
     * LONG is a static final int variable
     */
    static final int LONG = 544;
    /**
     * FULL is a static final int variable
     */
    static final int FULL = 545;


    /**
     * dayName is an array of String which contains names of days
     */


    private
    final String[] dayName = new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    /**
     * refDay is an int variable which contain id of the name of a reference day
     */
    final int refDay = 2;
    /**
     * isLeapYear is a boolean variable which is true if a year is leap year
     */
    boolean isLeapYear;
    /**
     * year is an int variable which contains year of a date
     */
    int year;
    /**
     * day is an int variable which contains day of a date
     */
    int day;
    /**
     * thisMonth is a variable of type Month which contains month of a date
     */
    Month thisMonth;

    /**
     * leapYear is a method which takes an int variable and checks if it is leap year or not.
     * If input year is divisible by 4 and not divisible by 100 or divisible by 400, it is set isLeapYear as true.
     *
     * @param a int variable for which leap year is to be checked
     */
    void leapYear(int a) {
        if (a % 4 == 0) {
            if (a % 100 == 0) {
                isLeapYear = a % 400 == 0;
            } else isLeapYear = true;
        } else {
            isLeapYear = false;
        }
    }

    /**
     * This method compares this Data with the specified Data for order. Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Data o) {
        if (this.year > o.year) {
            return 1;
        } else if (this.year < o.year) {
            return -1;
        } else {
            if (this.thisMonth.monthId > o.thisMonth.monthId) {
                return 1;
            } else if (this.thisMonth.monthId < o.thisMonth.monthId) {
                return -1;
            } else {
                if (this.day > o.day) {
                    return 1;
                } else if (this.day < o.day) {
                    return -1;
                } else {
                    return 0;
                }

            }
        }
    }

    /**
     * Nested class Month which has properties of fullName, shortName, romeNumber, monthId and numberOfDays.
     */
    public static class Month {
        /**
         * fullName is a String variable which contains full name of month
         */
        String fullName;
        /**
         * shortName is a String variable which contains short name of month
         */
        String shortName;
        /**
         * romeNumber is a String variable which contains roman representation of month
         */
        String romeNumber;
        /**
         * monthId is an int variable which contains id of month
         */
        int monthId;
        /**
         * numberOfDays is an int variable which contains number of days in month
         */
        int numberOfDays;

        /**
         * Month is a constructor which takes 5 arguments fullN, shortN, rome, id and number and initializes
         * the properties fullName, shortName, romeNumber, monthId and numberOfDays.
         * @param fullN  String variable contains full name of month
         * @param shortN String variable contains short name of month
         * @param rome   String variable contains roman representation of month
         * @param id     int variable contains id of month
         * @param number int variable contains number of days in month
         */
        Month(String fullN, String shortN, String rome, int id, int number) {
            this.fullName = fullN;
            this.shortName = shortN;
            this.romeNumber = rome;
            this.monthId = id;
            this.numberOfDays = number;
        }
    }

    /**
     * getMonth is a method which takes an int variable i and returns Month object
     * @param i int variable which is used to get the month object
     * @return Month object
     */
    public Month getMonth(int i) {
        ArrayList<Month> listOfMonths = new ArrayList<>();
        listOfMonths.add(new Month("January", "Jan", "I", 1, 31));
        listOfMonths.add(new Month("February", "Feb", "II", 2, 28));
        listOfMonths.add(new Month("March", "Mar", "III", 3, 31));
        listOfMonths.add(new Month("April", "Apr", "IV", 4, 30));
        listOfMonths.add(new Month("May", "May", "V", 5, 31));
        listOfMonths.add(new Month("June", "Jun", "VI", 6, 30));
        listOfMonths.add(new Month("July", "Jul", "VII", 7, 31));
        listOfMonths.add(new Month("August", "Aug", "VIII", 8, 31));
        listOfMonths.add(new Month("September", "Sep", "IX", 9, 30));
        listOfMonths.add(new Month("October", "Oct", "X", 10, 31));
        listOfMonths.add(new Month("November", "Nov", "XI", 11, 30));
        listOfMonths.add(new Month("December", "Dec", "XII", 12, 31));
        listOfMonths.add(new Month("February", "Feb", "II", 2, 29));

        return listOfMonths.get(i - 1);
    }

    /**
     * Data is a constructor which takes 3 int variables d, y, m and initializes the properties' day, year and thisMonth.
     * It also calls leapYear method to check if the year is leap year or not.
     * @param d int variable which contains day
     * @param m int variable which contains month
     * @param y int variable which contains year
     */
    public Data(int d, int m, int y) {
        day = d;
        year = y;
        leapYear(y);
        if (isLeapYear && (m == 2)) {
            this.thisMonth = getMonth(m + 11);
        } else {
            this.thisMonth = getMonth(m);
        }
    }

    /**
     * Data is a constructor which takes 2 int variables d, y and 1 String variable m and initializes the properties' day, year and thisMonth.
     * It also calls leapYear method to check if the year is leap year or not.
     * @param d int variable which contains day
     * @param m String variable which contains month
     * @param y int variable which contains year
     */
    public Data(int d, String m, int y) {
        day = d;
        year = y;
        leapYear(y);

        int mid = 1;
        if (m.contains("I") || m.contains("V") || m.contains("X")) {
            switch (m) {
                case "I" -> mid = 1;
                case "II" -> mid = 2;
                case "III" -> mid = 3;
                case "IV" -> mid = 4;
                case "V" -> mid = 5;
                case "VI" -> mid = 6;
                case "VII" -> mid = 7;
                case "VIII" -> mid = 8;
                case "IX" -> mid = 9;
                case "X" -> mid = 10;
                case "XI" -> mid = 11;
                case "XII" -> mid = 12;
            }
        } else if (m.length() == 3) {
            mid = switch (m) {
                case "Jan" -> 1;
                case "Feb" -> 2;
                case "Mar" -> 3;
                case "Apr" -> 4;
                case "May" -> 5;
                case "Jun" -> 6;
                case "Jul" -> 7;
                case "Aug" -> 8;
                case "Sep" -> 9;
                case "Oct" -> 10;
                case "Nov" -> 11;
                case "Dec" -> 12;
                default -> mid;
            };
        } else {
            mid = switch (m) {
                case "January" -> 1;
                case "February" -> 2;
                case "March" -> 3;
                case "April" -> 4;
                case "June" -> 6;
                case "July" -> 7;
                case "August" -> 8;
                case "September" -> 9;
                case "October" -> 10;
                case "November" -> 11;
                case "December" -> 12;
                default -> mid;
            };
        }
        if (isLeapYear && (mid == 2)) {
            this.thisMonth = getMonth(mid + 11);
        } else {
            this.thisMonth = getMonth(mid);
        }
    }

    /**
     * Data is a constructor which takes no variables, it uses class LocalDate to take current local date and initializes the properties' day, year and thisMonth.
     * It also calls leapYear method to check if the year is leap year or not.
     */
    public Data() {
        LocalDate data = LocalDate.now();
        this.year = data.getYear();
        this.day = data.getDayOfMonth();
        leapYear(this.year);
        int m = data.getMonthValue();
        if (isLeapYear && (m == 2)) {
            this.thisMonth = getMonth(m + 11);
        } else {
            this.thisMonth = getMonth(m);
        }
    }
    /**
     * writeDate is a method which takes an int variable method as parameter and prints the date in different format based on the value of method.
     * if method is SHORT, it prints date in format of "day-shortNameOfMonth-year"
     * if method is LONG, it prints date in format of "day fullNameOfMonth year"
     * if method is FULL, it prints date in format of "nameOfDay, day fullNameOfMonth year"
     * if method is ROME, it prints date in format of "day.romeRepresentationOfMonth.year"
     * @param method int variable which determines the format of date to be printed
     */
    void writeDate(int method) {
        switch (method) {
            case SHORT -> {
                System.out.println(this.day + "-" + this.thisMonth.shortName + "-" + this.year);
            }
            case LONG -> {
                System.out.println(this.day + " " + this.thisMonth.fullName + " " + this.year);
            }
            case FULL -> {
                System.out.println(this.getNameDayCal() + ", " + this.day + " " + this.thisMonth.fullName + " " + this.year);
            }
            case ROME -> {
                if (this.day > 9) {
                    System.out.println(this.day + "." + this.thisMonth.romeNumber + "." + this.year);
                } else {
                    System.out.println("0" + this.day + "." + this.thisMonth.romeNumber + "." + this.year);
                }
            }
        }
    }

    /**
     * weekBefore is a method which decreases the current date by 7 days.
     * It checks the day,month and year of current date and updates them accordingly.
     * if the current day is less than 7, it updates the month and year accordingly,
     * it uses getMonth method to get the updated month.
     */
    void weekBefore() {
        if (day - 7 < 1) {
            if (thisMonth.monthId != 3 && thisMonth.monthId != 1) {
                thisMonth = getMonth(thisMonth.monthId - 1);
                day = thisMonth.numberOfDays + (day - 7);
            } else if (thisMonth.monthId == 1) {
                year--;
                thisMonth = getMonth(12);
                day = thisMonth.numberOfDays + (day - 7);
                leapYear(year);
            } else {
                if (isLeapYear) {
                    thisMonth = getMonth(13);
                } else {
                    thisMonth = getMonth(2);
                }
                day = thisMonth.numberOfDays + (day - 7);
            }
        } else {
            day -= 7;
        }
    }

    /**
     * weekAfter is a method which increases the current date by 7 days.
     * It checks the day,month and year of current date and updates them accordingly.
     * if the current day + 7 days is greater than the number of days in the current month, it updates the month and year accordingly,
     * it uses getMonth method to get the updated month.
     */
    void weekAfter() {
        if (day + 7 > thisMonth.numberOfDays) {
            if (thisMonth.monthId != 12) {
                day = (day + 7) - thisMonth.numberOfDays;
                thisMonth = getMonth(thisMonth.monthId + 1);
            } else {
                year++;
                day = (day + 7) - thisMonth.numberOfDays;
                thisMonth = getMonth(1);
                leapYear(year);
            }
        } else {
            day += 7;
        }
    }

    /**
     * getNameDayCal is a method which calculates the name of the day for the current date.
     * It uses the day, month and year properties of the current date and applies the mathematical calculation to find the name of the day.
     * It returns the name of the day as a string.
     * @return string which contains the name of the day for the current date
     */
    String getNameDayCal() {
        double q = this.day;
        double m;
        if (this.thisMonth.monthId == 1) {
            m = 13;
        } else if (this.thisMonth.monthId == 2) {
            m = 14;
        } else {
            m = this.thisMonth.monthId;
        }

        double Y;
        if (m > 12) {
            Y = this.year - 1;
        } else {
            Y = this.year;
        }


        double h = (q + floor((13 * (m + 1)) / 5) + Y + floor(Y / 4) - floor(Y / 100) + floor(Y / 400)) % 7;
        int ha = (int) h;

        return dayName[ha];
    }

    /**
     * getNameDayRef is a method which calculates the name of the day for the current date based on a reference date.
     * It uses the day, month and year properties of the current date, compares with the reference date and applies mathematical calculations to find the name of the day.
     * It returns the name of the day as a string.
     * @return string which contains the name of the day for the current date
     */
    String getNameDayRef() {

        final Data refData = new Data(16, 2023, 1);
        int foundedDay = refDay;
        int diffInDays = 0;
        Data tmpDate = refData;
        boolean foundDay = false;
        while (!foundDay) {
            if (this.year == tmpDate.year) {
                if (this.thisMonth.monthId == tmpDate.thisMonth.monthId) {
                    do {

                        if (diffInDays < -6) {
                            tmpDate.weekAfter();
                        } else if (diffInDays > 6) {
                            tmpDate.weekBefore();
                        }
                        diffInDays = tmpDate.day - this.day;
                    } while (abs(diffInDays) > 6);
                    if (diffInDays > 0) {
                        while (tmpDate.day > this.day) {
                            foundedDay--;
                            if (foundedDay < 0) {
                                foundedDay = 6;
                            }
                            tmpDate.day--;
                        }
                    } else {
                        while (tmpDate.day <= this.day) {
                            foundedDay++;
                            if (foundedDay > 6) {
                                foundedDay = 0;
                            }
                            tmpDate.day++;
                        }
                    }

                    foundDay = true;

                } else if (this.thisMonth.monthId > tmpDate.thisMonth.monthId) {
                    while (this.thisMonth.monthId != tmpDate.thisMonth.monthId) {
                        tmpDate.weekAfter();
                    }
                } else {
                    while (this.thisMonth.monthId != tmpDate.thisMonth.monthId) {
                        tmpDate.weekBefore();
                    }
                }
            } else if (this.year > tmpDate.year) {
                while (this.year != tmpDate.year) {
                    tmpDate.weekAfter();
                }
            } else {
                while (this.year != tmpDate.year) {
                    tmpDate.weekBefore();
                }
            }
        }
        return dayName[foundedDay];

    }
    /**
     * parse method takes a String variable date in format dd-mm-yyyy and returns a new Data object by parsing the values of day, month and year from the input string and passing them as arguments to the Data constructor.
     *
     * @param date String variable in format dd-mm-yyyy
     * @return new Data object with properties initialized from parsed values of input string
     */
    public Data parse(String date){
        String[] splitedDate = date.split("-");
        return new Data(Integer.getInteger(splitedDate[0]),Integer.getInteger(splitedDate[1]),Integer.getInteger(splitedDate[2]));
    }
}

