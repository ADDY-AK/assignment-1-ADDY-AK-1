import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    ArrayList<Person> contactlist;
    private int top = 0;

    public ContactList() {
        this.contactlist = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        int i = 0;
        ContactList list = new ContactList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("enter 1 to Add new contact");
            System.out.println("enter 2 to View all contact");
            System.out.println("enter 3 for Search for a contact");
            System.out.println("enter 4 for Delete a contact");
            System.out.println("enter 5 fo exit");

            System.out.println("enter your choice");
            try {
                i = sc.nextInt();
            } catch (Exception e) {
                System.out.println("NIKKAL PAHKE PHURSAT SE NIKAL");
                break;
            }
            switch (i) {
                case 1:
                    list.AddContact();
                    break;
                case 2:
                    list.viewContacts();
                    break;
                case 3:
                    list.SearchContact();
                    break;
                case 4:
                    list.DeleteNumber();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("BBAAAKKKK....");
                    break;
            }
        }
    }

    public void AddContact() {
        Scanner sc = new Scanner(System.in);
        String FirstName;
        String LastName;
        String eMail = "";
        String Number;
        System.out.println("First Name:");
        FirstName = sc.next();
        System.out.println("Last Name:");
        LastName = sc.next();
        while (true) {
            System.out.println("enter (y/n) for entering email");
            String s = sc.next();
            char ch = s.charAt(0);
            if (ch == 'y') {
                System.out.println("Email:");
                eMail = sc.next();
                break;
            } else if (ch == 'n') {
                break;
            } else {
                System.out.println("please check your eye's and enter again");
            }
        }
        System.out.println("Phone Number:");
        Number = sc.next();
        while (true) {
            System.out.println("enter (y/n) for entering more number");
            String s = sc.next();
            char ch = s.charAt(0);
            if (ch == 'y') {
                System.out.println("Phone Number:");
                Number = Number + " , " + sc.next();
            } else if (ch == 'n') {
                break;
            } else {
                System.out.println("please check your eye's and enter again");
            }
        }
        Contact entry = new Contact(FirstName, LastName, eMail, Number);
        contactlist.add(entry);
        top++;
        bubblesort(contactlist);

    }

    public void viewContacts() {
        int flag = 0;
        if (top > 0) {
            for (int index = 0; index < top; index++) {
                System.out.println((index + 1) + "> First Name:-" + contactlist.get(index).getFirstName());
                System.out.println("Last Name:-" + contactlist.get(index).getLastName());
                System.out.println("E-mail:-" + contactlist.get(index).geteMail());

                for (int i = 0; i < contactlist.get(index).getNumber().length(); i++) {
                    if (contactlist.get(index).getNumber().charAt(i) == ',') {
                        flag++;
                        break;
                    }
                }
                if (flag == 1) {
                    System.out.println("Number(s):-" + contactlist.get(index).getNumber());
                } else {
                    System.out.println("Number:-" + contactlist.get(index).getNumber());
                }
            }
        } else
            System.out.println("contact list is empty");
    }

    public void SearchContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the searching name");
        String str = sc.next();
        if (top > 0) {
            for (int index = 0; index < top; index++) {
                if (contactlist.get(index).getFirstName().equals(str)) {
                    System.out.println((index + 1) + "> First Name:-" + contactlist.get(index).getFirstName());
                    System.out.println("Last Name:-" + contactlist.get(index).getLastName());
                    System.out.println("E-mail:-" + contactlist.get(index).geteMail());
                    System.out.println("Number:-" + contactlist.get(index).getNumber());

                }
            }
        } else
            System.out.println("contact list empty");
    }

    //Contact1 entry=new Contact(FirstName,LastName,eMail,Number);
        /*List<Person> result = new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the searching name");
        String str=sc.next();
        for (Person p:contactlist)
            if (p.getFirstName().equals(str)) {
                result.add(p);
            }
        System.out.println(result);  */
    public void DeleteNumber() {
        Scanner sc = new Scanner(System.in);
        viewContacts();
        System.out.println("Enter the number to delete");
        int s = sc.nextInt();
        if (top > 0) {
            for (int index = 0; index < top; index++) {
                if (index == s - 1) {
                    contactlist.remove(contactlist.get(index));
                    System.out.println("number deleted");
                    top--;
                }
                //  if (contactlist.get(index).getFirstName().equals(s)) {
                //   contactlist.remove(contactlist.get(index));
                //    top--;
                //    System.out.println("contact deleted");
            }
        } else
            System.out.println("contact list is empty");
    }

    public void bubblesort(ArrayList<Person> arrayList) {
        if (arrayList.size() > 1) {
            Person temp;
            for (int i = 0; i < arrayList.size() - 1; i++) {
                for (int j = 0; j < arrayList.size() - 1 - i; j++) {
                    if ((arrayList.get(i).getFirstName()).compareTo(arrayList.get(i + 1).getFirstName()) > 0) {
                        temp = arrayList.get(i);
                        arrayList.set(i, arrayList.get(i + 1));
                        arrayList.set(i + 1, temp);
                    }
                }
            }
        }
    }
}
