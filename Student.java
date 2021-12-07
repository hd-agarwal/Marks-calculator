class Student //POJO
{
    private double st1,st2,ct1,ct2,ct3; //Test marks
    private String name,rno; //Personal details
    private double etm; //End term marks
    Student(String name,String rno,double st1,double st2,double ct1,double ct2,double ct3)//Constructor
    {
        this.name=name;
        this.rno=rno;
        this.st1=st1;
        this.st2=st2;
        this.ct1=ct1;
        this.ct2=ct2;
        this.ct3=ct3;
        this.etm=Math.max(st1,st2)+(ct1+ct2+ct3)-Math.min(ct1,Math.min(ct2,ct3));
    }
    public String getRno()
    {
        return this.rno;
    }
    public String getName()
    {
        return this.name;
    }
    public double getEtm()
    {
        return this.etm;
    }
    public double getSt1()
    {
        return this.st1;
    }
    public double getSt2()
    {
        return this.st2;
    }
    public double getCt1()
    {
        return this.ct1;
    }
    public double getCt2()
    {
        return this.ct2;
    }
    public double getCt3()
    {
        return this.ct3;
    }
}