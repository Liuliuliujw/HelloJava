package oop;

/**
 * 访问修饰符    本类    同包   子类(其他包的)  其他包
 * private      *
 * 默认          *      *
 * protected    *      *        *
 * public       *      *        *          *
 *
 * @author llliujw
 */
public class Clazz3 {
    private int privateVar = 1;
    protected int protectedVar = 2;
    int var = 3;
    public int publicVar = 4;

    public void setPrivateVar(int privateVar) {
        this.privateVar = privateVar;
    }

    public int getPrivateVar() {
        return privateVar;
    }
}
