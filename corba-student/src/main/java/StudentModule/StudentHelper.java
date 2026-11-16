package StudentModule;

/**
 * Generated from Student.idl — Helper class for narrowing and type operations.
 */
public abstract class StudentHelper {

    private static String _id = "IDL:StudentModule/Student:1.0";

    public static String id() {
        return _id;
    }

    public static Student narrow(org.omg.CORBA.Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof Student) {
            return (Student) obj;
        } else if (!obj._is_a(id())) {
            throw new org.omg.CORBA.BAD_PARAM();
        } else {
            org.omg.CORBA.portable.Delegate delegate =
                ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate();
            _StudentStub stub = new _StudentStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }

    public static Student unchecked_narrow(org.omg.CORBA.Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof Student) {
            return (Student) obj;
        } else {
            org.omg.CORBA.portable.Delegate delegate =
                ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate();
            _StudentStub stub = new _StudentStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }
}
