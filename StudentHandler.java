import java.util.*;
class StudentHandler
{
    private static LinkedList<Student> list=new LinkedList<>();
    private static Scanner sc=new Scanner(System.in);
    public static void main()
    {
        int ch=1;

        while(ch==1||ch==2)
        {
            ch=displayMenu();
            switch(ch)
            {
                case 1://add students
                while(true)
                {
                    System.out.println(list.size()+" students added.....\n");
                    System.out.println("Add student details....(enter blank name to stop adding students)");
                    System.out.print("Enter name\t");
                    sc.nextLine();
                    String name=sc.nextLine();
                    if(name.equals(""))
                    {
                        System.out.println();
                        break;
                    }
                    System.out.print("Enter rollNo\t");
                    String rno=sc.nextLine();
                    System.out.println("Enter marks-(in case of absent or not available enter 0)");
                    System.out.print("st1 - ");
                    double st1=sc.nextDouble();
                    System.out.print("st2 - ");
                    double st2=sc.nextDouble();
                    System.out.print("ct1 - ");
                    double ct1=sc.nextDouble();
                    System.out.print("ct2 - ");
                    double ct2=sc.nextDouble();
                    System.out.print("ct3 - ");
                    double ct3=sc.nextDouble();
                    list.add(new Student(name,rno,st1,st2,ct1,ct2,ct3));
                    System.out.println();
                }
                sort();
                break;
                case 2:

                printList();
                break;
            }
        }
    }

    private static int displayMenu()
    {

        System.out.println("Enter 1 to add students' details");
        System.out.println("Enter 2 to print the list");
        System.out.println("Enter any other number to exit the program");
        int c=sc.nextInt();
        return c;
    }

    private static void sort()
    {
        boolean flag;
        for(int i=1;i<list.size();i++)
        {
            flag=true;
            for(int j=0;j<list.size()-i;j++)
            {
                if(list.get(j).getRno().compareTo(list.get(j+1).getRno())>0)
                {
                    Student temp=list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                    flag=false;
                }
            }
            if(flag)
                break;
        }
    }

    private static void printList()
    {
        int gapRno=7,gapName=26,gapMarks=3;
        int line=32+gapRno+gapName+5*(gapMarks);
        System.out.println("\n"+disChar('-',line));
        System.out.println("Roll No."+disChar(' ',gapRno)+"Name"+disChar(' ',gapName)+"ST1"+disChar(' ',gapMarks)+"ST2"+disChar(' ',gapMarks)+"CT1"+disChar(' ',gapMarks)+"CT2"+disChar(' ',gapMarks)+"CT3"+disChar(' ',gapMarks)+"ETM");
        System.out.println(disChar('-',line));
        for(Student i:list)
        {
            System.out.println(i.getRno()+disChar(' ',8+gapRno-i.getRno().length())+i.getName()+disChar(' ',4+gapName-i.getName().length())+i.getSt1()+disChar(' ',3+gapMarks-String.valueOf(i.getSt1()).length())+i.getSt2()+disChar(' ',3+gapMarks-String.valueOf(i.getSt2()).length())+i.getCt1()+disChar(' ',3+gapMarks-String.valueOf(i.getCt1()).length())+i.getCt2()+disChar(' ',3+gapMarks-String.valueOf(i.getCt2()).length())+i.getCt3()+disChar(' ',3+gapMarks-String.valueOf(i.getCt3()).length())+i.getEtm());
        }
        System.out.println(disChar('-',line)+"\n");
    }

    private static String disChar(char ch,int lim)
    {
        if(lim<=0)
            return "";
        return ""+ch+disChar(ch,lim-1);
    }
}