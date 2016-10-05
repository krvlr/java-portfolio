package itis;

public class Q <X extends B, Y extends D, Z extends B>{
    public X x;
    public Y y;
    public Z z;

    Q(X x, Y y, Z z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    int allCalc() {
        return x.calc2() + y.calc() + z.calc2();
    }
}
