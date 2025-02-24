
import java.util.*;
import java.time.Year;
import java.util.regex.*;
class Contact{
    private String idNo;
    private String name;
    private String tpNo;
    private String comName;
    private double salDouble;
    private String bday;
    public Contact(String idNo,String name,String tpNo,String comName,double salDouble,String bday){
        this.idNo = idNo;
        this.name = name;
        this.tpNo = tpNo;
        this.comName = comName;
        this.salDouble = salDouble;
        this.bday = bday;
    }

    @Override
    public String toString() {
        return "ID: " + idNo +
                "\nName: " + name +
                "\nPhone Number: " + tpNo +
                "\nCompany Name: " + comName +
                "\nSalary: " + salDouble +
                "\nBirthday: " + bday;
    }
    public String getIdNo(){
        return this.idNo;
    }
    public String getName(){
        return this.name;
    }
    public String getComName(){
        return this.comName;
    }
    public String getTpNo(){
        return this.tpNo;
    }
    public double getSal(){
        return this.salDouble;
    }
    public String getBday(){
        return this.bday;
    }
    public void setName(String newName) {
        this.name = newName;
    }

    public void setTpNo(String tpNo) {
        this.tpNo = tpNo;
    }

    public void setSal(double salDouble) {
        this.salDouble = salDouble;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }
}

//--------------------------contact List object-----------------------------//
class ContactList {
    private Contact[] contactArray;

    public ContactList() {
        contactArray = new Contact[0];
    }

    public Contact[] getContactArray() {
        return contactArray;
    }

    //-----------------------add----------------------------------//
    public Contact[] add(Contact c1) {
        Contact[] tempContactArray = new Contact[contactArray.length + 1];

        for (int i = 0; i < contactArray.length; i++) {
            tempContactArray[i] = contactArray[i];
        }
        tempContactArray[contactArray.length] = c1;
        contactArray = tempContactArray;
        return contactArray;
    }

    //-------------------update method---------------------------------//
    public Contact update(int index){
        if(isValidIndex(index)){
            return getContactArray()[index];
        }
        return null;
    }

    //---------------- Delete contact method -------------------------//
    public void delete(int index) {
        Contact[] shortContactArray = new Contact[contactArray.length - 1];

        if (index >= 0 && index < contactArray.length) {
            for (int i = index; i < contactArray.length - 1; i++) {
                contactArray[i] = contactArray[i + 1];
            }
            for (int i = 0; i < shortContactArray.length; i++) {
                shortContactArray[i] = contactArray[i];
            }
        }
        contactArray = shortContactArray;
    }

    //----------------------Display contact method-----------------------------------//
    public int displayConatct(String root) {
        boolean found = false;
        for (int i = 0; i < contactArray.length; i++) {
            if (contactArray[i].getName().equalsIgnoreCase(root) || contactArray[i].getTpNo().equalsIgnoreCase(root)) {
                System.out.println("Contact ID\t\t: " + contactArray[i].getIdNo());
                System.out.println("Name\t\t\t: " + contactArray[i].getName());
                System.out.println("Phone Number\t\t: " + contactArray[i].getTpNo());
                System.out.println("Company Name\t\t: " + contactArray[i].getComName());
                System.out.println("Salary\t\t\t: " + contactArray[i].getSal());
                System.out.println("B'Day\t\t\t: " + contactArray[i].getBday());
                found = true;
                return i;
            }
        }
        return -1;
    }
    //----------------------Search contact method-----------------------------------//
    public void search() {
        Scanner inputSearchConatct = new Scanner(System.in);
        System.out.print("Search Contact by Name or Phone Number - ");
        String root = inputSearchConatct.nextLine();
        boolean found = false;
        for (int i = 0; i < contactArray.length; i++) {
            if (contactArray[i].getName().equalsIgnoreCase(root) || contactArray[i].getTpNo().equalsIgnoreCase(root)) {
                System.out.println("Contact ID\t\t: " + contactArray[i].getIdNo());
                System.out.println("Name\t\t\t: " + contactArray[i].getName());
                System.out.println("Phone Number\t\t: " + contactArray[i].getTpNo());
                System.out.println("Company Name\t\t: " + contactArray[i].getComName());
                System.out.println("Salary\t\t\t: " + contactArray[i].getSal());
                System.out.println("B'Day\t\t\t: " + contactArray[i].getBday());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found!");
        }
    }
    public boolean isValidIndex(int index){
        if(index>=0 && index<= getContactArray().length){
            return true;
        }
        return false;
    }
}
//-------------------- Main class under here -----------------------//
class Demo {    private static int newId;
    private static ContactList contactList = new ContactList();
    public static void main(String args[]) {
        homePage();
    }


    //---------------------Home Page is here----------------------------//
    public static void homePage() {
        System.out.println("+---------------------------------------+");
        System.out.printf("|\t\tI Friend\t\t|\n");
        System.out.println("+---------------------------------------+");

        System.out.println("[01] ADD Contacts");
        System.out.println("[02] UPDATE Contacts");
        System.out.println("[03] DELETE Contacts");
        System.out.println("[04] SEARCH Contacts");
        System.out.println("[05] LIST Contacts");
        System.out.println("[06] Exit\n");
        System.out.print("Enter an option to continue-->");
        Scanner scHomePage = new Scanner(System.in);
        int cmdHomePage = scHomePage.nextInt();

        switch (cmdHomePage) {
            case 1:
                clearConsole();
                addContact();
                break;
            case 2:
                clearConsole();
                updateContact();
                break;
            case 3:
                clearConsole();
                deleteContact();
                break;
            case 4:
                clearConsole();
                searchContact();
                break;
            case 5:
                clearConsole();
                listContact();
                break;
            default:
                homePage();
        }
    }
    //(1)addContact method;
    public static void addContact() {
        String replyAddContact = "Y";
        Scanner inputAddContact = new Scanner(System.in);
        while (replyAddContact.equals("Y")) {
            System.out.printf("+---------------------------------------+\n");
            System.out.printf("|ADD Contacts to the list\t\t|\n");
            System.out.printf("+---------------------------------------+");
            System.out.println("\n");

            int newId = contactList.getContactArray().length+1;
            String idNo = String.format("C%04d", newId);
            System.out.printf(idNo);
            System.out.printf("\n=====\n");
            System.out.print("Name  \t\t : ");
            String name = inputAddContact.nextLine();
            String tpNo = "";
            boolean isValid = false;
            while (!isValid || tpNo.length() > 10) {
                System.out.print("Phone Number  \t : ");
                tpNo = inputAddContact.nextLine();
                isValid = isValidMobileNo(tpNo);
                if (!isValid || tpNo.length() > 10) {
                    System.out.println("Invalid phone number!");
                    System.out.print("Do you want to add phone number again (Y/N): ");
                    String isValidReply = inputAddContact.nextLine();
                    if (isValidReply.equalsIgnoreCase("Y")) {
                        continue;
                    } else {
                        homePage();
                        return;
                    }
                }
            }
            System.out.print("Company Name  \t : ");
            String comName = inputAddContact.nextLine();
            String sal = "";
            double salDouble = 0.0;
            boolean isSalaryOk = false;
            while (!isSalaryOk) {
                System.out.print("Salary \t\t : ");
                salDouble = inputAddContact.nextDouble();
                inputAddContact.nextLine();
                isSalaryOk = isSalaryValid(salDouble);
                if (!isSalaryOk) {
                    System.out.println("Invalid Salary...");
                    System.out.print("Do you want to add the Salary again (Y/N) : ");
                    String replySalary = inputAddContact.nextLine();
                    if (replySalary.equalsIgnoreCase("Y")) {
                        continue;
                    } else {
                        homePage();
                        return;
                    }
                }
            }
            String bday = "";
            boolean isbodValidate = false;
            while (!isbodValidate) {
                System.out.print("B'Day(YYYY-MM-DD): ");
                bday = inputAddContact.nextLine();
                isbodValidate = isbodValid(bday);
                if (!isbodValidate) {
                    System.out.println("Invalid Birthday...");
                    System.out.print("Do you want to add the BOD again (Y/N) : ");
                    String isbodValidReply = inputAddContact.nextLine();
                    if (isbodValidReply.equalsIgnoreCase("Y")) {
                        continue;
                    } else {
                        homePage();
                        return;
                    }
                }
            }
            Contact c1 = new Contact(idNo, name, tpNo, comName, salDouble, bday);
            contactList.add(c1);

            System.out.println("\t\tContact has been added successfully...\n");
            System.out.print("Do you want to add another contact(Y/N) : ");
            replyAddContact = inputAddContact.nextLine();
            clearConsole();
            if (replyAddContact.equals("N")) {
                homePage();
            }
        }
    }

    //(2)updateContacts method;
    public static void updateContact() {
        String replyUpdateContact = "Y";
        while (replyUpdateContact.equalsIgnoreCase("Y")) {
            Scanner inputUpdateContact = new Scanner(System.in);
            System.out.printf("+---------------------------------------+\n");
            System.out.printf("|UPDATE Contacts to the list\t\t|\n");
            System.out.printf("+---------------------------------------+");
            System.out.println("\n");
            System.out.print("Search Contact by Name or Phone Number - ");
            String searchingTool =  inputUpdateContact.nextLine();
            int searchIndex = contactList.displayConatct(searchingTool);
            if(searchIndex!=-1){
                doYouWantUpdate(searchIndex);
            }else{
                System.out.println("Contact Not found...");
            }
            System.out.print("Do you want to update another contact(Y/N):");
            replyUpdateContact = inputUpdateContact.nextLine();
            clearConsole();
        }
        homePage();
    }
    //Asking what we want to update ? //
    public static void doYouWantUpdate(int i) {
        Scanner inputdoYouWantUpdate = new Scanner(System.in);
        System.out.println();
        System.out.println("What do you want to update...");
        System.out.println("\t[01] Name");
        System.out.println("\t[02] Phone Number");
        System.out.println("\t[03] Company Name");
        System.out.println("\t[04] Salary");
        System.out.print("Enter an option to continue -->");
        int replyUpdateContact = inputdoYouWantUpdate.nextInt();
        switch (replyUpdateContact) {
            case 1:
                clearFiveLines();
                updateName(i);
                break;
            case 2:
                clearFiveLines();
                updatePhoneNumber(i);
                break;
            case 3:
                clearFiveLines();
                updateCompanyName(i);
                break;
            case 4:
                clearFiveLines();
                updateSalary(i);
                break;
        }
    }
    //-------------------update name method-----------------------------------//
    public static void updateName(int oldNameIndex) {
        Scanner inputUpdateName = new Scanner(System.in);
        System.out.println("Update Name\n==================");
        System.out.print("Input new Name - ");
        String newName = inputUpdateName.nextLine();
        contactList.update(oldNameIndex).setName(newName);
        System.out.println("Contact has been update succesfully...");
    }

    //-------------------update phone number method-----------------------------------//
    public static void updatePhoneNumber(int oldPhoneNumIndex) {
        Scanner inputupdatePhoneNumber = new Scanner(System.in);
        System.out.println("Update Phone Number\n==================");
        System.out.print(" Input new Phone Number - ");
        String newPhoneNum = inputupdatePhoneNumber.nextLine();
        contactList.update(oldPhoneNumIndex).setTpNo(newPhoneNum);
        System.out.println(" Contact has been update succesfully...");
    }

    //-------------------update company name method-----------------------------------//
    public static void updateCompanyName(int oldCompanyNameIndex) {
        Scanner inputupdateCompanyName = new Scanner(System.in);
        System.out.println("Update Company Name\n==================");
        System.out.print(" Input new Company Name - ");
        String newCompanyName = inputupdateCompanyName.nextLine();
        contactList.update(oldCompanyNameIndex).setComName(newCompanyName);
        System.out.println(" Contact has been update succesfully...");
    }

    //-------------------update salary method-----------------------------------//
    public static void updateSalary(int oldSalaryIndex) {
        Scanner inputupdateSalary = new Scanner(System.in);
        System.out.println("UpdateSalary\n==================");
        System.out.print(" Input new Salary - ");
        double newSalary = inputupdateSalary.nextDouble();
        contactList.update(oldSalaryIndex).setSal(newSalary);
        System.out.println(" Contact has been update succesfully...");
    }
    //(3) deleteContact method;
    public static void deleteContact(){
        String replyDeleteContact="Y";
        Scanner inputDeleteContact = new Scanner(System.in);
        while(replyDeleteContact.equalsIgnoreCase("Y")) {
            System.out.println("+---------------------------------------+");
            System.out.printf("|DELETE Contacts to the list\t\t|\n");
            System.out.println("+---------------------------------------+");

            System.out.print("Search Contact by Name or Phone Number - ");
            String root = inputDeleteContact.nextLine();
            boolean found = false;
            int deleteIndex=-1;
            int searchIndex = contactList.displayConatct(root);
            deleteIndex=searchIndex;
            if(deleteIndex!=-1) {
                System.out.print("Do you want to delete this contact(Y/N):");
                String replyDoYouWantToDelete = inputDeleteContact.nextLine();
                if (replyDoYouWantToDelete.equalsIgnoreCase("Y")) {
                    contactList.delete(deleteIndex);
                    System.out.println("Customer has been deleted successfully...");
                }
            }else{
                System.out.println("Contact not found!");
            }
            System.out.print("Do you want to Search another Contact(Y/N) : ");
            replyDeleteContact = inputDeleteContact.nextLine();
            clearConsole();
        }
        homePage();
    }
    //(4) search Conatct method;
    public static void searchContact() {
        String replySearchContact = "Y";
        Scanner inputReplySearchContact = new Scanner(System.in);
        while (replySearchContact.equalsIgnoreCase("Y")) {
            System.out.println("+---------------------------------------+");
            System.out.printf("|SEARCH Contacts to the list\t\t|\n");
            System.out.println("+---------------------------------------+");
            System.out.println();
            contactList.search();
            System.out.print("Do you want to search another contact(Y/N):");
            replySearchContact = inputReplySearchContact.nextLine();
            clearConsole();
        }
        homePage();
    }
    //<--------console clear method---------------->
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c",
                        "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }
    //clear Five Lines method
    public static void clearFiveLines() {
        System.out.print("\033[5A");
        System.out.print("\033[0J");
    }
    //salary checker method;
    public static boolean isSalaryValid(double salary) {
        // String sal = Double.toString(salary);
        if (salary <= 0) {
            return false;
        }
        return true;
    }
    //create a method to validate the BOD
    public static boolean isbodValid(String bday) {
        String pattern = "^\\d{4}-\\d{2}-\\d{2}$";
        boolean pat = Pattern.matches(pattern, bday);
        if (!pat) {
            return false; //when format wrong
        }
        int bodYear = Integer.parseInt(bday.substring(0, 4));
        int bodMonth = Integer.parseInt(bday.substring(5, 7));
        int bodDay = Integer.parseInt(bday.substring(8, 10));
        if (bodMonth > 12) {
            return false;
        }
        if (bodYear % 4 == 0) {
            if (bodYear % 100 != 0 || bodYear % 400 == 0) {
                if (bodMonth == 2 && bodDay > 29) {
                    return false;
                }
            }
        } else if (bodMonth == 2 && bodDay > 28) {
            return false;
        }

        switch (bodMonth) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (bodDay > 31) {
                    return false;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (bodDay > 30) {
                    return false;
                }
                break;
        }
        Year thisYear = Year.now();
        int thisYearValue = thisYear.getValue();

        if (bodYear > thisYearValue) {
            return false;
        }
        return true;
    }

    //create a method to phone number validate
    public static boolean isValidMobileNo(String phoneNo) {
        Pattern ptrn = Pattern.compile("(0)?[0-9]{9}");
        Matcher match = ptrn.matcher(phoneNo);
        return (match.find() && match.group().equals(phoneNo));
    }
    //(5)listContacts method;
    public static void listContact() {
        Scanner inputListContact = new Scanner(System.in);
        System.out.println("+---------------------------------------+");
        System.out.printf("|\t\tSORT Contacts\t\t|\n");
        System.out.println("+---------------------------------------+");
        System.out.println("[01] Sorting by Name");
        System.out.println("[02] Sorting by Salary");
        System.out.println("[03] Sorting by Birthday");
        System.out.println("[04] Exit");
        System.out.print("Enter an option to continue --> ");
        int replyInputListContact = inputListContact.nextInt();
        switch (replyInputListContact) {
            case 1:
                clearFiveLines();
                sortByName();
                break;
            case 2:
                clearFiveLines();
                sortBySalary();
                break;
            case 3:
                clearFiveLines();
                sortByBirthday();
                break;
            case 4:
                clearConsole();
                homePage();
                break;
        }
    }
    //------------------------List by name method-----------------------------------//
    public static void sortByName() {
        Contact[] sortContactArray = new Contact[contactList.getContactArray().length];
        sortContactArray = Arrays.copyOf(contactList.getContactArray(),contactList.getContactArray().length);
        for (int i = sortContactArray.length - 1; i >= 0; i--) {
            for (int j = 0; j < sortContactArray.length - 1; j++) {
                if (Demo.compareNames(sortContactArray[j].getName(), sortContactArray[j + 1].getName()) > 0) {
                    Contact tempContact = sortContactArray[j];
                    sortContactArray[j] = sortContactArray[j+1];
                    sortContactArray[j+1] = tempContact;
                }
            }
        }
        printTable(sortContactArray);
    }
    //-----------------------List by salary method-----------------------------------//

    public static void sortBySalary() {
        Contact[] sortContactArray = new Contact[contactList.getContactArray().length];
        sortContactArray = Arrays.copyOf(contactList.getContactArray(),contactList.getContactArray().length);
        for (int i = sortContactArray.length-1; i >=0; i--) {
            for (int j = 0; j < i; j++) {
                if (sortContactArray[j].getSal() < sortContactArray[i].getSal()) {
                    Contact tempContact = sortContactArray[j];
                    sortContactArray[j] = sortContactArray[i];
                    sortContactArray[i] = tempContact;
                }
            }
        }
        printTable(sortContactArray);
    }
    //-----------------------List by BOD method-----------------------------------//
    public static void sortByBirthday() {
        Contact[] sortContactArray = new Contact[contactList.getContactArray().length];
        sortContactArray = Arrays.copyOf(contactList.getContactArray(),contactList.getContactArray().length);
        for (int i = sortContactArray.length-1; i>=0; i--) {
            for (int j = 0; j < i; j++) {
                if (compareBirthdays(sortContactArray[j].getBday(), sortContactArray[i].getBday()) < 0) {
                    Contact tempContact = sortContactArray[j];
                    sortContactArray[j] = sortContactArray[i];
                    sortContactArray[i] = tempContact;
                }
            }
        }
        printTable(sortContactArray);
    }

    public static void printTable(Contact[] sortContactArray) {
        Scanner inputPrintable = new Scanner(System.in);
        System.out.println("+-------+-----------------+-----------------+------------------------+------------+------------+");
        System.out.printf("| %-5s | %-15s | %-15s | %-22s | %-10s | %-10s |\n", "ID", "Name", "Phone Number", "Company", "Salary", "Birthday");
        System.out.println("+-------+-----------------+-----------------+------------------------+------------+------------+");

        for (int i = 0; i < contactList.getContactArray().length; i++) {
            System.out.printf("| %-5s | %-15s | %-15s | %-22s | %-10s | %-10s |\n", sortContactArray[i].getIdNo(),sortContactArray[i].getName(),sortContactArray[i].getTpNo(),sortContactArray[i].getComName(),sortContactArray[i].getSal(),sortContactArray[i].getBday());
        }
        System.out.println("+-------+-----------------+-----------------+------------------------+------------+------------+");
        System.out.print("Do you want to go home page (Y/N) : ");
        String replyPrintable = inputPrintable.nextLine();
        if(replyPrintable.equals("Y")){
            clearConsole();
            homePage();
        }if(replyPrintable.equals("N")){
            clearConsole();
            listContact();
        }
    }
    public static int compareNames(String name1, String name2) {
        String lowerCaseName1 = name1.toLowerCase();
        String lowerCaseName2 = name2.toLowerCase();
        int minLength = Math.min(lowerCaseName1.length(), lowerCaseName2.length());
        for (int i = 0; i < minLength; i++) {
            char char1 = lowerCaseName1.charAt(i);
            char char2 = lowerCaseName2.charAt(i);
            if (char1 != char2) {
                return char1 - char2;
            }
        }
        return lowerCaseName1.length() - lowerCaseName2.length();
    }
    public static int compareBirthdays(String date1, String date2) {
        if (!isbodValid(date1) || !isbodValid(date2)) {
            return 0;
        }
        int year1 = Integer.parseInt(date1.substring(0, 4));
        int month1 = Integer.parseInt(date1.substring(5, 7));
        int day1 = Integer.parseInt(date1.substring(8, 10));

        int year2 = Integer.parseInt(date2.substring(0, 4));
        int month2 = Integer.parseInt(date2.substring(5, 7));
        int day2 = Integer.parseInt(date2.substring(8, 10));

        if (year1 < year2) {
            return -1;
        } else if (year1 > year2) {
            return 1;
        } else {
            if (month1 < month2) {
                return -1;
            } else if (month1 > month2) {
                return 1;
            } else {

                if (day1 < day2) {
                    return -1;
                } else if (day1 > day2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}
